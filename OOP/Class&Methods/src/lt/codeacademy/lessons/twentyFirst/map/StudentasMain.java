package lt.codeacademy.lessons.twentyFirst.map;

import java.util.HashMap;
import java.util.Scanner;

public class StudentasMain {

    public static void main(String[] args) {
        StudentasMain studentasMain = new StudentasMain();
        Scanner scanner = new Scanner(System.in);
        studentasMain.option(scanner);

    }

    void board() {
        System.out.println("""
                
                [1] - Ivesti studenta;
                [2] - Gauti studenta pagal numeri;
                [3] - baigti programa.
                """);
    }

    private void option(Scanner scanner) {
        // final mapas neleidzia perrasyti objekto, tuo maciu numeriu.
        final HashMap<String, Studentas> studentInfo = new HashMap<>();
        int numb;
        do {
            board();
            System.out.println("Pasirinkite: ");
            numb = scanner.nextInt();
            switch (numb) {
                case 1 -> studentInfo(scanner, studentInfo);
                // keySet atspausdins visus raktus
                case 2 -> System.out.println(studentInfo.keySet() +" "+ studentInfo.get(studentNumber(scanner)));
                case 3 -> System.out.println("Programa baigta");
            }
        }while (numb != 3);
    }

    private void studentInfo(Scanner scanner, HashMap<String, Studentas> studentInfo) {
        System.out.println("Iveskite studento varda");
        String vardas = scanner.next();
        System.out.println("Iveskite pavarde");
        String pavarde = scanner.next();
        System.out.println("Iveskite studento numeri");
        String numeris = scanner.next();
        System.out.println("Iveskite universiteta");
        String universitetas = scanner.next();
        System.out.println(studentInfo);

        studentInfo.put(numeris, new Studentas(vardas, pavarde, universitetas));
    }

    private String studentNumber(Scanner scanner) {
        System.out.println("Iveskite studento numeri");
        // galima buvo metoda pasirasyti ir patikrinti ar yra toks Id
        //naudoti metoda .containsKey(yrasom key)

        return scanner.next();
    }


}
