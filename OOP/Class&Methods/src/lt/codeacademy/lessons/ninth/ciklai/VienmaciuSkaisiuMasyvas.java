package lt.codeacademy.lessons.ninth.ciklai;

//Vienmatis skaičių masyvas: Deklaruokite sveikųjųskaičių masyvą m ir jį sukurkite (išskirkitevietos); tegul jo dydis
// būna priklausomas nuo parametro, įvedamo komandinėje eilutėjeprogramos vykdymo metu. Praeikite masyvą m ciklo
// pagalba nuo paskutinės pozicijos iki pirmosir praeidami priskirkite masyvo elementams reikšmes, atitinkančias
// pozicijų numerius, o taip patlyginėse pozicijose tegul būna teigiami skaičiai, nelyginėse - neigiami. Pavyzdžiui,
// 2 pozicijojebus skaičius 2, o pozicijoje 3 bus skaičius -3. Gautą masyvą atspausdinkite. Praeikite masyvą vėlir
// pozicijose, kurių numeriai dalijasi iš 3 be liekanos, reikšmes padauginkite iš 2. Taigi dabar,pavyzdžiui, pozicijoje
// 3 bus reikšmė -3*2=-6. Panaudokite ciklo kintamajam žingsnį 2 beimasyvą praeikite nuo galo (vienos iteracijos metu
// spausdinkite du elementus).

import java.util.Arrays;
import java.util.Scanner;

public class VienmaciuSkaisiuMasyvas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VienmaciuSkaisiuMasyvas vienmaciuSkaisiuMasyvas = new VienmaciuSkaisiuMasyvas();

        int arrayLength = vienmaciuSkaisiuMasyvas.intArray(scanner);
        int[] intArray = new int[arrayLength];
        vienmaciuSkaisiuMasyvas.arrayValues(intArray, arrayLength);
        System.out.println(Arrays.toString(intArray));
        vienmaciuSkaisiuMasyvas.divisionOfThree(intArray, arrayLength);
    }

    private int intArray(Scanner scanner) {
        System.out.println("Iveskite norimo masyvo ilgi: ");
        return scanner.nextInt();
    }

    private int[] arrayValues(int[] intArray, int arrayLength) {
        for (int i = arrayLength - 1; i > 0; i--) {
            if (i % 2 == 0) {
                intArray[i] = i;
            } else {
                intArray[i] = -i;
            }
        }

        return intArray;
    }

    private void divisionOfThree(int[] intArray, int arrayLength) {
        for (int i = arrayLength - 1; i > 0; i--) {
            if (intArray[i] % 3 == 0) {
                intArray[i] = i * 2;
            }
        }
        System.out.println(Arrays.toString(intArray));

        // atspausdinti is pasyvo elementus po du
        for (int i = intArray.length - 1; i >= 0; i -= 2) {
            int j = Math.max(i - 1, 0);
            System.out.printf("%d %d\n", intArray[i], intArray[j]);
        }
    }
}



