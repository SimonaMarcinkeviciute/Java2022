package lt.coseacademy.EgzaminuPrograma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;
import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Exam {
    private String examName;
    private ExamTypes type;
    private Map<String, String[]> questionsAndAnswers;
    private Map<String, String> questionsAndCorrectAnswers;
    private String grade;
    private List<String[]> studentAnswers;
    private ExamStatus examStatus;
    private String dateOfTheExamination;

    public Exam() {
    }

    public Exam(String examName, ExamTypes type, Map<String, String[]> questionsAndAnswers, Map<String, String> questionsAndCorrectAnswers) {
        this.examName = examName;
        this.type = type;
        this.questionsAndAnswers = questionsAndAnswers;
        this.questionsAndCorrectAnswers = questionsAndCorrectAnswers;
    }

    public Exam(String examName, ExamTypes type, List<String[]> studentAnswers, ExamStatus examStatus, String grade, String dateOfTheExamination) {
        this.examName = examName;
        this.type = type;
        this.studentAnswers =studentAnswers;
        this.examStatus = examStatus;
        this.grade = grade;
        this.dateOfTheExamination = dateOfTheExamination;

    }

    public List<String[]> getStudentAnswers() {
        return studentAnswers;
    }

    public String getDateOfTheExamination() {
        return dateOfTheExamination;
    }

    public ExamStatus getExamStatus() {
        return examStatus;
    }

    public void setExamStatus(ExamStatus examStatus) {
        this.examStatus = examStatus;
    }

    public ExamTypes getType() {
        return type;
    }

    public Map<String, String[]> getQuestionsAndAnswers() {
        return questionsAndAnswers;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Map<String, String> getQuestionsAndCorrectAnswers() {
        return questionsAndCorrectAnswers;
    }

    public String getExamName() {
        return examName;
    }
}
