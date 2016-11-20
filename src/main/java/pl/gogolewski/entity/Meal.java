package pl.gogolewski.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Map;

@Entity
@Table( name  = "Meals")
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String mealName;

    @OneToMany(targetEntity = Product.class , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    @JoinColumn(name = "meal_id")
    private List<Product> products;
    @ElementCollection
    private Map<String , Integer> productsWeight;

    private Long userId;

    private String date;

    public Long getId() {return Id;}

    public void setId(Long id) {Id = id;}

    public String getMealName() {return mealName;}

    public void setMealName(String mealName) {this.mealName = mealName;}

    public List<Product> getProducts() {return products;}

    public void setProducts(List<Product> products) {this.products = products;}

    public Map<String, Integer> getProductsWeight() {return productsWeight;}

    public void setProductsWeight(Map<String, Integer> productAmounts) {this.productsWeight = productAmounts;}

    public Long getUserId() {return userId;}

    public void setUserId(Long userId) {this.userId = userId;}

    public String getDate() {return date;}

    public void setDate(String date) {this.date = date;}
}