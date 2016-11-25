package pl.gogolewski.dto;


public class MealDTO {
    public Long id;
    public String mealName;
    public String date;

    public Long getId() {return id;}

    public String getMealName() {return mealName;}

    public String getDate() {return date;}

    public void setId(Long id) {this.id = id;}

    public void setMealName(String mealName) {this.mealName = mealName;}

    public void setDate(String date) {this.date = date;}
}
