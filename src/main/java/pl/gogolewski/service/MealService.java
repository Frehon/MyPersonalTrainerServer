package pl.gogolewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gogolewski.entity.Meal;
import pl.gogolewski.repository.MealRepository;

import java.util.List;


@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    public Meal saveMeal(Meal newMeal){return mealRepository.save(newMeal);}

    public Meal getMealById(Long id) {return mealRepository.findOne(id);}
}
