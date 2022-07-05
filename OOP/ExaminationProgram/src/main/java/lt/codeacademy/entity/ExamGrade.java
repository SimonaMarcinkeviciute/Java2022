package lt.codeacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "exams_grades")
public class ExamGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long examGradeId;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "examId")
    private Exam exam;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;
    private int studenteExamGrade;

    public ExamGrade(int examGrade) {
        this.studenteExamGrade = examGrade;
    }
}
