package lt.codeacademy.lessons.sixth;

import java.util.Scanner;

public class PakartojimasMain {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String num1 = scanner.nextLine();

        String [] num2 = num1.split(" ");

        PakartojimasTask pakartojimasTask = new PakartojimasTask();

        pakartojimasTask.sum(Integer.parseInt(num2[0]), String.valueOf(num2[1]), Integer.parseInt(num2[2]));






    }
}
