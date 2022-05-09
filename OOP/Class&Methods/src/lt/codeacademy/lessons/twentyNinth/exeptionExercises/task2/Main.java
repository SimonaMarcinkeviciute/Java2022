package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Jusu ivestas skaicius: " + Input.inputNumber(scanner));
                break;
            }catch (InputMismatchException e) {
                System.out.print("Ivesti netinkami duomenys. ");
            }
        }

    }
}
