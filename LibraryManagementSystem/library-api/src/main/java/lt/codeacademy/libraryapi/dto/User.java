package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.entity.UserEntity;


import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User  {
    private UUID id;

    private String name;
    private String surname;
    private String username;
    private String email;
    private String country;
    private String city;
    private String street;
    private String postCode;
    //private Set<Role> roles;
    private String phone;

    private String password;

    private String repeatPassword;

    public User(UUID id, String name, String surname, String username, String email, String country, String city, String street, String postCode, String phone, String password) {
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
        //this.roles = roles;
        this.password = password;
    }

    public static User convert(UserEntity entity) {


        return new User(entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getCountry(),
                entity.getCity(),
                entity.getStreet(),
                entity.getPostCode(),
                entity.getPhone(),
                entity.getPassword());
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }

    public String getFullName() {
        return name + " " + surname;
    }

    public User(String name, String surname, String username, String email, String country, String city, String street, String postCode, String phone, String password, String repeatPassword) {
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
        this.repeatPassword = repeatPassword;
    }

    public User(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}


