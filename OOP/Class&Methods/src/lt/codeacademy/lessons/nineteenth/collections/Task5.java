package lt.codeacademy.lessons.nineteenth.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Task5 task5 = new Task5();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> texts = new ArrayList<>();

        task5.choises(scanner, texts);
    }
// i parametrus siusti ne ArrayList o List
    private void choises(Scanner scanner, ArrayList<String> texts) {
        board();
        String number = scanner.nextLine();

        switch (number) {
            case "1" -> {
                System.out.println("Sukurtas sarasas" + arrayList(scanner, texts));
                System.out.println("-------------------------------");
                choises(scanner, texts);
            }
            case "2" -> {
                System.out.println("Zodis sarase yra numeriu: " + printWordNumber(texts, scanner));
                System.out.println("-------------------------------");
                choises(scanner, texts);
            }
            case "3" -> {
                System.out.println("Naujas sarasas " + deleteWord(texts, scanner));
                System.out.println("-------------------------------");
                choises(scanner, texts);
            }
            case "4" -> {
                System.out.println("Naujas sarasas" + deleteCollection(texts));
                System.out.println("-------------------------------");
                choises(scanner, texts);
            }
            case "5" -> System.out.println("Programos pabaiga");
        }
    }

    private void board() {
        System.out.println("""
                Pasirinkite:
                1- įvesti žodį - leidžia įvesti žodį, kuris išsaugomas į sąrašą
                2- rasti žodį - randa žodį ir atspausdina kelintas jis yra sąraše
                3- trinti žodį - paklausia, kokį žodį ištrinti ir jį ištrina
                4- išvalyti sąrašą
                5- baigti programą
                """);
    }
// nereikia grazinti naujo list, nes jis jau atmintyje pasikeicia
    private ArrayList<String> arrayList(Scanner scanner, ArrayList<String> texts) {
        String text = "";

        do {
            System.out.println("Pridekite norimus zodzius, programai uzbaigti parasykite exit");
            text = scanner.nextLine();
            texts.add(text);
            texts.remove("exit");
        } while (!text.equals("exit"));

        return texts;
    }

    private int printWordNumber(ArrayList<String> texts, Scanner scanner) {
        System.out.println("Iveskite zodi kurio numeri sarase norite rasti");
        System.out.println(texts);
        String text = scanner.nextLine();
        int number = texts.indexOf(text);

        return number;
    }

    private ArrayList<String> deleteWord(ArrayList<String> texts, Scanner scanner) {
        System.out.println("Iveskite zodi kuri norite istrinti: ");
        System.out.println(texts);
        String text = scanner.nextLine();
        texts.remove(text);

        return texts;
    }

    private ArrayList<String> deleteCollection(ArrayList<String> texts) {
        texts.clear();
        return texts;
    }

}
