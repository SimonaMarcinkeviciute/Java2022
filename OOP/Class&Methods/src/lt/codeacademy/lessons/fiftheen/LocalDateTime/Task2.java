package lt.codeacademy.lessons.fiftheen.LocalDateTime;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite laika tokiu formatu HH:mm");
        String timeFromConsole = scanner.next();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalTime laikas = LocalTime.parse(timeFromConsole,formatter);
        System.out.println(laikas);
        LocalTime naujasLaikas = laikas.plusHours(2).plusMinutes(15);
        System.out.println(naujasLaikas);
    }
}
