package lt.codeacademy.lessons.thirteenth.random;

import java.util.Random;

public class RandomExample {
    public static void main(String[] args) {
        Random random = new Random();
        // bound, nusistatom iki kokio skaiciaus
        // 0 - 9
        //System.out.println(random.nextInt(10));
        //nuo 1 iki 10
        System.out.println(random.nextInt(10) +1);
        // bet koks skaicius
        System.out.println(random.nextInt());
        // intervala nuo 10 iki 20
        int min = 10;
        int max = 20;
        System.out.println(random.nextInt(max - min) + min + 1);
        System.out.println(random.nextInt(min, max + 1));
        // intervalas po kablelio

        System.out.println(Math.random() * (max - min) + min);
    }
}
