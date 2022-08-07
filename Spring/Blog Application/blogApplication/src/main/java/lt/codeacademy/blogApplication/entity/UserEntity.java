package lt.codeacademy.blogApplication.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.dto.User;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false)
    private String username;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String postCode;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String password;

    public static UserEntity convert(User user) {
        return new UserEntity(user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getEmail(),
                user.getCountry(),
                user.getCity(),
                user.getStreet(),
                user.getPostCode(),
                user.getPhone(),
                user.getPassword());
    }
}
