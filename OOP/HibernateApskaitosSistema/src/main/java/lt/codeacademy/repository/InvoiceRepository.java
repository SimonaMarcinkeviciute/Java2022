package lt.codeacademy.repository;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.entity.Invoice;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class InvoiceRepository {

    private final SessionFactory sessionFactory;

    public InvoiceRepository() {
        sessionFactory = SessionFactoryProvider.getInstance().getSessionFactory();
    }

    public void createInvoice(Invoice invoice) {

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(invoice);

            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }
}
