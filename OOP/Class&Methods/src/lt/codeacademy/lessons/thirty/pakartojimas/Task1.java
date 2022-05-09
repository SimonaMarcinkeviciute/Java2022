package lt.codeacademy.lessons.thirty.pakartojimas;

import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite skaiciu intervala");
        String intervalas = scanner.nextLine();
        Task1 task1 = new Task1();
        task1.splitNumbers(intervalas);

    }

    private void splitNumbers(String intervalas) {

        String[] splitNumbers = intervalas.split(" ");
        int number1 = Integer.parseInt(splitNumbers[0]);
        int number2 = Integer.parseInt(splitNumbers[1]);
        printNumbers(number1, number2);
    }

    private void printNumbers(int numb1, int numb2) {
        for ( int i = numb1; i <= numb2; i++  ) {
           // if(i != 1 && i / == 1 )  {
                System.out.println(i);
           // }
        }
    }
}
