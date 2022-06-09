package lt.codeacademy.provider;

import lt.codeacademy.entity.Address;
import lt.codeacademy.entity.Company;
import lt.codeacademy.entity.Passport;
import lt.codeacademy.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import static org.hibernate.cfg.Environment.*;

import java.util.Properties;

public class SessionFactoryProvider {

    private static SessionFactoryProvider instance;
    private SessionFactory sessionFactory;

    private SessionFactoryProvider() {
        Configuration configuration = new Configuration();
        configuration.setProperties(createHibernateProperties());

        //Mapping all entities
        configuration.addAnnotatedClass(User.class);
        configuration.addAnnotatedClass(Passport.class);
        configuration.addAnnotatedClass(Address.class);
        configuration.addAnnotatedClass(Company.class);

        sessionFactory = configuration.buildSessionFactory();
    }

    public static SessionFactoryProvider getInstance() {
        if(instance == null) {
            instance = new SessionFactoryProvider();
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
        p.put(HBM2DDL_AUTO, "create-drop");

        return p;
    }
}
