package lt.codeacademy.repository;


import jakarta.persistence.criteria.*;
import lt.codeacademy.data.UserStatus;
import lt.codeacademy.entity.*;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.stat.Statistics;


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

    public String getExamGradeAvg(Exam exam) {
        //sugalvoti kazka cia

      return getValue(session -> {
          Query query = session.createQuery("SELECT AVG(studenteExamGrade) FROM ExamGrade WHERE exam=:Exam");
          query.setParameter("Exam", exam);

          return query.getSingleResult().toString();
      });
    }

    public Long getExamSum() {
        return getValue(session -> session.createQuery("FROM ExamGrade", ExamGrade.class).stream().count());
    }

    public String getCorrectStudentAnswersSum() {

        return getValue(session -> session.createQuery(
                "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.correctAnswer = ua.studentAnswer")
                .getSingleResult().toString());
    }

    public String getCorrectStudentAnswersSumByExam(Exam exam) {
        return getValue(session -> {
            Query query = session.createQuery(
                            "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.correctAnswer = ua.studentAnswer AND eq.questionId =:Exam");
            query.setParameter("Exam", exam.getExamId());

            return query.getSingleResult().toString();
        });
    }

    public Long getAllAnswersSum() {
        return getValue(session -> session.createQuery("FROM UserAnswer", UserAnswer.class).stream().count());
    }

    public String getFirstAnswerSumByExam(Exam exam) {
        return getValue(session -> {
            Query query = session.createQuery(
                    "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.firstAnswer = ua.studentAnswer AND eq.questionId =:Exam");
            query.setParameter("Exam", exam.getExamId());

            return query.getSingleResult().toString();
        });
    }

    public String getAllAnswersByExamSum(Exam exam) {
        return getValue(session -> {
            Query query = session.createQuery(
                    "SELECT COUNT(ua.studentAnswer) FROM UserAnswer ua WHERE exam=:Exam");
            query.setParameter("Exam", exam);

            return query.getSingleResult().toString();
        });
    }

    public String getFirstAnswerSum() {
        return getValue(session -> {
            Query query = session.createQuery(
                    "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.firstAnswer = ua.studentAnswer");

            return query.getSingleResult().toString();
        });
    }

    public String getSecondAnswerSum() {
        return getValue(session -> {
            Query query = session.createQuery(
                    "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.secondAnswer = ua.studentAnswer");

            return query.getSingleResult().toString();
        });
    }

    public String getThirdAnswerSum() {
        return getValue(session -> {
            Query query = session.createQuery(
                    "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.thirdAnswer = ua.studentAnswer");

            return query.getSingleResult().toString();
        });
    }

    public String getSecondAnswerSumByExam(Exam exam) {
        return getValue(session -> {
            Query query = session.createQuery(
                    "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.secondAnswer = ua.studentAnswer AND eq.questionId =:Exam");
            query.setParameter("Exam", exam.getExamId());

            return query.getSingleResult().toString();
        });
    }

    public String getThirdAnswerSumByExam(Exam exam) {
        return getValue(session -> {
            Query query = session.createQuery(
                    "SELECT COUNT(ua.studentAnswer) FROM ExamQuestion eq, UserAnswer ua WHERE eq.thirdAnswer = ua.studentAnswer AND eq.questionId =:Exam");
            query.setParameter("Exam", exam.getExamId());

            return query.getSingleResult().toString();
        });
    }





}





