package lt.codeacademy.lessons.nineteenth.collections;

import java.util.ArrayList;
import java.util.Scanner;

public class  Task2 {
    public static void main(String[] args) {
        ArrayList<String> texts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String stringText;

        do{

            System.out.println("Iveskite norimus zodzius, programai uzbaigti parasykite end");
            if (texts.size() == 5) {
                texts.clear();
            }
            stringText = scanner.nextLine();
            if(texts.contains(stringText)) {
                System.out.println("Toks tekstas jau yra");
                continue;
            }
            texts.add(stringText);


        }while(!stringText.matches("end"));

        System.out.println(texts);



    }
}
