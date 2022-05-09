package lt.codeacademy.lessons.fiftheen.tank;

import java.util.Scanner;

public class TankMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tankas tankas = new Tankas();
        tankas.move(scanner);
    }
}
