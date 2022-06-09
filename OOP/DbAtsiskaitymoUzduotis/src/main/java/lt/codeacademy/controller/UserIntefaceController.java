package lt.codeacademy.controller;

import lt.codeacademy.data.User;
import lt.codeacademy.service.MoneyTransactionService;

import java.util.List;
import java.util.Scanner;

public class UserIntefaceController {

    Scanner scanner = new Scanner(System.in);
    MoneyTransactionService transactionService = new MoneyTransactionService();
    User newUser;

    private void signIn() {
        System.out.println("Prisijungimui naudokite savo pavarde");
        String surname = scanner.nextLine();
        transactionService.addUserToList();
        List<User> users = transactionService.getUsers();
        for (User user : users) {
            if (user.getSurname().equals(surname)) {
                newUser = new User(user.getName(), user.getSurname(), user.getBankAccountBalance());
                System.out.println("Sveikiname prisijungus");
                return;
            }
        }
        sendMoney(newUser);
    }

    private void sendMoney(User user) {
        System.out.println();
        transactionService.addUserToList();
        List<User> users = transactionService.getUsers();

        System.out.println("Pasirinkite vartotojap,pagal pavarde, kuriam pervesite pinigus");
        String surname = scanner.nextLine();
        System.out.println("Iveskite pinigu suma");
        Integer sum = scanner.nextInt();
        for (User user1 : users) {
            if (!user1.getSurname().equals(user.getSurname())) {
                System.out.println(user1.getName() + " " + user1.getSurname());
            }
        }

        for (User user1 : users) {
            if (!user1.getSurname().equals(surname)) {
               sum = user1.getBankAccountBalance() - sum;
                user1.setBankAccountBalance(sum);
            }
        }
    }

    private void registration() {
        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite savo pavarde");
        String surname = scanner.nextLine();
        System.out.println("Nurodykite saskaitos likuti");
        Integer balance = getCorrectNumber();

        User user = new User(name, surname, balance);
        transactionService.addUserToDb(user);
    }

    private Integer getCorrectNumber() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Incorrect number, please try again");
            }
        }
    }

    public void startApplication() {
        String action;
        do {
            showMenu();
            action = scanner.nextLine();
            selectAction(action);
        } while (!action.equals("3"));
    }

    private void showMenu() {
        System.out.println("""
                1. Registracija
                2. Prisijungimas ir pervesti pasirinkta pinigu suma
                3. Iseiti is programos
                """);
    }

    private void selectAction(String action) {
        switch (action) {
            case "1" -> registration();
            case "2" -> signIn();
            case "3" -> System.out.println("Programa uzdaryta");
            default -> System.out.println("Toks veiksmas neegzistuoja");
        }
    }
}
