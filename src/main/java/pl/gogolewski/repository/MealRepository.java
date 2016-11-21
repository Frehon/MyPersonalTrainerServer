package pl.gogolewski.repository;

import org.springframework.data.repository.CrudRepository;
import pl.gogolewski.entity.Meal;

import java.util.List;

public interface MealRepository extends CrudRepository<Meal, Long> {}