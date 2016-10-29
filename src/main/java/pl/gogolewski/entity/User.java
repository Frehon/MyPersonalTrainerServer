package pl.gogolewski.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Table( name  = "Users")
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

    public Integer getWeight() {
        return weight;
    }

    public Integer getHeight() {return height;}

    public Double getActivityFactor() {
        return activityFactor;
    }

    public String getDietType() {
        return dietType;
    }

    public Integer getCaloriesAmount() {
        return caloriesAmount;
    }

    public Integer getProteinAmount() {
        return proteinAmount;
    }

    public Integer getCarbsAmount() {
        return carbsAmount;
    }

    public Integer getFatAmount() {
        return fatAmount;
    }


    public static class UserBuilder {

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

        public UserBuilder weight(Integer userWeight){
            this.weight = userWeight;
            return this;
        }

        public UserBuilder height(Integer userHeight){
            this.height = userHeight;
            return this;
        }

        public UserBuilder activityFactor(Double userActivityFactor){
            this.activityFactor = userActivityFactor;
            return this;
        }

        public UserBuilder dietType(String userDietType){
            this.dietType = userDietType;
            return this;
        }

        public UserBuilder caloriesAmount(Integer userCaloriesAmount){
            this.caloriesAmount = userCaloriesAmount;
            return this;
        }

        public UserBuilder proteinAmount(Integer userProteinAmount){
            this.proteinAmount = userProteinAmount;
            return this;
        }

        public UserBuilder carbsAmount(Integer userCarbsAmount){
            this.carbsAmount = userCarbsAmount;
            return this;
        }

        public UserBuilder fatAmount(Integer userFatAmount){
            this.fatAmount = userFatAmount;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }
}