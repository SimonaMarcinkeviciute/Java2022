package lt.codeacademy.Task.repository;

import lt.codeacademy.Task.entity.Book;
import lt.codeacademy.Task.provider.SessionFactoryProvider2;
import lt.codeacademy.entity.User;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class Repository {

    private final SessionFactory sessionFactory;

    public Repository() {
        sessionFactory = SessionFactoryProvider2.getInstance().getSessionFactory();
    }

    public void createBook(Book book) {

        Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(book);

            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }
    }

    public List<Book> getBooks(){

        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Book", Book.class).list();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }

    public Book getBookById(Long id) {

        try(Session session = sessionFactory.openSession()) {
            return session.get(Book.class, id);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public Book getBooksByTitle(String title) {

        try(Session session = sessionFactory.openSession()) {
            return session.get(Book.class, title);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
