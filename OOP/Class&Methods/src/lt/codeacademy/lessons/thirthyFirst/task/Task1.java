package lt.codeacademy.lessons.thirthyFirst.task;

import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {

        Task1 task1 = new Task1();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Iveskitesavo varda ir pavarde");
        String input = scanner.nextLine();
        System.out.println("Iveskite failo pavadinima, i kuri vesite info");
        String fileName = scanner.nextLine();

        task1.bufferedWritter(input, fileName);
        task1.bufferedReader(fileName);

        StringBuilder sb = new StringBuilder(input);
        String reverseName = sb.reverse().toString();

        System.out.println("Iveskite failo pavadinima, i kuri perrasytine pakeista info");
        String newFileName = scanner.nextLine();

        task1.bufferedWritter(reverseName, newFileName);
        task1.bufferedReader(newFileName);

    }

    private void bufferedWritter(String input, String fileName) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(input);
            bw.newLine();
            bw.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void bufferedReader(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
