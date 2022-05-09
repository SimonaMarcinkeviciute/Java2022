package lt.codeacademy.lessons.thirteenth.random;

import java.util.Arrays;
import java.util.Random;

public class Tas3AtsitiktinumoPatikrinimas {
    public static void main(String[] args) {
        Tas3AtsitiktinumoPatikrinimas tas3AtsitiktinumoPatikrinimas = new Tas3AtsitiktinumoPatikrinimas();
        int[] intArray = tas3AtsitiktinumoPatikrinimas.numbersArray();
        System.out.println(Arrays.toString(intArray));
        tas3AtsitiktinumoPatikrinimas.number(intArray);

    }

    private int[] numbersArray() {
        Random random = new Random();
        int[] numberArray = new int[10];

        for (int i = 0; i < 10; i++) {
            numberArray[i] = random.nextInt(10) + 1;
        }

        return numberArray;
    }

    private void number(int[] intArray) {
        int[] nerArray = new int[10];
        for (int i = 0; i < intArray.length; i++) {
            int numb = 0;
            for (int j = 0; j < intArray.length; j++) {
                    if (intArray[i] == intArray[j]) {
                        numb++;
                    }
            }

            System.out.println(i + 1  + " - ispausdino kartu: " + numb);

        }
    }
}
