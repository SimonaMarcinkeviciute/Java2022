package lt.codeacademy.lessons.ninth.ciklai;
//Write a Java program to find the maximum and minimum value of an array.Sample Output:
// Original Array: [25, 14, 56, 15, 36, 56, 77, 18, 29, 49]
// Maximum value for the above array = 77
// Minimum value for the above array = 14

import java.util.Scanner;

public class FindMinMacValueOfArray {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FindMinMacValueOfArray findMinMacValueOfArray = new FindMinMacValueOfArray();

        int[] intArray = findMinMacValueOfArray.getNumbers(scanner);
        System.out.println("Didziausias skaicius: " + findMinMacValueOfArray.getMaxNumb(intArray));
        System.out.println("Maziausias skaicius: " + findMinMacValueOfArray.getMinNumb(intArray));
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

    private int getMaxNumb(int[] intArray) {

        int maxnumb = intArray[0];

        for (int i = 0; i < intArray.length; i++) {
            if (maxnumb < intArray[i]) {
                maxnumb = intArray[i];
            }
        }

        return maxnumb;
    }

    private int getMinNumb(int[] intArray) {

        int minNumb = intArray[0];

        for (int i = 0; i < intArray.length; i++) {
            if (minNumb > intArray[i]) {
                minNumb = intArray[i];
            }
        }


        return minNumb;
    }


}


