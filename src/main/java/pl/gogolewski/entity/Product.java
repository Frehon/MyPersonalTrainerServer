package pl.gogolewski.entity;

import javax.persistence.*;

@Entity
@Table( name  = "Products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String productName;
    private int caloriesAmount;
    private int proteinAmount;
    private int carbsAmount;
    private int fatAmount;

    public Long getId() {return Id;}

    public void setId(Long id) {Id = id;}

    public String getProductName() {return productName;}

    public void setProductName(String productName) {this.productName = productName;}

    public int getCaloriesAmount() {return caloriesAmount;}

    public void setCaloriesAmount(int caloriesAmount) {this.caloriesAmount = caloriesAmount;}

    public int getProteinAmount() {return proteinAmount;}

    public void setProteinAmount(int proteinAmount) {this.proteinAmount = proteinAmount;}

    public int getCarbsAmount() {return carbsAmount;}

    public void setCarbsAmount(int carbsAmount) {this.carbsAmount = carbsAmount;}

    public int getFatAmount() {return fatAmount;}

    public void setFatAmount(int fatAmount) {this.fatAmount = fatAmount;}
}
