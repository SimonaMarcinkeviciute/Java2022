package lt.codeacademy.lessons.thirthyThird.jar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Task1 task = new Task1();

        task.printName(scanner, args);

    }

    private void printName(Scanner scanner, String[] args) {

        String name = getName(args.length > 0 ? args[0] : null, scanner);
        String surname = getSurname(args.length > 1 ? args[1] : null, scanner);

        System.out.printf("Vardas %s, pavarde %s", name, surname);

        }

    private String getName(String nameSurname, Scanner scanner) {

            if(nameSurname == null) {
                System.out.println("Iveskite varda");
                return scanner.nextLine();
            }

        return nameSurname;
    }

    private String getSurname(String nameSurname, Scanner scanner) {
        if (nameSurname == null) {
            System.out.println("Iveskite pavarde");
            return scanner.nextLine();
        }

        return nameSurname;
    }
}
