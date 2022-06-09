package lt.codeacademy.servise;

import jakarta.persistence.criteria.Root;
import lt.codeacademy.data.Gender;
import lt.codeacademy.entity.Address;
import lt.codeacademy.entity.Company;
import lt.codeacademy.entity.Passport;
import lt.codeacademy.entity.User;
import lt.codeacademy.repository.UserRepository;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;

import java.util.List;
import java.util.Set;

public class UserService {
    private final UserRepository repository;

    public UserService() {
        repository = new UserRepository();
    }

    public void createUser() {
        Passport passport = new Passport(null, "569532555", "LTU", Gender.MALE);
        Address address = new Address(null, "Lituania", "Kaunas", "Savanoriu", "LT-gfsds");
        Set<Address> addressesAddress = Set.of(address);

        Company company = new Company("Zuvis ir KO");
        Company company2 = new Company("UAB Petro saldainiai");

        User user = new User(null,
                "Andrius",
                "Baltrunas",
                "andrius.baltrunas@codeacademy.lt",
                passport,
                addressesAddress,
                Set.of(company, company2));

        address.setUser(user);
        company.setUsers(Set.of(user));
        company2.setUsers(Set.of(user));
        repository.createUser(user);
    }

    public void showAllUsers() {
        repository.getUsers().forEach(System.out::println);
    }

    public void showUsersEmails() {
        repository.getUsersEmails().forEach(System.out::println);
    }

    public void showUserById(Long id) {
        System.out.println(repository.getUserById(id));
    }

    public void showUpdateUser() {
        User user = repository.getUserById(1l);

        if(user == null) {
            return;
        }

        user.setName("Petras");
        user.setSurname("Petraitis");
        user.setEmail("p.petraitis@gmail.com");

        repository.updateUser(user);
    }

    public void showUpdateEmailById() {
        repository.updateUserEmailById("jonas.jonaitis@gmail.com", 1l);
    }

    public void deleteUserByEmail(String email) {
        repository.deleteUserByEmail(email);
    }

    public void deleteUser() {
        User user = repository.getUsers().get(0);
        repository.deleteUser(user);
    }

    public void deleteUserById(Long id) {
        User user = new User();
        user.setId(id);
        repository.deleteUser(user);
    }


    public  void showFiltered() {
        repository.getFilteredUsers().forEach(System.out::println);
    }
}
