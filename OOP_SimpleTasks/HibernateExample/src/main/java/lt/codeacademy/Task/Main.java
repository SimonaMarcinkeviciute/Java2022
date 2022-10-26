package lt.codeacademy.Task;

import lt.codeacademy.Task.service.Service;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        service.createUser();
        service.showAllBooks();
        service.showBookById(1L);

        service.showBooksByTittle("The Personal Librarian");

    }
}
