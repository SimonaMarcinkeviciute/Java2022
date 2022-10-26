package lt.codeacademy.lessons.seventh.salygos;

import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite metus: ");
        int year = scanner.nextInt();

        LeapYear leapYear = new LeapYear();
        leapYear.isLeap(year);

    }

    private void isLeap(int year) {

        if (year % 4 != 0) {
            System.out.println("Iprasti metai.");
        } else if (year % 100 != 0) {
            System.out.println("Keliamieji metai.");
        } else if (year % 400 != 0) {
            System.out.println("Iprasti metai.");
        } else {
            System.out.println("Keliamieji metai.");
        }
    }


}
