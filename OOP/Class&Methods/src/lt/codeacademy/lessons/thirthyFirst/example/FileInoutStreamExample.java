package lt.codeacademy.lessons.thirthyFirst.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInoutStreamExample {
    public static void main(String[] args) {

        //susikuri faila pats, irasai i ten ka bori, ir tada sitaip galima nuskaityti simbolius
        //try resourses, visada kvieciamas close metodas

        // nusiskaitom jau egzistuojanti faila

        try(InputStream inputStream = new FileInputStream("example.txt")) {
            int letter;
            while ((letter = inputStream.read()) > 0) {
                System.out.println(letter);
             //   System.out.println(inputStream.available()); kiek liko nenuskaitytu raidziu

            }
        }catch (IOException e) {
            e.printStackTrace();
        }

        //finally bloke kviesti close metoda, jkad bet kokiu atveju uzdarytu faila, String, kuris buvo atidarytas tarp to failo

       /* InputStream inputStream = null;
        try {
            inputStream = new FileInputStream("example.txt");
            int letter;
            while ((letter = inputStream.read()) > 0) {
                System.out.println(letter);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } */
    }
}