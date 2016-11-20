package pl.gogolewski.dto;


import pl.gogolewski.entity.Product;
import java.util.List;

public class MealDTO {
    public Long id;
    public String mealName;
    public Long userId;
    public String date;
    public List<Product> products;

    public Long getId() {return id;}

    public String getMealName() {return mealName;}

    public Long getUserId() {return userId;}

    public String getDate() {return date;}

    public List<Product> getProducts() {return products;}

    public void setId(Long id) {this.id = id;}

    public void setMealName(String mealName) {this.mealName = mealName;}

    public void setUserId(Long userId) {this.userId = userId;}

    public void setDate(String date) {this.date = date;}

    public void setProducts(List<Product> products) {this.products = products;}

}
