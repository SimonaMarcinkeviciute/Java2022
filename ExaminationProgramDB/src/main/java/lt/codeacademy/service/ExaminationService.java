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

    public Exam createExamName(Exam exam) {

        return examRepository.createExamName(exam);
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

    public Long getExamSum() {

        return examRepository.getExamSum();
    }

    public Long getCorrectStudentAnswersSum() {

        return examRepository.getCorrectStudentAnswersSum();
    }

    public String getCorrectStudentAnswersSumByExam(Exam exam) {

        return examRepository.getCorrectStudentAnswersSumByExam(exam);
    }

    public Long getAllAnswersSum() {

        return examRepository.getAllAnswersSum();
    }

    public String getFirstAnswerSumByExam(Exam exam) {

        return examRepository.getFirstAnswerSumByExam(exam);
    }

    public String getAllAnswersByExamSum(Exam exam) {

        return examRepository.getAllAnswersByExamSum(exam);
    }

    public String getFirstAnswerSum() {

        return examRepository.getFirstAnswerSum();
    }

    public String getSecondAnswerSum() {

        return examRepository.getSecondAnswerSum();
    }

    public String getThirdAnswerSum() {

        return examRepository.getThirdAnswerSum();
    }

    public String getSecondAnswerSumByExam(Exam exam) {

        return examRepository.getSecondAnswerSumByExam(exam);
    }

    public String getThirdAnswerSumByExam(Exam exam) {

        return examRepository.getThirdAnswerSumByExam(exam);
    }

    public Double getCorrectStudentAnswersAVG() {

        return examRepository.getCorrectStudentAnswersAVG();
    }
}
