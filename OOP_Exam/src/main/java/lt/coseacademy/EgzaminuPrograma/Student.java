package lt.coseacademy.EgzaminuPrograma;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Student {

    private String name;
    private String surname;
    private String accountPassword;
    private Map<Integer, Exam> passedExams;
    private String theAverageOfGrade;

    public Student() {
    }

    public Student(String name, String surname, String accountPassword) {
        this.name = name;
        this.surname = surname;
        this.accountPassword = accountPassword;
    }


    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Map<Integer, Exam> getPassedExams() {
        return passedExams;
    }

    public void setPassedExams(Map<Integer, Exam> passedExams) {
        this.passedExams = passedExams;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public String getTheAverageOfGrade() {
        return theAverageOfGrade;
    }

    public void setTheAverageOfGrade(String theAverageOfGrade) {
        this.theAverageOfGrade = theAverageOfGrade;
    }
}
