package lt.codeacademy.lessons.second;

import java.util.Scanner;

public class TaskThird {

    public static void main(String[] args) {

        double d1 = m1();
        double d2 = m2();

        System.out.println(d1 + d2);

    }

    public static double m1(){

        return 123.5;

    }

    public static double m2(){

        Scanner scn = new Scanner(System.in);
        System.out.println("Iveskite skaicius:");
        int ivestasSkaicius = scn.nextInt();
        return ivestasSkaicius;

    }
}
