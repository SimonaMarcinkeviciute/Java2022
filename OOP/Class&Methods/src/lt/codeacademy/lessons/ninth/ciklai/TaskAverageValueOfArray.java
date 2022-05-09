package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Scanner;

public class TaskAverageValueOfArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskAverageValueOfArray taskAverageValueOfArray = new TaskAverageValueOfArray();

        int[] intArray = taskAverageValueOfArray.getNumbers(scanner);

        System.out.println("Skaiciu suma: " + taskAverageValueOfArray.sum(intArray));

    }

    private int[] getNumbers(Scanner scanner) {

        System.out.println("Iveskite skaicius");
        String numbers = scanner.nextLine();

        // per cikla paversti string masyva int masyvu

        String[] numbersArrayString = numbers.split(" ");
        int[] numbersArrayInt = new int[numbersArrayString.length];

        for (int i = 0; i < numbersArrayString.length; i++) {
            numbersArrayInt[i] = Integer.parseInt(numbersArrayString[i]);
        }

        return numbersArrayInt;
    }

    private double sum(int[] intArray) {

        double sum = 0;

        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }

        return sum / intArray.length;
    }
}
