package pl.gogolewski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gogolewski.dto.TrainingDTO;
import pl.gogolewski.entity.Training;
import pl.gogolewski.service.TrainingService;

@RestController
public class TrainingController {


    @Autowired
    private TrainingService trainingService;

    public TrainingController(TrainingService trainingService){
        this.trainingService = trainingService;
    }

    @RequestMapping(
            value = "/api/training",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Training> createNewTraining(@RequestBody  TrainingDTO trainingDTO){
        Training newTraining = new Training(trainingDTO.getActivityName() , trainingDTO.getDuration() , trainingDTO.getDate()  , trainingDTO.getUserId());
        try{
            newTraining = trainingService.createNewTraining(newTraining);
            return new ResponseEntity<>(newTraining , HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/trainings/{userId}",
            method = RequestMethod.GET ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Training>> getTrainingsByUserId(@PathVariable("userId") Long userId){
        Iterable<Training> userTrainings = trainingService.getAllUserTrainings(userId);
        if(userTrainings == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userTrainings , HttpStatus.OK);
    }

    @RequestMapping(
            value = "api/training/{id}",
            method = RequestMethod.DELETE)
    public ResponseEntity<Training> deleteUser(@PathVariable Long id){
        try{
          trainingService.deleteTraining(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
