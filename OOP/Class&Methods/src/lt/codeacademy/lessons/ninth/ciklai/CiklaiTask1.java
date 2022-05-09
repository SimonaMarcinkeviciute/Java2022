package lt.codeacademy.lessons.ninth.ciklai;

//Jonukas mokykloje gavo užduotį patikrinti ar duotiterminai yra palindromas
//Jam sunkupačiam tai padaryti todėl jis prašo Jūsų pagalbos. Parašykite metodą kuris patikrintų
// ar duotasžodis yra palindromas (žodis ar sakinys kurį skaitant nuo galo gaunamas tas pats žodis
// arsakinys, pvz. “KOL EINU ŠUNIE LOK”, “ARGI TEN NE TIGRA” , “SĖDĖK UŽU KĖDĖS”).
// Užuomina: pašalinti tarpus ir tuomet keliauti per pusę žodžio iš abiejų pusių tikrinant ar sutamparaidės.

import java.util.Scanner;

public class CiklaiTask1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        CiklaiTask1 ciklaiTask1 = new CiklaiTask1();

        System.out.println("Iveskite sakini: ");
        String sentence = scanner.nextLine();

        System.out.println(sentence + ciklaiTask1.isPalindrome(sentence.replaceAll(" ", "").toLowerCase()));
    }


    private String isPalindrome(String sentence) {

        String isPalindrome = "";
        for (int i = 0; i < sentence.length() / 2; i++) {
            if (sentence.charAt(i) == sentence.charAt(sentence.length() - 1 - i)) {
                isPalindrome = ": - zodis yra palindromas";

            } else {
                isPalindrome = ": - Zodis nera palindromas";
                break;
            }

        }

        return isPalindrome;
    }
}
