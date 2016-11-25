package pl.gogolewski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gogolewski.dto.MealDTO;
import pl.gogolewski.entity.Meal;
import pl.gogolewski.entity.Product;
import pl.gogolewski.entity.User;
import pl.gogolewski.service.MealService;
import pl.gogolewski.service.ProductService;
import pl.gogolewski.service.UserService;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;


@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @Autowired
    private ProductService productService;

    @Autowired
    private UserService userService;

    public MealController(@NotNull  MealService mealService , @NotNull ProductService productService ,@NotNull UserService userService){
        this.mealService = mealService;
        this.productService = productService;
        this.userService = userService;
    }

    @RequestMapping(
            value = "/api/meals/{userId}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Meal>> createNewMeals(@RequestBody List<MealDTO> mealsDTOs , @PathVariable("userId") Long userId){
        List<Meal> newMeals = new ArrayList<>();
        for(MealDTO mealDTO : mealsDTOs){
            Meal newMeal = new Meal();
            newMeal.setMealName(mealDTO.getMealName());
            newMeal.setDate(mealDTO.getDate());
            newMeal.setProducts(new ArrayList<>());
            newMeal.setProductsWeight(new HashMap<>());
            try{
                newMeals.add(mealService.saveMeal(newMeal));
            }
            catch(Exception e){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        try{
            User selectedUser = userService.getUserById(userId);
            selectedUser.getMeals().addAll(newMeals);
            userService.saveUser(selectedUser);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(newMeals , HttpStatus.OK);
    }

    @RequestMapping(
            value = "/api/meal/{meal_id}/{product_id}/{product_weight}",
            method = RequestMethod.PUT,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> updateMeal(@PathVariable("meal_id") Long mealId ,  @PathVariable("product_id") Long productId , @PathVariable("product_weight") int productWeight){
        try{
            Product productToAdd = productService.getProductById(productId);
            Meal mealToUpdate = mealService.getMealById(mealId);
            if(mealToUpdate.getProductsWeight().containsKey(productToAdd.getProductName())){
                mealToUpdate.getProductsWeight().put(productToAdd.getProductName() ,mealToUpdate.getProductsWeight().get(productToAdd.getProductName()) + productWeight);
            }
            else{
                mealToUpdate.getProducts().add(productToAdd);
                mealToUpdate.getProductsWeight().put(productToAdd.getProductName() , productWeight);
            }
            mealService.updateMeal(mealToUpdate);
            return new ResponseEntity<>(mealToUpdate , HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/meals/{userId}/{date}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Meal>> getMealsByDateByUserId(@PathVariable(name = "userId" ) Long userId , @PathVariable(name = "date") String date ){
        try{
            List<Meal> meals = new ArrayList<>();
            User selectedUser = userService.getUserById(userId);
            meals.addAll(selectedUser.getMeals().stream().filter(m -> m.getDate().equals(date)).collect(Collectors.toList()));
            return new ResponseEntity<>(meals , HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}