package pl.gogolewski.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import pl.gogolewski.entity.User;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

@Data
@NoArgsConstructor
public class UserDTO {

    public Long Id;
    public String userName;
    public String birthYear;
    public String gender;
    public String email;
    public String passwordHash;
    public Integer weight;
    public Integer height;
    public Double activityFactor;
    public String dietType;
    public Integer caloriesAmount;
    public Integer proteinAmount;
    public Integer carbsAmount;
    public Integer fatAmount;


    public static User convert_DTO_USER(UserDTO userToConvert) {
        return new User.UserBuilder()
                .Id(userToConvert.Id)
                .userName(userToConvert.userName)
                .gender(userToConvert.gender)
                .birthYear(userToConvert.birthYear)
                .email(userToConvert.email)
                .passwordHash(userToConvert.passwordHash)
                .weight(userToConvert.weight)
                .height(userToConvert.height)
                .activityFactor(userToConvert.activityFactor)
                .dietType(userToConvert.dietType)
                .caloriesAmount(userToConvert.caloriesAmount)
                .proteinAmount(userToConvert.proteinAmount)
                .carbsAmount(userToConvert.carbsAmount)
                .fatAmount(userToConvert.fatAmount)
                .build();
    }

    public static User compareUsers(User oldUser, User user) {

        if(user.getUserName() != null && !user.getUserName().equals(oldUser.getUserName())){
            oldUser.setUserName(user.getUserName());
        }
        if(user.getGender() != null && !user.getGender().equals(oldUser.getGender())){
            oldUser.setGender(user.getGender());
        }
        if(user.getBirthYear() != null && !user.getBirthYear().equals(oldUser.getBirthYear())){
            oldUser.setBirthDate(user.getBirthYear());
        }
        if(user.getEmail() != null && !user.getEmail().equals(oldUser.getEmail())){
            oldUser.setEmail(user.getEmail());
        }
        if(user.getPasswordHash() != null && !user.getPasswordHash().equals(oldUser.getPasswordHash())){
            oldUser.setPasswordHash(user.getPasswordHash());
        }
        if(user.getWeight() != null && !user.getWeight().equals(oldUser.getWeight())){
            oldUser.setWeight(user.getWeight());
        }
        if(user.getHeight() != null && !user.getHeight().equals(oldUser.getHeight())){
            oldUser.setHeight(user.getHeight());
        }
        if(user.getActivityFactor() != null && !user.getActivityFactor().equals(oldUser.getActivityFactor())){
            oldUser.setActivityFactor(user.getActivityFactor());
        }
        if(user.getDietType() != null && !user.getDietType().equals(oldUser.getDietType())){
            oldUser.setDietType(user.getDietType());
        }
        if(user.getCaloriesAmount() != null && !user.getCarbsAmount().equals(oldUser.getCaloriesAmount())){
            oldUser.setCaloriesAmount(user.getCaloriesAmount());
        }
        if(user.getProteinAmount() != null && !user.getProteinAmount().equals(oldUser.getProteinAmount())){
            oldUser.setProteinAmount(user.getProteinAmount());
        }
        if(user.getCarbsAmount() != null && !user.getCarbsAmount().equals(oldUser.getCarbsAmount())){
            oldUser.setCarbsAmount(user.getCarbsAmount());
        }
        if(user.getFatAmount() != null && !user.getFatAmount().equals(oldUser.getFatAmount())){
            oldUser.setFatAmount(user.getFatAmount());
        }
        return oldUser;
    }
    // some test comment
}