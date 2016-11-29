package pl.gogolewski.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gogolewski.entity.Training;
import pl.gogolewski.repository.TrainingRepository;

@Service
@Transactional
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;


    public Training createNewTraining(Training newTraining) {
        return trainingRepository.save(newTraining);
    }

    public Iterable<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }
}
