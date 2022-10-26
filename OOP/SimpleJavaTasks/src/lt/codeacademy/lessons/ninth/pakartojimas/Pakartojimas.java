package lt.codeacademy.lessons.ninth.pakartojimas;

import java.util.Scanner;

public class Pakartojimas {

    //jei nenorim paduoti per parametrus, galima susikurti
    //klases kintamuosius. be static reikes objekto

    //private static int numb;

    public static void main(String[] args) {

        Pakartojimas pakartojimas = new Pakartojimas();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite tris skaicius: ");
        // tada cia nereikia nusakyti tipo
        double numbs = scanner.nextInt();
        double numbs1 = scanner.nextInt();
        double numbs2 = scanner.nextInt();

        pakartojimas.theGreatestnum(numbs, numbs1, numbs2);

        System.out.println("Skaiciu vidurkis: " + pakartojimas.averageNumber(numbs, numbs1, numbs2));
        System.out.println("Skaiciu suma pakelus laipsniu: " + pakartojimas.powSum(numbs, numbs1, numbs2));


    }

    private void theGreatestnum(double num1, double num2, double num3) {
        if (num1 > num2 && num1 > num3){
            System.out.println("Didziausias skaicius: " + num1);
        } else if (num2 > num1 && num2 > num3){
            System.out.println("Didziausias skaicius: " + num2);
        } else {
            System.out.println("Didziausias skaicius: " + num3);
        }

    }

    private double averageNumber(double num1, double num2, double num3) {
        return (num1 + num2 + num3) / 3;
    }

    private double powSum(double num1, double num2, double num3) {
        return Math.pow(num1,num1) + Math.pow(num2,num2) + Math.pow(num3,num3);
    }
}
