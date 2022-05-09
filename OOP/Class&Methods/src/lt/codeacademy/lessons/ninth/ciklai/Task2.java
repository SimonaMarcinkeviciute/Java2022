package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Task2 task2 = new Task2();

        int[] masyvas = task2.array(scanner);

        task2.fillUpMas(masyvas, scanner);

        System.out.println(task2.fondMinNumber(masyvas));

    }

    // susikurem masyva

    private int[] array(Scanner scanner) {
        System.out.println("Iveskite masyvo ilgi: ");
        int arrayLength = scanner.nextInt();
        return new int[arrayLength];
    }

    // uzsipildem masyva

    private void fillUpMas(int[] mas, Scanner scanner) {
        for (int  i= 0; i < mas.length; i++) {
            System.out.println("Iveskite skaiciu: ");
            mas[i] = scanner.nextInt();
        }
    }

    // tikrinam ar skaicius mazesnis

    private int fondMinNumber(int[] mas) {
        int min = mas[0];

        for(int i = 1; i < mas.length; i++) {
            if(min > mas[i]) {
                min = mas[i];
            }
        }

        return min;
    }

    //randam didziausia reiksme

    private int findMaxNumber(int[] mas) {
        int max = mas[0];
        for(int i = 1; i < mas.length; i++) {
            if(max < mas[i]) {
                max = mas[i];
            }
        }

        return max;
    }
}
