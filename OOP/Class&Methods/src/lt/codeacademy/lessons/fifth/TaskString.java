package lt.codeacademy.lessons.fifth;

import java.util.Locale;
import java.util.Scanner;

public class TaskString {

    public static void main(String[] args) {

        TaskString taskString = new TaskString();

        taskString.a();
        taskString.b();
        taskString.c();
        taskString.d();
        taskString.e();
        taskString.f();
        taskString.g();
        taskString.h();

    }

    private void a(){
        System.out.println("Pirmoji programa");
    }

    private void b(){
        System.out.println("Mokausi programuoti \"Java\"");
    }

    private void c() {

        Scanner scn = new Scanner(System.in);
        System.out.println("Iveskite skaicius:");
        int numb = scn.nextInt();

        System.out.println("Jus ivedete skaiciu: " + numb);

    }

    private void d(){

        Scanner scn = new Scanner(System.in);
        System.out.println("Iveskite pirma sveika skaiciu:");
        int  a = scn.nextInt();
        System.out.println("Iveskite antra sveika skaiciu:");
        int b = scn.nextInt();

       int  s = a + b;

        System.out.println(s);
    }

    private void e(){

        Scanner scn = new Scanner(System.in);
        System.out.println("Iveskite pirma sveika skaiciu:");
        int  a = scn.nextInt();
        System.out.println("Iveskite antra sveika skaiciu:");
        int b = scn.nextInt();

        double s = (double) (a + b) / 2;

        System.out.println(s);

    }

    private void f() {
        int  a = 5;
        int b = 10;
        System.out.println("Int reiksmes pries suketima: a - " + a + ", b - " + b );
        int c = a;
        a = b;
        b = c;
        System.out.println("Int reiksmes po suketima: a - " + a + ", b - " + b );

    }

    private void g(){

        Scanner scn = new Scanner(System.in);
        System.out.println("Iveskite keturis  skaiciu:");

        String  a = scn.next();
        String  b = scn.next();
        String  c = scn.next();
        String  d = scn.next();

        String sum = a + b + c + d;


        System.out.println(sum);

    }

    private void h(){
        String text = "Namas";

        String textReplace = text.replace('s','i');

        System.out.println(textReplace);

        String textToUpperCase = textReplace.toUpperCase();

        System.out.println(textToUpperCase);

        String textSubstring = textToUpperCase.substring(2, 4);

        System.out.println(textSubstring);

        String text2 = "ma";
        String concatMa = textSubstring.concat(text2);

        System.out.println(concatMa);

        String text3 = "na";
        String concatNa = textSubstring.concat(text3);

        System.out.println(concatNa);

        int textIndexOf = concatNa.indexOf('n');

        System.out.println(textIndexOf);

    }

}
