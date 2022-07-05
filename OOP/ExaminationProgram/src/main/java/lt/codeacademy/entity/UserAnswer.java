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
@Table(name = "users_answers")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long UserAnswerId;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "examId")
    private Exam exam;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "questionId")
    private ExamQuestion examQuestion;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    private String studentAnswer;

    public UserAnswer(String studentAnswer) {
        this.studentAnswer = studentAnswer;
    }
}
