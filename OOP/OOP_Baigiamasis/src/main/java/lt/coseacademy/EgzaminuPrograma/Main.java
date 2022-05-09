package lt.coseacademy.EgzaminuPrograma;

import lt.coseacademy.EgzaminuPrograma.program.StudentsExaminationProgram;
import lt.coseacademy.EgzaminuPrograma.program.TeacherExamsProgram;
import lt.coseacademy.EgzaminuPrograma.program.UniversityExamsProgram;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        UniversityExamsProgram studentProgram = new StudentsExaminationProgram();
        UniversityExamsProgram teacherProgram = new TeacherExamsProgram();

        studentProgram.fileReader();
        teacherProgram.fileReader();
        main.selectFirstAction(scanner, studentProgram, teacherProgram);
        teacherProgram.writteExamsToFile();
        studentProgram.writteStudentsToFile();
    }

    public void teachersMenu() {
        System.out.println("""
                                
                MENU
                [1] Sukurti nauja egzamina
                [2] Papildyti jau sukurta egzamina
                [3] Perziureti studentu vidurkius
                [4] Grizti i pradzios menu
                               
                """);
    }

    public void studentsMenu() {
        System.out.println("""
                                
                MENU
                [1] Laikyti testa
                [2] Perlaikyti testa
                [3] Pasiziureti pazymius ir vidurki
                [4] Grizti i pradios menu
                                
                """);
    }

    private void firstMenu() {
        System.out.println("""
                                
                MENU
                [1] Prisijungimas destytojams
                [2] Prisijungimas studentams
                [3] Registracija studentams
                [4] Iseiti is programos
                                
                """);
    }

    public void selectFirstAction(Scanner scanner, UniversityExamsProgram studentProgram, UniversityExamsProgram teacherProgram) {
        String action;

        do {
            firstMenu();
            action = scanner.nextLine();

            switch (action) {
                case "1" -> teacherProgram.login(scanner);
                case "2" -> studentProgram.login(scanner);
                case "3" -> studentProgram.Registration(scanner);
                case "4" -> System.out.println("Programa uzdaryta.");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("4"));
    }
}
