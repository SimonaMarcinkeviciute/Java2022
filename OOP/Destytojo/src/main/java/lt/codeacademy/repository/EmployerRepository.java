package lt.codeacademy.repository;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.entity.Invoice;
import org.hibernate.query.Query;

import java.util.List;

public class EmployerRepository extends AbstractRepository {
    public void createEmployer(Employer employer) {
        modifyEntity(session -> session.persist(employer));
    }


    public List<Employer> getEmployers() {
        return getValue(session -> session.createQuery("FROM Employer", Employer.class).list());
    }

    public void deleteEmployer(Employer employer) {
        modifyEntity(session -> session.delete(employer));
    }

    public void updateEmployerSalary(Employer employer) {
        modifyEntity(session -> {
            Query query = session.createQuery("update Employer set salary=:salary where id=:id");
            query.setParameter("salary", employer.getSalary());
            query.setParameter("id", employer.getId());

            query.executeUpdate();
        });


    }
}