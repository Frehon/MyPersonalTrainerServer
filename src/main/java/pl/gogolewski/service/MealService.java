package pl.gogolewski.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.gogolewski.repository.MealRepository;


@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

}
