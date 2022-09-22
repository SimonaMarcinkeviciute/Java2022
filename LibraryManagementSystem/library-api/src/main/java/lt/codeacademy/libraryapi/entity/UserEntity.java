package lt.codeacademy.libraryapi.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.dto.User;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@Entity
@Table(name = "users")
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)
    @Type(type = "uuid-char")
    private UUID id;

    private String name;

    private String surname;

    private String username;

    private String email;

    private String country;

    private String city;

    private String street;

    private String postCode;

    private String phone;

    private String password;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private Set<RoleEntity> roles;

    public UserEntity(UUID id, String name, String surname, String username, String email, String country, String city, String street, String postCode, String phone,
                      String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.country = country;
        this.city = city;
        this.street = street;
        this.postCode = postCode;
        this.phone = phone;
        this.password = password;
       // this.roles = roles;
    }

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
