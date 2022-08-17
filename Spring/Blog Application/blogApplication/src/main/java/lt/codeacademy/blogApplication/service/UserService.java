package lt.codeacademy.blogApplication.service;

import lt.codeacademy.blogApplication.dto.User;
import lt.codeacademy.blogApplication.entity.UserEntity;
import lt.codeacademy.blogApplication.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(User user) {
        userRepository.save(UserEntity.convert(user));
    }
}
