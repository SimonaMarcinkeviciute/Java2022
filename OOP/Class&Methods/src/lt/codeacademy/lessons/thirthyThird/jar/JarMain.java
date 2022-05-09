package lt.codeacademy.lessons.thirthyThird.jar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JarMain {
    public static void main(String[] args) {
        JarMain main = new JarMain();
        Scanner scanner = new Scanner(System.in);

        main.menu();

        String action = scanner.nextLine();

        main.selectAction(scanner, action, args);
    }

    private void selectAction(Scanner scanner, String action, String[] args) {
        CalculatorService service = new CalculatorService();

        int a = getCorrectNumber(args.length > 0 ? args[0] : null, scanner);
        int b = getCorrectNumber(args.length > 1 ? args[1] : null, scanner);

        switch (action) {
            case "a" -> System.out.printf("Suma yra %s\n", service.sum(a, b));
            case "b" -> System.out.printf("Skirtumas yra %s\n", service.minus(a, b));
            case "c" ->System.out.printf("Daugymos rezultatas yra %s\n", service.multiply(a, b));
            case "d" ->System.out.printf("Dalybos rezultatas yra %s\n", service.divider(a, b));
            default -> System.out.println("Nera tokio veiksmo");

        }

        System.out.printf("Suma yra: %s\n", service.sum(a, b));
    }

    private int getCorrectNumber(String value, Scanner scanner) {
        try {
            return Integer.parseInt(value);

        } catch (NumberFormatException e) {
        }

        while (true) {
            try {
                System.out.println("Iveskite skaiciu: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Blogas formatas");
                scanner.nextInt();
            }
        }
    }


    private void menu() {
        System.out.println("""
                a. plus
                b. minus
                c. multiply
                d. divide
                """);
    }
}
