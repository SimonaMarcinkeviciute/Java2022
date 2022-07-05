package lt.codeacademy.repository;


import jakarta.persistence.criteria.*;
import lt.codeacademy.data.UserStatus;
import lt.codeacademy.entity.Exam;
import lt.codeacademy.entity.ExamGrade;
import lt.codeacademy.entity.ExamQuestion;
import lt.codeacademy.entity.User;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;


import java.util.List;

public class ExamRepository extends AbstractRepository {

    public void createExamName(Exam exam) {
        modifyEntity(session -> session.persist(exam));
    }

    public List<Exam> getExam() {

        return getValue(session -> session.createQuery("FROM Exam", Exam.class).list());

    }

    public void createExamQuestion(ExamQuestion examQuestion) {
        modifyEntity(session -> session.persist(examQuestion));
    }

    public List<ExamQuestion> getExamQuestionByExam(Exam exam) {

        return getValue(session -> {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<ExamQuestion> query = builder.createQuery(ExamQuestion.class);
            Root<ExamQuestion> root = query.from(ExamQuestion.class);

            query.select(root).where(builder.equal(root.get("exam"), exam));

            return session.createQuery(query).list();
        });
    }

    public void updateExamQuestion(ExamQuestion examQuestion)
    {
        modifyEntity(session -> session.update(examQuestion));
    }

    public void deleteQuestion(ExamQuestion examQuestion) {
        modifyEntity(session -> session.delete(examQuestion));
    }

    public List<ExamGrade> getExamGrade(){
        return getValue(session -> session.createQuery("FROM ExamGrade", ExamGrade.class).list());
    }

    public List<User> getStudents() {

        return getValue(session -> {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

            query.select(root).where(builder.equal(root.get("userStatus"), UserStatus.STUDENTAS));

            return session.createQuery(query).list();
        });
    }

    public List<Long> getExamGradeSum() {

      return getValue(session -> session.createQuery("SELECT SUM(studenteExamGrade), exam FROM ExamGrade WHERE examId = 1", Long.class).list());
    }



}





