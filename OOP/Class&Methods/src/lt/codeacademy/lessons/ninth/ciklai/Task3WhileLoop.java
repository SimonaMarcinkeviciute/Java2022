package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Scanner;

public class Task3WhileLoop {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Task3WhileLoop task3WhileLoop = new Task3WhileLoop();

        task3WhileLoop.umbs(scanner);
    }

    private void umbs (Scanner scanner) {
        int numb = 0;
        do {
            System.out.println("Iveskite skaiciu: ");
            numb = scanner.nextInt();
        }while (numb > 0 );

        System.out.println("Programa sustojo");
    }
}
