package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Arrays;
import java.util.Scanner;

public class CopyAnArraByIteratting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CopyAnArraByIteratting copyAnArraByIteratting = new CopyAnArraByIteratting();

        int[] intArray = copyAnArraByIteratting.getNumbers(scanner);
        System.out.println("Source Array: " + Arrays.toString(intArray));
        int[] newArray = copyAnArraByIteratting.getNewArray(intArray);
        System.out.println("New Array: " + Arrays.toString(newArray));
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

    private int[] getNewArray(int[] intArray) {

        int[] newArray = new int[intArray.length];
        int j = 0;

        for (int i = 0; i < intArray.length; i++) {
            newArray[j] = intArray[i];
            j++;
        }

        return newArray;
    }
}
