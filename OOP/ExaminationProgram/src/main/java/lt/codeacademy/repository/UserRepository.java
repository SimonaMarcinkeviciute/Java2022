package lt.codeacademy.repository;

import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lt.codeacademy.entity.*;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.List;

public class UserRepository extends AbstractRepository{

    public void createUser(User user) {
        modifyEntity(session -> session.persist(user));
    }

    public List<User> getUsers() {

        return getValue(session -> session.createQuery("FROM User", User.class).list());
    }

    public void createUserAnswer(UserAnswer userAnswer) {
        modifyEntity(session -> session.persist(userAnswer));
    }

    public List<UserAnswer> getUserAnswers(User user, Exam exam) {

        return getValue(session -> {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<UserAnswer> query = builder.createQuery(UserAnswer.class);
            Root<UserAnswer> root = query.from(UserAnswer.class);

            Predicate examQuery = builder.equal(root.get("exam"), exam);
            Predicate userQuery = builder.equal(root.get("user"), user);

            query.select(root).where(builder.and(examQuery, userQuery));

            return session.createQuery(query).list();
        });
    }

    public List<UserAnswer> getPassedExamsByUser(User user) {

        return getValue(session -> {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<UserAnswer> query = builder.createQuery(UserAnswer.class);
            Root<UserAnswer> root = query.from(UserAnswer.class);

            query.select(root).where(builder.equal(root.get("user"), user));

            return session.createQuery(query).list();
        });
    }

    public void createUserGrade(ExamGrade examGrade) {
        modifyEntity(session -> session.persist(examGrade));
    }

    public void updateUserAnswers(UserAnswer userAnswer)
    {
        modifyEntity(session -> session.update(userAnswer));
    }

    public void updateUserGrade(ExamGrade examGrade)
    {
        modifyEntity(session -> session.update(examGrade));
    }

    public List<ExamGrade> getUserGrade(User user, Exam exam) {

        return getValue(session -> {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<ExamGrade> query = builder.createQuery(ExamGrade.class);
            Root<ExamGrade> root = query.from(ExamGrade.class);

            Predicate examQuery = builder.equal(root.get("exam"), exam);
            Predicate userQuery = builder.equal(root.get("user"), user);

            query.select(root).where(builder.and(examQuery, userQuery));

            return session.createQuery(query).list();
        });
    }

    public List<ExamGrade> getAllUserGrade(User user) {

        return getValue(session -> {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<ExamGrade> query = builder.createQuery(ExamGrade.class);
            Root<ExamGrade> root = query.from(ExamGrade.class);


            query.select(root).where(builder.equal(root.get("user"), user));

            return session.createQuery(query).list();
        });
    }



}
