package lt.codeacademy.libraryapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.libraryapi.entity.UserEntity;
import lt.codeacademy.libraryapi.validator.annotation.CompareFields;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@CompareFields(first = "password", second = "repeatPassword")
public class User implements UserDetails {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotBlank
    private String username;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phone;
    @NotBlank

    private String password;
    @NotBlank

    private String repeatPassword;

    private Set<Role> roles;

    public User(UUID id, String name, String surname, String username, String email, String phone, Set<Role> roles, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.roles = roles;
        this.password = password;
    }

    public User(String name, String surname, String username, String email, String phone, String password, String repeatPassword) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    public static User convert(UserEntity entity) {

        Set<Role> roles = entity.getRoles().stream()
                .map(Role::convert)
                .collect(Collectors.toSet());


        return new User(entity.getId(),
                entity.getName(),
                entity.getSurname(),
                entity.getUsername(),
                entity.getEmail(),
                entity.getPhone(),
                roles,
                entity.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getFullName() {
        return name + " " + surname;
    }
}


