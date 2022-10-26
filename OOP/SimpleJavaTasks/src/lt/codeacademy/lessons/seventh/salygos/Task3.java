package lt.codeacademy.lessons.seventh.salygos;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite skaiciu: ");
        double numb = scanner.nextDouble();

        Task3 task3 = new Task3();
        task3.oddOrEven(numb);
    }

    private void oddOrEven(double numb) {

        if(numb % 2 == 0) {
            System.out.println("funkcijos reiksme: " + evenNumb(numb));
        } else {
            System.out.println("funkcijos reiksme: " + oddNumber(numb));
        }
    }

    private double evenNumb(double numb) {
        numb = (2 * numb) + 8;
        return numb;
    }

    private double oddNumber(double numb) {
        numb = 21 - (7 * numb);
        return numb;
    }

}
