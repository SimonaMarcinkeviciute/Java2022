package lt.codeacademy.blogApplication.service;

import lt.codeacademy.blogApplication.dto.User;
import lt.codeacademy.blogApplication.entity.UserEntity;
import lt.codeacademy.blogApplication.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(UserEntity.convert(user));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user =userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User by username: %s does not exist", username)));
        return User.convert(user);
    }
}
