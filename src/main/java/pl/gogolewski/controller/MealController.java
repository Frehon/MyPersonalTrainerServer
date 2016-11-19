package pl.gogolewski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.gogolewski.service.MealService;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;
    
}