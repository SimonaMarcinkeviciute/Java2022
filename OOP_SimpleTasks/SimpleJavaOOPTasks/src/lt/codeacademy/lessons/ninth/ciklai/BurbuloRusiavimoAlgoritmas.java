package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Arrays;
import java.util.Scanner;

public class BurbuloRusiavimoAlgoritmas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BurbuloRusiavimoAlgoritmas burbuloRusiavimoAlgoritmas = new BurbuloRusiavimoAlgoritmas();

        String[] numbArray = burbuloRusiavimoAlgoritmas.array(scanner);
        int arrayLength = burbuloRusiavimoAlgoritmas.arrayLength(numbArray);

        System.out.println(Arrays.toString(burbuloRusiavimoAlgoritmas.sortArray(arrayLength, numbArray)));

    }

    private String[] array(Scanner scanner) {

        System.out.println("Iveskite norimus skaicius ir spauskite enter");
        String numb = scanner.nextLine();

        return numb.split(" ");
    }

    private int arrayLength(String[] numbArray) {
        return numbArray.length;
    }

    private String[] sortArray(int arrayLength, String[] numbArray) {

        String[] arraySwap = new String[1];

        for (int i = 0; i < arrayLength - 1; i++) {
            for (int j = 0; j < arrayLength - 1; j++) {
                if (Integer.parseInt(numbArray[j]) > Integer.parseInt(numbArray[j + 1])) {
                    arraySwap[0] = numbArray[j];
                    numbArray[j] = numbArray[j + 1];
                    numbArray[j + 1] = arraySwap[0];
                }
            }
        }

        return numbArray;
    }

}



