package lt.codeacademy.lessons.seventh.salygos;

import java.util.Objects;
import java.util.Scanner;

public class Task4Main {

    public static void main(String[] args) {

        Task4Main task4Main = new Task4Main();
        System.out.println("Iveskite salyga tokiu formatu: __ + __");
        task4Main.scr();

    }

    public void scr() {

        Scanner scanner = new Scanner(System.in);
        String condition = scanner.nextLine();

        splitCondition(condition);
    }

    public void splitCondition(String text) {

        // contains metodas panaudoti

        Task4 task4 = new Task4();
        String[] num2 = text.split(" ");
        String text1 = num2[1];


        if (text1.equals("+") || Objects.equals(text1, "-") || Objects.equals(text1, "*") ||
                Objects.equals(text1, "/") || Objects.equals(text1, "^")) {
            task4.actionsWithNumbs(Integer.parseInt(num2[0]), String.valueOf(num2[1]), Integer.parseInt(num2[2]));
        } else {
            task4.wrongInput();
        }
    }
}

// text.replaceAll("[^0-9]", "?")
//pries tai panaikinti tarbus visus, ir tada rasti ne
//skaiciu ir pakeisti kitu zenklu, tada pagal ta zenkla nustatyti
//kur prasideda ir baigiasi skaiciai