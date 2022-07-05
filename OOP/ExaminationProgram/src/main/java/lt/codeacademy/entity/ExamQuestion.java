package lt.codeacademy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "exams_questions")
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    private String question;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;
    private String correctAnswer;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "examId")
    private Exam exam;

    public ExamQuestion(String question, String firstAnswer, String secondAnswer, String thirdAnswer, String correctAnswer) {
        this.question = question;
        this.firstAnswer = firstAnswer;
        this.secondAnswer = secondAnswer;
        this.thirdAnswer = thirdAnswer;
        this.correctAnswer = correctAnswer;
    }

    @Override
    public String toString() {
        return "ExamQuestion{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", firstAnswer='" + firstAnswer + '\'' +
                ", secondAnswer='" + secondAnswer + '\'' +
                ", thirdAnswer='" + thirdAnswer + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", exam=" + exam +
                '}';
    }
}


