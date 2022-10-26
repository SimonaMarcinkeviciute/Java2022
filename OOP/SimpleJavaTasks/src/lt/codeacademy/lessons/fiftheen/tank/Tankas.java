package lt.codeacademy.lessons.fiftheen.tank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Tankas {
    private int x;
    private int y;
    //enum klase
    private TankPosition position;
    private int shootEastCount;
    private int shootWestCount;
    private int shootSouthCount;
    private int shootNorthCount;

    public Tankas() {
        x = 0;
        y = 0;
        shootEastCount = 0;
        shootWestCount = 0;
        shootNorthCount = 0;
        shootSouthCount = 0;
    }

    public void pirmyn() {
        y++;
        position = TankPosition.NORTH;
        moveInfo();
    }

    public void atgal() {
        y--;
        position = TankPosition.SOUTH;
        moveInfo();
    }

    public void kairen() {
        x--;
        position = TankPosition.WEST;
        moveInfo();
    }

    public void desinen() {
        x++;
        position = TankPosition.EAST;
        moveInfo();
    }

    public void suvis() {
        switch (position) {
            case EAST -> shootEastCount++;
            case WEST -> shootWestCount++;
            case SOUTH -> shootSouthCount++;
            case NORTH -> shootNorthCount++;
        }
        System.out.printf("Suvis i s%\n,", position);
    }

    public void info() {
        System.out.printf("INFO: Tanko konrdinate: (%s;%s), ktyptis %s\n", x, y, position);
        System.out.printf("INFO: Tanko suviai: %s i siaure, %s i Rytus, %s i pietus, %s i Vakarus. Is viso suviu \n", shootNorthCount, shootEastCount,
                shootSouthCount, shootWestCount);

    }

    private void moveInfo() {
        System.out.printf("Tankas juda i %s kordinates(%s;%s)\n", position, x, y);
    }

    public void board() {
        System.out.print("""
                Pasirinkite:
                [s] - ejimasi Siaure
                [r] - ejimas i Rytus
                [p] - ejimas i Pietus
                [v] - ejimas i vakarus
                [*] - suvis
                [i] - info
                [x] - pabaiga
                """);

    }

    public void move(Scanner scanner) {
        boolean runProgram = true;

        while (runProgram) {
            board();
            LocalDateTime localDateTime = LocalDateTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("[HH:mm]");
            String formattedDate = localDateTime.format(myFormatObj);
            String move = scanner.nextLine();
            System.out.print(formattedDate + " ");

            switch (move) {
                case "s" -> pirmyn();
                case "r" -> desinen();
                case "p" -> atgal();
                case "v" -> kairen();
                case "*" -> suvis();
                case "i" -> info();
                case "x" -> {
                    System.out.println("Programos pabaiga");
                    runProgram = false;}
            }
        }


    }
}
