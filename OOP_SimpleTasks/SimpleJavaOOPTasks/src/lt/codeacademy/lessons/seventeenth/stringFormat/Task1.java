package lt.codeacademy.lessons.seventeenth.stringFormat;

import java.io.FilterOutputStream;

public class Task1 {
    public static void main(String[] args) {
        String vardas = "Petras";
        String pavarde = "Petraitis";
        int gimimoMetai = 1997;
        float ugis = 1.90f;

        String text = String.format("Asmuo %s %s, gimes %sm, ugis yra %sm", vardas, pavarde, gimimoMetai, ugis);

        System.out.println(text);
    }
}
