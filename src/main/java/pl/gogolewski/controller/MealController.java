package pl.gogolewski.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gogolewski.dto.MealDTO;
import pl.gogolewski.entity.Meal;
import pl.gogolewski.entity.Product;
import pl.gogolewski.service.MealService;
import pl.gogolewski.service.ProductService;
import pl.gogolewski.service.UserService;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private ProductService productService;

    public MealController(@NotNull MealService mealService , @NotNull ProductService productService){
        this.mealService = mealService;
        this.productService = productService;
    }

    @RequestMapping(
            value = "/api/meal",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createNewMeal(@RequestBody MealDTO newMealDTO){
        Meal newMeal = new Meal();
        newMeal.setMealName(newMealDTO.getMealName());
        newMeal.setDate(newMealDTO.getDate());
        newMeal.setUserId(newMealDTO.getUserId());
        newMeal.setProducts(new ArrayList<>());
        newMeal.setProductsWeight(new HashMap<>());
        try {
            mealService.saveMeal(newMeal);
            return new ResponseEntity<>(newMeal, HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/meal/{product_name}/{product_amount}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> addProductToMeal(@PathVariable String product_name , @PathVariable Integer product_amount  , @RequestBody MealDTO meal){
        Meal oldMeal = mealService.getMealById(meal.getId());
        Product selectedProduct = productService.getProductByName(product_name);
        oldMeal.getProducts().add(selectedProduct);
        oldMeal.getProductsWeight().put(selectedProduct.getProductName() , product_amount);
        try {
            oldMeal = mealService.saveMeal(oldMeal);
            return new ResponseEntity<>(oldMeal,HttpStatus.OK);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/meal/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> getUserById(@PathVariable("id") Long Id){
        Meal m =  mealService.getMealById(Id);
        if(m == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(m , HttpStatus.OK);
    }

    
}