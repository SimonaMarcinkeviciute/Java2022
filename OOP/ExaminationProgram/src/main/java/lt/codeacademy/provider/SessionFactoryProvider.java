package lt.codeacademy.provider;

import lt.codeacademy.entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

public class SessionFactoryProvider {

    private static SessionFactoryProvider instance;
    private final SessionFactory sessionFactory;

    private SessionFactoryProvider() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getORMProperties());

        configuration.addAnnotatedClass(Exam.class);
        configuration.addAnnotatedClass(ExamGrade.class);
        configuration.addAnnotatedClass(ExamQuestion.class);
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(UserAnswer.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryProvider getInstance() {
        if(instance == null) {
            instance = new SessionFactoryProvider();
        }

        return instance;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private Properties getORMProperties(){
        Properties p = new Properties();

        p.put(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        p.put(DRIVER, "org.postgresql.Driver");
        p.put(URL, "jdbc:postgresql://localhost/examination_program");
        p.put(USER, "postgres");
        p.put(PASS, "simona");
        p.put(SHOW_SQL, "true");
        p.put(HBM2DDL_AUTO, "update");

        return p;
    }
}
