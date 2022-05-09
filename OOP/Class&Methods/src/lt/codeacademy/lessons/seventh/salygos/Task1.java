package lt.codeacademy.lessons.seventh.salygos;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Task1 task1 = new Task1();

        System.out.println("Iveskite skaiciu");
        int numb = scanner.nextInt();

        task1.numbers(numb);

    }

    private void numbers(int numb) {

        if(numb % 2 == 0) {
            System.out.println("Skaicius yra lyginis");
        } else {
            System.out.println("Skaicius yra nelyginis");
        }
    }
}
