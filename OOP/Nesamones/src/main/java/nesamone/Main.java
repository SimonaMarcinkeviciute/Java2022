package nesamone;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
       ManoMain program = new ManoMain();

        main.selectFirstAction(scanner, program);
    }

    private void firstMenu() {
        System.out.println("""
                MENU
                [1] Prisijungimas
                [2] Registracija studentams
                [3] Iseiti is programos
                """);
    }

    private void selectFirstAction(Scanner scanner, ManoMain program){
        String action;

        do {
            firstMenu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> System.out.println();
                case "2" -> program.StudentRegistration(scanner);
                case "3" -> System.out.println("Programa uzdaryta.");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("3"));

    }
}
