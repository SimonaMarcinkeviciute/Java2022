package lt.codeacademy.lessons.first;

import static lt.codeacademy.lessons.first.Methods.*;

public class Main {

    public static void main(String[] args) {
        pirmas();
        int antras = antras();

        System.out.println("Antras metodas: " + antras);

        Methods methods = new Methods();

        methods.trecias();
        int ketvirtas = methods.ketvirtas();

        System.out.println("Ketvirtas metodas: " + ketvirtas);

        System.out.println("--------------------------------");

        pirmas(1);
        pirmas("Pirmas protected static metodas su vienu String ir vienu int parametru", 5);


    }
}
