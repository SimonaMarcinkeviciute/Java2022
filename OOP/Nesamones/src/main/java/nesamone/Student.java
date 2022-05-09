package nesamone;

public class Student{

    private String accountPassword;
    private String name;
    private String surname;
    private Exam exam;

    public Student() {
    }

    public Student(String accountPassword, String name, String surname) {
        this.accountPassword = accountPassword;
        this.name = name;
        this.surname = surname;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }
}
