package lt.codeacademy.lessons.thirthyFirst.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileOutputStreaExample {
    public static void main(String[] args) {

        // susikurti teksitni faila paciam ir paciam irasyti tai ka nori

        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite ka norite irasyti");
        String line = scanner.nextLine();

        //sukurti nauja faila, bet siaip susikuria default'u
        File file = new File("output.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
// appendinti
        //norint modifikuoti, reikia nusiskaityti editinti ir vel irasyti
        // o jei perrasyti rasom failo varda
        try(FileOutputStream outputStream = new FileOutputStream(file, true)) {
            for(int i = 0; i < line.length(); i++) {
                //metodas charAt ima pagal indeksa elementa ir po viena iraso i faila
                outputStream.write(line.charAt(i));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
