package pl.gogolewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gogolewski.entity.Meal;

public interface MealRepository extends CrudRepository<Meal, Long> {

}