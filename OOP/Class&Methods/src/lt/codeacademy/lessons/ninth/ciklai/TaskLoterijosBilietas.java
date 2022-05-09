package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class TaskLoterijosBilietas {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        TaskLoterijosBilietas taskLoterijosBilietas = new TaskLoterijosBilietas();

        String[] ticketNumbsArray = taskLoterijosBilietas.ticketNumbsArray(scanner);

        System.out.println(taskLoterijosBilietas.NumberDifferent(ticketNumbsArray));


    }

    private String[] ticketNumbsArray(Scanner scanner) {

        System.out.println("Iveskite loterijos bilieto skaicius:");
        String ticketNumbs = scanner.nextLine();


        return ticketNumbs.split("");
    }

    private String NumberDifferent(String[] ticketNumbsArray) {

        // ciklas palyginti skaicius, ar nera vienodu


        for (int i = 0; i < ticketNumbsArray.length - 1; i++) {
            for (int j = i + 1; j < ticketNumbsArray.length; j++) {
                if (ticketNumbsArray[i].equals(ticketNumbsArray[j])) {
                    return "Bilietas nieko nelaimejo";
                }
            }

        }

        return isTicketLucky(ticketNumbsArray);


    }

    private String isTicketLucky(String[] ticketNumbsArray) {

        if (Integer.parseInt(ticketNumbsArray[0]) + Integer.parseInt(ticketNumbsArray[1]) + Integer.parseInt(ticketNumbsArray[2]) ==
                Integer.parseInt(ticketNumbsArray[3]) + Integer.parseInt(ticketNumbsArray[4]) + Integer.parseInt(ticketNumbsArray[5])) {
            return "Bilietas yra laimingas";
        } else {
            return "Bilietas nieko nelaimejo";
        }

    }
}
