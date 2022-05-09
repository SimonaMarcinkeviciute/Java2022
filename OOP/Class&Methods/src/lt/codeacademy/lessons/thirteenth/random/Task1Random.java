package lt.codeacademy.lessons.thirteenth.random;

import java.util.Random;

public class Task1Random {
    public static void main(String[] args) {
        Random random = new Random();
        Task1Random task1Random = new Task1Random();

        int a = random.nextInt(100) + 1;
        int b = random.nextInt(100) + 1;
        int c = random.nextInt(100) + 1;

        System.out.println("Atsitiktiniai skaiciai: " + a + " " + b + " " + c);
        System.out.println("Didziausias skaiciu: " + task1Random.maxNumb(a, b, c));
    }

    private int maxNumb(int a, int b, int c) {
        int max;
        if (a > b && a > c) {
            max = a;
        } else if (b > a && b > c) {
            max = b;
        } else {
            max = c;
        }

        return max;
    }
}
