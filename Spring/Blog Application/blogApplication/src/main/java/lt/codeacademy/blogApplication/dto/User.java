package lt.codeacademy.blogApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.entity.UserEntity;
import lt.codeacademy.blogApplication.validator.annotation.CompareFields;
import lt.codeacademy.blogApplication.validator.annotation.Password;

import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Password
//@CompareFields(first = "password", second = "repeatPassword")
public class User {
    private UUID id;
    @NotBlank
    private String name;
    private String surname;
    private String username;
    private String email;

    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;

    public User(UUID id, String name, String surname, String username, String email) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
    }

    public static User convert(UserEntity entity) {
        return new User(entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getUsername(),
                entity.getEmail());
    }
}
