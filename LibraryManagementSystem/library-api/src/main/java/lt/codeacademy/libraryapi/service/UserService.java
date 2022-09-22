package lt.codeacademy.libraryapi.service;

import lt.codeacademy.libraryapi.controller.UserController;
import lt.codeacademy.libraryapi.dto.Book;
import lt.codeacademy.libraryapi.dto.User;
import lt.codeacademy.libraryapi.entity.BookEntity;
import lt.codeacademy.libraryapi.entity.UserEntity;
import lt.codeacademy.libraryapi.repository.UserRepository;
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
