package lt.codeacademy.repository;

import lt.codeacademy.entity.Passport;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class PassportRepository extends AbstractRepository {

    public List<Passport> getPassports() {
        return  getResult(session -> session.createQuery("FROM Passport", Passport.class).list());
    }


}
