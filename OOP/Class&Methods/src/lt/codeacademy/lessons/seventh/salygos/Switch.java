package lt.codeacademy.lessons.seventh.salygos;

import java.util.Scanner;

public class Switch {

    public static void main(String[] args) {


        Scanner scn = new Scanner(System.in);
        Switch switchProgram = new Switch();

        System.out.println("Iveskite menesio numeri.");
        int skaicius = scn.nextInt();

        switchProgram.program(skaicius);
    }

    private void program(int skaicius) {

        if (skaicius > 0 && skaicius < 13) {
            if (skaicius % 2 == 0) {
                switch (skaicius) {
                    case 2:
                        System.out.println("Vasaris");
                        break;
                    case 4:
                        System.out.println("Balandis");
                        break;
                    case 6:
                        System.out.println("Birzelis");
                        break;
                    case 8:
                        System.out.println("Rugpjutis");
                        break;
                    case 10:
                        System.out.println("Spalis");
                        break;
                    case 12:
                        System.out.println("Gruodis");
                        break;

                }
            } else {
                secondSwitch(skaicius);
            }
        } else {
            System.out.println("Netinkamas skaicius");
        }
    }


    private void secondSwitch(int skaicius) {

        switch (skaicius) {
            case 1:
                System.out.println("Sausis");
                break;
            case 3:
                System.out.println("Kovas");
                break;
            case 5:
                System.out.println("Geguze");
                break;
            case 9:
                System.out.println("Rugsejis");
                break;
            case 11:
                System.out.println("Lapkritis");
                break;

        }

    }
}
