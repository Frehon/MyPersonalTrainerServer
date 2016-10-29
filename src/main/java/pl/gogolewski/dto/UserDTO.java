package pl.gogolewski.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.gogolewski.entity.User;

@Data
@NoArgsConstructor
public class UserDTO {

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