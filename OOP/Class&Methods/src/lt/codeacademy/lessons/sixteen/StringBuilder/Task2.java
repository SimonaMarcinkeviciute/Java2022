package lt.codeacademy.lessons.sixteen.StringBuilder;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.next();

        StringBuilder stringBuilder = new StringBuilder(text);
        String reversed = stringBuilder.reverse().toString();
        // palyginti zodi ar tai palindromas

        System.out.println(reversed.equals(text));






    }
}