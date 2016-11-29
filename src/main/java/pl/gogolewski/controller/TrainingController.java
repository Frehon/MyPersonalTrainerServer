package pl.gogolewski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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
        Training newTraining = new Training(trainingDTO.getActivityName() , trainingDTO.getDuration() , trainingDTO.getUserId());
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
            value = "/api/trainings",
            method = RequestMethod.GET ,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Iterable<Training>> getAllUsers(){
        Iterable<Training> allTrainings = trainingService.getAllTrainings();
        if(allTrainings == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(allTrainings , HttpStatus.OK);
    }
}
