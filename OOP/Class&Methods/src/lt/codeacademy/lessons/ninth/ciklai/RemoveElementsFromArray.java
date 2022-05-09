package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Arrays;
import java.util.Scanner;

public class RemoveElementsFromArray {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        RemoveElementsFromArray removeElementsFromArray = new RemoveElementsFromArray();

        int[] numbArray = removeElementsFromArray.getNumbers(scanner);
        System.out.println("Masyvo elementai: " + Arrays.toString(numbArray));
        int removeNumber = removeElementsFromArray.getRemoveNumber(scanner);
        System.out.println("Naujo masyvo elementai: " + removeElementsFromArray.newArray(numbArray, removeNumber));
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

    private int getRemoveNumber(Scanner scanner) {
        System.out.println("Iveskite skaiciu kuri norite isimti is masyvo:");

        return scanner.nextInt();
    }

    private String newArray(int[] numbArray, int number) {
        int[] newArray = new int[numbArray.length - 1];
        int j = 0;

        for (int i = 0; i < numbArray.length; i++) {
            if (numbArray[i] == number) {
                continue;
            }
            newArray[j] = numbArray[i];
            j++;
        }

        return Arrays.toString(newArray);
    }
}
