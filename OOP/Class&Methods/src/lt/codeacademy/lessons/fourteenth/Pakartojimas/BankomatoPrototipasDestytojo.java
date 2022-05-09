package lt.codeacademy.lessons.fourteenth.Pakartojimas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankomatoPrototipasDestytojo {
    private static double amount;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankomatoPrototipasDestytojo bankomatoPrototipasDestytojo = new BankomatoPrototipasDestytojo();

        System.out.println("Iveskite saskaitos balansa: ");

        amount = bankomatoPrototipasDestytojo.getCorrectDouble(scanner);
        bankomatoPrototipasDestytojo.checkOutMoney(scanner);
    }

    private void checkOutMoney(Scanner scanner) {
        int counter = 0;
        do {
            System.out.println("Saskaitos likutis: " + amount);
            double sum = getCorrectDouble(scanner);
            if (sum > amount) {
                ++counter;
                System.out.println("Suma per didele");
                // continue praleidzia kas yra zemiau ir soka
                // i while praleidziant counter ir amount
                continue;
            }
            counter = 0;
            amount -= sum;
        } while (amount > 0 && counter != 3);
    }

    /// jie vartotojas iveda bloga reiksme

    private double getCorrectDouble(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Blogai ivesta reiksme, pakartokita");
                // butinas kad is naujo nuskaitytu reiksme
                scanner.nextLine();
            }

        }
    }
}
