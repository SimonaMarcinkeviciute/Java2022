/*package lt.codeacademy.baigiamasisDarbasOOP;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        ExaminationProgram program = new ExaminationProgram();

        main.selectFirstAction(scanner, program);

    }

    private void selectFirstAction(Scanner scanner, ExaminationProgram program) {
        System.out.println("Pasirinkite prisijungima:");
        String action;

        do {
            firstMenu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> program.StudentRegistration(scanner);
                case "4" -> System.out.println("Programa uzdaryta.");
                case "5" -> System.out.println("Programa uzdaryta.");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("4"));

    }

    private void firstMenu() {
        System.out.println("""
                [1] Prisijungimas destytojams
                [2] Prisijungimas studentams
                [3] Registracija studentams
                [4] Iseiti is programos
                """);
    }

    private void selectStudentAction(Scanner scanner, ExaminationProgram program) {
        System.out.println("Pasirinkite prisijungima:");
        String action;

        do {
            studentMenu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> selectFirstAction(scanner, program);
                case "6" -> System.out.println("Programa uzdaryta.");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("6"));
    }

    private void studentMenu() {
        System.out.println("""
                [1] Laikyti testa
                [2] Perziureti info
                [3] Gauti testu vidurki
                [4] Perlaikyti egzamina
                [5] Iseiti i pradzios meniu
                [6] Baigti programa
                """);
    }

    private void selectTeacherAction(Scanner scanner, ExaminationProgram program) {
        System.out.println("Pasirinkite prisijungima:");
        String action;

        do {
            teacherMenu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> System.out.println();
                case "2" -> System.out.println();
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> selectFirstAction(scanner, program);
                case "6" -> System.out.println("Programa uzdaryta.");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("5"));
    }

    private void teacherMenu() {
        System.out.println("""
                [1] Prisijungti
                [2] Perziureti info
                [3] Perziureti studentus ir ju vidurkius
                [4] Paruosti egzamina
                [5] Iseiti i pradios ekrana
                [6] Baigti programa
                """);
    }
}*/
