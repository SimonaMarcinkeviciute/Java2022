package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Scanner;

public class TaskSumValuesOdArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskSumValuesOdArray taskSumValuesOdArray = new TaskSumValuesOdArray();

        int[] numbersArray = taskSumValuesOdArray.getNumbers(scanner);

        System.out.println("Skaiciu suma: " + taskSumValuesOdArray.sum(numbersArray));

    }

    private int[] getNumbers(Scanner scanner) {

        System.out.println("Iveskite skaicius");
        String numbers = scanner.nextLine();

        String[] numbersArrayString = numbers.split(" ");
        int[] numbersArrayInt = new int[numbersArrayString.length];

        for (int i = 0; i < numbersArrayString.length; i++) {
            numbersArrayInt[i] = Integer.parseInt(numbersArrayString[i]);
        }

        return numbersArrayInt;
    }

    private int sum(int[] intArray) {

        int sum = 0;

        for (int i = 0; i < intArray.length; i++) {
            sum += intArray[i];
        }

        return sum;
    }


}
