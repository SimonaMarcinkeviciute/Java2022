package lt.codeacademy.Task.provider;

import lt.codeacademy.Task.entity.Book;
import lt.codeacademy.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import static org.hibernate.cfg.Environment.*;

import java.util.Properties;

public class SessionFactoryProvider2 {

    private static SessionFactoryProvider2 instance;
    private SessionFactory sessionFactory;

    private SessionFactoryProvider2() {
        Configuration configuration = new Configuration();
        configuration.setProperties(createHibernateProperties());

        //Mapping all entities
        configuration.addAnnotatedClass(Book.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryProvider2 getInstance() {
        if(instance == null) {
            instance = new SessionFactoryProvider2();
        }

        return instance;
    }

    public SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    private Properties createHibernateProperties() {
        Properties p = new Properties();

        p.put(DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        p.put(DRIVER, "org.postgresql.Driver");
        p.put(URL, "jdbc:postgresql://localhost/hibernate");
        p.put(USER, "postgres");
        p.put(PASS, "simona");
        p.put(SHOW_SQL, "true");
        //update kai jau sukurta lentele,
        //update,papildo duomenis
        //create-drop
        p.put(HBM2DDL_AUTO, "update");

        return p;
    }
}
