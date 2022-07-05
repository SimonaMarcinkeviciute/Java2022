package lt.codeacademy.service;

import lt.codeacademy.entity.Exam;
import lt.codeacademy.entity.ExamGrade;
import lt.codeacademy.entity.ExamQuestion;
import lt.codeacademy.entity.User;
import lt.codeacademy.repository.ExamRepository;
import lt.codeacademy.repository.UserRepository;

import java.util.List;

public class ExaminationService {

    private final ExamRepository examRepository;

    public ExaminationService() {
        examRepository = new ExamRepository();
    }

    public void createExamName(Exam exam) {
        examRepository.createExamName(exam);
    }

    public List<Exam> getExam() {
        return examRepository.getExam();
    }

    public void createExamQuestion(ExamQuestion examQuestion) {
        examRepository.createExamQuestion(examQuestion);
    }
    public List<ExamQuestion> getExamQuestionByExam(Exam exam) {
        return examRepository.getExamQuestionByExam(exam);
    }

    public void updateExamQuestion(ExamQuestion examQuestion) {
        examRepository.updateExamQuestion(examQuestion);
    }

    public void deleteQuestion(ExamQuestion examQuestion) {
        examRepository.deleteQuestion(examQuestion);
    }

    public List<ExamGrade> getExamGrade() {
        return examRepository.getExamGrade();
    }

    public List<User> getStudents() {
        return examRepository.getStudents();
    }

    public List<Long> getExamGradeSum() {
        return  examRepository.getExamGradeSum();

    }





}
