package pl.gogolewski.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.gogolewski.dto.MealDTO;
import pl.gogolewski.entity.Meal;
import pl.gogolewski.entity.User;
import pl.gogolewski.service.MealService;
import pl.gogolewski.service.ProductService;
import pl.gogolewski.service.UserService;
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

    public MealController(MealService mealService , ProductService productService , UserService userService){
        this.mealService = mealService;
        this.productService = productService;
        this.userService = userService;
    }

    @RequestMapping(
            value = "/api/meal",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> createNewMeal(@RequestBody MealDTO mealDTO){
        Meal meal = new Meal();
        meal.setMealName(mealDTO.getMealName());
        meal.setDate(mealDTO.getDate());
        meal.setProducts(new ArrayList<>());
        meal.setProductsWeight(new HashMap<>());
        try{
            meal = mealService.saveMeal(meal);
            User loggedUser = userService.getUserById(mealDTO.getUserId());
            loggedUser.getMeals().add(meal);
            userService.saveUser(loggedUser);
            return new ResponseEntity<>(meal,HttpStatus.OK);
        }
        catch(Exception e) {
            System.out.println(e.getMessage()) ;
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/meal/{product_name}/{product_weight}",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Meal> addProductToMeal(@RequestBody MealDTO mealDTO , @PathVariable String product_name , @PathVariable Integer product_weight){
        try{
            Meal selectedMeal = mealService.getMealById(mealDTO.getId());
            if(!selectedMeal.getProductsWeight().containsKey(product_name)){
                selectedMeal.getProducts().add(productService.getProductByName(product_name));
                selectedMeal.getProductsWeight().put(product_name,product_weight);
            }
            else{
               selectedMeal.getProductsWeight().put(product_name , selectedMeal.getProductsWeight().get(product_name) + product_weight);
            }
            selectedMeal = mealService.saveMeal(selectedMeal);
            return new ResponseEntity<Meal>(selectedMeal , HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage()) ;
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(
            value = "/api/meals/{user_id}/{date}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Meal>> getMealsByDateByUserId(@PathVariable Long user_id , @PathVariable String date){
        try{
            List<Meal> meals = new ArrayList<>();
            User selectedUser = userService.getUserById(user_id);
            meals.addAll(selectedUser.getMeals().stream().filter(m -> m.getDate().equals(date)).collect(Collectors.toList()));
            return new ResponseEntity<>(meals , HttpStatus.OK);
        }
        catch(Exception e){
            System.out.println(e.getMessage()) ;
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}