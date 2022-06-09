package lt.codeacademy.repository;

import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.function.Consumer;
import java.util.function.Function;

class AbstractRepository {

    private final SessionFactory sessionFactory;

    public AbstractRepository() {
        sessionFactory = SessionFactoryProvider.getInstance().getSessionFactory();
    }


    protected void modifyEntity(Consumer<Session> consumer) {
        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            consumer.accept(session);

            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    public <T> T getResult(Function<Session, T> function) {
        try(Session session = sessionFactory.openSession()) {
            return function.apply(session);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
