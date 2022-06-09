package lt.codeacademy.repository;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class EmployerRepository {

    private final SessionFactory sessionFactory;

    public EmployerRepository() {
        sessionFactory = SessionFactoryProvider.getInstance().getSessionFactory();
    }

    public List<Employer> getEmployers() {


        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Employer", Employer.class).list();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public void createEmployer(Employer employer) {

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            //tam, kad jei ivyktu kokia nesekme, parrolbackins
            transaction = session.beginTransaction();

            session.persist(employer);

            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }
}
//dedami veiksmai su duomenu baze ki repozitory