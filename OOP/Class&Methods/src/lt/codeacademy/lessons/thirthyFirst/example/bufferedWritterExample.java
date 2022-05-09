package lt.codeacademy.lessons.thirthyFirst.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class bufferedWritterExample {
    public static void main(String[] args) {

        // irasyti info i faila


        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite ka norite irasyti");
        String input = scanner.nextLine();

        try(BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write(input);
            bw.newLine();
            bw.flush();

        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
