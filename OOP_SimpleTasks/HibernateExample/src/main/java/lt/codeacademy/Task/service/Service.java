package lt.codeacademy.Task.service;

import lt.codeacademy.Task.entity.Book;
import lt.codeacademy.Task.repository.Repository;
import lt.codeacademy.entity.User;
import lt.codeacademy.repository.UserRepository;

public class Service {

    private final Repository repository;

    public Service() {
        repository = new Repository();
    }

    public void createUser() {
        Book book = new Book(null, "The Personal Librarian", "Marie", "Benedict", "History", "2021");
        repository.createBook(book);
    }

    public void showAllBooks() {
        repository.getBooks().forEach(System.out::println);
    }

    public void showBookById(Long id) {
        System.out.println(repository.getBookById(id));
    }

    public void showBooksByTittle(String title) {
        System.out.println(repository.getBooksByTitle(title));
    }
}
