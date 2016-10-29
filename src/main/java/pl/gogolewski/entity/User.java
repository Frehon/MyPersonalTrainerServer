package pl.gogolewski.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "Users")
@Entity
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    private String userName;
    private String birthDate;
    private String gender;
    private String email;
    private String passwordHash;
    private Integer weight;
    private Integer height;
    private Double activityFactor;
    private String dietType;
    private Integer caloriesAmount;
    private Integer proteinAmount;
    private Integer carbsAmount;
    private Integer fatAmount;

    private User(UserBuilder userBuilder) {
        userName = userBuilder.userName;
        birthDate = userBuilder.birthDate;
        gender = userBuilder.gender;
        email = userBuilder.email;
        passwordHash = userBuilder.passwordHash;
        weight = userBuilder.weight;
        height = userBuilder.height;
        activityFactor = userBuilder.activityFactor;
        dietType = userBuilder.dietType;
        caloriesAmount = userBuilder.caloriesAmount;
        proteinAmount = userBuilder.proteinAmount;
        carbsAmount = userBuilder.carbsAmount;
        fatAmount = userBuilder.fatAmount;
    };

    public Long getId() {
        return Id;
    }

    public String getUserName() {
        return userName;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public double getActivityFactor() {
        return activityFactor;
    }

    public String getDietType() {
        return dietType;
    }

    public int getCaloriesAmount() {
        return caloriesAmount;
    }

    public int getProteinAmount() {
        return proteinAmount;
    }

    public int getCarbsAmount() {
        return carbsAmount;
    }

    public int getFatAmount() {
        return fatAmount;
    }


    public static class UserBuilder {

        private Long Id;
        private String userName;
        private String birthDate;
        private String gender;
        private String email;
        private String passwordHash;
        private int weight;
        private int height;
        private double activityFactor;
        private String dietType;
        private int caloriesAmount;
        private int proteinAmount;
        private int carbsAmount;
        private int fatAmount;


        public UserBuilder Id(Long userId){
            this.Id= userId;
            return this;
        }

        public UserBuilder userName(String userName){
            this.userName = userName;
            return this;
        }

        public UserBuilder birthDate(String userBirthdate){
            this.birthDate = userBirthdate;
            return this;
        }

        public UserBuilder gender(String userGender){
            this.gender = userGender;
            return this;
        }

        public UserBuilder email(String userEmail){
            this.email = userEmail;
            return this;
        }

        public UserBuilder passwordHash(String userPasswordHash){
            this.passwordHash = userPasswordHash;
            return this;
        }

        public UserBuilder weight(int userWeight){
            this.weight = userWeight;
            return this;
        }

        public UserBuilder height(int userHeight){
            this.height = userHeight;
            return this;
        }

        public UserBuilder activityFactor(double userActivityFactor){
            this.activityFactor = userActivityFactor;
            return this;
        }

        public UserBuilder dietType(String userDietType){
            this.dietType = userDietType;
            return this;
        }

        public UserBuilder caloriesAmount(int userCaloriesAmount){
            this.caloriesAmount = userCaloriesAmount;
            return this;
        }

        public UserBuilder proteinAmount(int userProteinAmount){
            this.proteinAmount = userProteinAmount;
            return this;
        }

        public UserBuilder carbsAmount(int userCarbsAmount){
            this.carbsAmount = userCarbsAmount;
            return this;
        }

        public UserBuilder fatAmount(int userFatAmount){
            this.fatAmount = userFatAmount;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}