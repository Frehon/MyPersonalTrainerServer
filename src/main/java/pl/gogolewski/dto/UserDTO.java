package pl.gogolewski.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.gogolewski.entity.User;

@Data
@NoArgsConstructor
public class UserDTO {

    public Long Id;
    public String userName;
    public String birthDate;
    public String gender;
    public String email;
    public String passwordHash;
    public int weight;
    public int height;
    public double activityFactor;
    public String dietType;
    public int caloriesAmount;
    public int proteinAmount;
    public int carbsAmount;
    public int fatAmount;

    public static User convert_DTO_USER(UserDTO userToConvert) {
        return new User.UserBuilder()
                .Id(userToConvert.Id)
                .userName(userToConvert.userName)
                .gender(userToConvert.gender)
                .birthDate(userToConvert.birthDate)
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
}