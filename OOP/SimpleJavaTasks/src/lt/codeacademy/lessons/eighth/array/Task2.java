package lt.codeacademy.lessons.eighth.array;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

       scr();


    }

    public static void scr() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite masyvo ilgi");
        int arrayLength = scanner.nextInt();
        mrethod(arrayLength);
    }

    public static void mrethod(int arrayLength) {

        Random random = new Random();

        int [] array;

        if ( arrayLength > 7) {
            array = new int[random.nextInt(9)];
            array[0] = array.length;
            array[array.length - 1] = array.length;
            // atspausdinti masyva
            System.out.println(Arrays.toString(array));
        }else {
            System.out.println("Iveskite kita skaiciu");
            scr();
        }

    }
}
