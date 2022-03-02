package lt.codeacademy.lessons.fifth.scanner;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Iveskite du skaicius:");

        Scanner scanner = new Scanner(System.in);
        int  result1 = scanner.nextInt();
        int  result2 = scanner.nextInt();

        ScannerTask scannerTask = new ScannerTask();

        System.out.println("Ivestu skaiciu suma: " + scannerTask.result(result1, result2));


    }
}
