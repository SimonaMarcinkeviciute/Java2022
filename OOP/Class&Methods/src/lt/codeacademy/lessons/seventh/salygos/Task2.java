package lt.codeacademy.lessons.seventh.salygos;

import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Iveskite triju zodziu sakini: ");
        String text = scanner.nextLine();

        Task2 task2 = new Task2();

       task2.splitText(text);
    }

    // su contain metodu butu paprasciau. text.toLoweCase.contains("labas")

    private void splitText(String text) {
        int splitText1 = text.indexOf(" ");
        int splitText2 = text.lastIndexOf(" ");

        String t1 = text.substring(0, splitText1);
        String t2 = text.substring(splitText2 + 1);
        String t3 = text.substring(splitText1 + 1,splitText2);


        System.out.println("Sakinyje yra zodis labas: " + isWordLabas(t1, t2, t3));



    }

    private boolean isWordLabas(String text1, String text2, String text3) {

        boolean isLabas = false;

        if (text1.matches("labas") || text2.matches("labas") || text3.matches("labas")) {
            isLabas = true;
        }

        return isLabas;
    }



}
