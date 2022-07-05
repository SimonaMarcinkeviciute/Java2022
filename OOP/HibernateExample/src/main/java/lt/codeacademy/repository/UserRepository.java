package lt.codeacademy.repository;

import jakarta.persistence.criteria.Root;
import lt.codeacademy.entity.User;
import lt.codeacademy.provider.SessionFactoryProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UserRepository extends AbstractRepository {


    public void createUser(User user) {

        modifyEntity(session -> session.persist(user));
        /*Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.persist(user);

            transaction.commit();
        } catch(Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }*/
    }

    public void updateUser(User user) {

        modifyEntity(session -> session.update(user));

        /*Transaction transaction = null;
        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            session.update(user);
            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();
            if(transaction != null) {
                transaction.rollback();
            }
        }*/
    }

    public void updateUserEmailById(String email, Long id) {

        modifyEntity(session -> {
            Query query = session.createQuery("update User set email=:email where id=:id");
            query.setParameter("email", email);
            query.setParameter("id", id);

            query.executeUpdate();
        });
        /*Transaction transaction = null;

        try(Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();

            Query query = session.createQuery("update User set email=:email where id=:id");
            query.setParameter("email", email);
            query.setParameter("id", id);

            query.executeUpdate();

            transaction.commit();
        }catch (Exception e) {
            e.printStackTrace();

            if(transaction != null) {
                transaction.rollback();
            }
        }*/
    }

    public List<User> getUsers() {

        return getResult(session -> session.createQuery("FROM User", User.class).list());

        /*
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM User", User.class).list();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList(); */
    }

    public List<String> getUsersEmails() {

        return getResult(session -> session.createQuery("SELECT email FROM User ", String.class).list());

        /*try (Session session = sessionFactory.openSession()) {
            return  session.createQuery("SELECT email FROM User", String.class).list();
        }catch (Exception e) {
            e.printStackTrace();
        }

        return Collections.emptyList();*/
    }

    public User getUserById(Long id) {

        return getResult(session -> session.get(User.class, id));

        /*try(Session session = sessionFactory.openSession()) {
            return session.get(User.class, id);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return null;*/
    }

    public void deleteUser(User user) {
        modifyEntity(session -> session.delete(user));


    }

    public void deleteUserByEmail(String email) {
        modifyEntity(session -> {
                    Query query = session.createQuery("delete User where email=:email");
                    query.setParameter("email", email);
                }
        );

    }

    public List<User> getFilteredUsers() {
        return getResult(session -> {
            HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
            JpaCriteriaQuery<User> query = builder.createQuery(User.class);
            Root<User> root = query.from(User.class);

            //query.select(root);
            //query.select(root).where(builder.like(root.get("name"), "And%"));
            //query.select(root).where(builder.equal(root.get("id"), 2));

            //Predicate equal = builder.equal(root.get("name"), "Andrius");
           // Predicate like = builder.like(root.get("surname"), "%al%");
           // Predicate


            return session.createQuery(query).list();
        });


    }


}
