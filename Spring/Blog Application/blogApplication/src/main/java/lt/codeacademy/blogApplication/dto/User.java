package lt.codeacademy.blogApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.blogApplication.entity.UserEntity;
import lt.codeacademy.blogApplication.validator.annotation.CompareFields;
import lt.codeacademy.blogApplication.validator.annotation.Password;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Password
@CompareFields(first = "password", second = "repeatPassword")
public class User implements UserDetails {
    private UUID id;
    @NotBlank
    private String name;
    private String surname;
    private String username;
    private String email;
    private Set<Role> roles;

    @NotBlank
    private String password;
    @NotBlank
    private String repeatPassword;

    public User(UUID id, String name, String surname, String username, String email, Set<Role> roles, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.roles = roles;
        this.password = password;
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
}
