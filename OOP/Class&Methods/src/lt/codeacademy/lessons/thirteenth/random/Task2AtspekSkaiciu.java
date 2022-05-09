package lt.codeacademy.lessons.thirteenth.random;

import java.util.Random;
import java.util.Scanner;

public class Task2AtspekSkaiciu {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        Task2AtspekSkaiciu task2AtspekSkaiciu = new Task2AtspekSkaiciu();

        int randomNumb = random.nextInt(100) + 1;
        System.out.println("Spekite skaiciu");
        System.out.println("Jusu spejimas: " + task2AtspekSkaiciu.isTheSame(randomNumb, scanner));

    }

    private boolean isTheSame(int randomNumb, Scanner scanner) {
        int numb;
        boolean isTheSameNumb = false;

        for (int i = 0; i < 10; i++) {
            numb = scanner.nextInt();
            if (numb == randomNumb) {
                isTheSameNumb = true;
                break;
            } else if (numb > randomNumb) {
                System.out.println("Ivestas skaicius per didelis, spekite skaiciu dar karta: ");
            } else {
                System.out.println("Ivestas skaicius per mazas, spekite skaiciu dar karta: ");
            }
        }

        return isTheSameNumb;
    }
}
