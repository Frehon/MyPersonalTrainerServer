package pl.gogolewski.repository;


import org.springframework.data.repository.CrudRepository;
import pl.gogolewski.entity.Training;

public interface TrainingRepository extends CrudRepository<Training,Long>{

    Iterable<Training> findByUserId(Long userId);
}
