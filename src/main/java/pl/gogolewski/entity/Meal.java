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
    private String date;
    @ManyToMany(targetEntity = Product.class , fetch = FetchType.EAGER , cascade = CascadeType.ALL)
    private List<Product> products;
    @ElementCollection
    private Map<String , Integer> productsWeight;

    public Long getId() {return Id;}

    public String getMealName() {return mealName;}

    public String getDate() {return date;}

    public List<Product> getProducts() {return products;}

    public Map<String, Integer> getProductsWeight() {return productsWeight;}

    public void setId(Long id) {Id = id;}

    public void setMealName(String mealName) {this.mealName = mealName;}

    public void setDate(String date) {this.date = date;}

    public void setProducts(List<Product> products) {this.products = products;}

    public void setProductsWeight(Map<String, Integer> productsWeight) {this.productsWeight = productsWeight;}
}