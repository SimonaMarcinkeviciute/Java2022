package lt.codeacademy.lessons.twentyEigth.exceptions.tryCach;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionExample {
    public static void main(String[] args) {

        //throw new Exception(); taip galima ideti klaida
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite skaiciu");

        try {// ta vieta kur gali iskristi klaida
            scanner.close();
            int number = scanner.nextInt();
            System.out.printf("Jus ivedete %s\n", number);
        }catch (InputMismatchException e) { // jei iveda ne skaiciu
            System.out.println("Ivedete ne skaiciu");
        }catch (IllegalStateException e) {//jei scanner uzdaromas pries input
            System.out.println("Scanner is closed");
        }catch (Exception e) {// gaudo bet kokia klaida
            System.out.println("Kazkas blogai");
        }finally {
            System.out.println("Visada bus iskvieciamas");
            // nesvarbu ar ivyko ar klaida
        }
//suuround thy ctch. arba jei nenori suround daryt,m galima prideti prie metodo antrastes kaip ir prie metodo
        try {
            testExeption();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public  static  void testExeption() throws Exception { // checked exceptio
        throw new Exception();
    }

    public static void testRuntimeExeption() {// nuchecked exception. nereikalauja handlinimo
        //nereikia try catch bloko
        throw new RuntimeException("New runtime exception");
    }
}
