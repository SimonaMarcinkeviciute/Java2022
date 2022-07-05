package lt.codeacademy.service;

import lt.codeacademy.entity.*;
import lt.codeacademy.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserService {

    private final UserRepository userRepository;

    public UserService() {
        userRepository = new UserRepository();
    }

    public void createUser(User user) {
        userRepository.createUser(user);
    }

    public List<User> getUser() {
        return userRepository.getUsers();
    }

    public void createUserAnswer(UserAnswer userAnswer) {
        userRepository.createUserAnswer(userAnswer);
    }

    public List<UserAnswer> getUserAnswers(User user, Exam exam) {
        return userRepository.getUserAnswers(user, exam);
    }

    public Set<Exam> getPassedExamsByUser(User user) {

        List<UserAnswer> userAnswers = userRepository.getPassedExamsByUser(user);

        Set<Exam> uniqueExam = new HashSet<>();
        for (UserAnswer userAnswer : userAnswers) {
            uniqueExam.add(userAnswer.getExam());
        }

        return uniqueExam;
    }

    public void createUserGrate(ExamGrade examGrade) {
        userRepository.createUserGrade(examGrade);
    }

    public void updateUserAnswers(UserAnswer userAnswer) {
        userRepository.updateUserAnswers(userAnswer);
    }

    public void updateUserGrade(ExamGrade examGrade) {
        userRepository.updateUserGrade(examGrade);
    }

    public List<ExamGrade> getUserGrade(User user, Exam exam) {
        return userRepository.getUserGrade(user, exam);
    }

    public List<ExamGrade> getAllUserGrade(User user) {
        return userRepository.getAllUserGrade(user);
    }
}
