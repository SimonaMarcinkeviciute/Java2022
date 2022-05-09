package lt.codeacademy.lessons.eighth.array;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite 3 vardus");
        String name = scanner.next();
        String name1 = scanner.next();
        String name2 = scanner.next();

        String[] text = {name, name1, name2};

        System.out.printf("%s-%s-%s\n", text[0].toUpperCase(), text[0].length(), 0);


    }
}