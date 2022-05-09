package lt.codeacademy.lessons.fourteenth.Pakartojimas;

import java.util.Scanner;

public class BankomatoPrototipas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Iveskite pinigu suma, kuria papildoma saskaita:");
        double money = scanner.nextDouble();
        BankomatoPrototipas bankomatoPrototipas = new BankomatoPrototipas();
        bankomatoPrototipas.cashOut(money, scanner);
    }

    private void cashOut(double money, Scanner scanner) {
        double outMoney;
        int times = 1;

        while (money > 0) {
            System.out.println("Saskaitos likutis: " + money + ", issimkite pinigus");
            outMoney = scanner.nextDouble();
            if (money < outMoney) {
                System.out.println("Nepakankamas likutis");
                times++;
                if (times > 3) {
                    break;
                }
            } else {
                money -= outMoney;
                times = 1;
            }
        }

        System.out.println("Programa baigta");
    }
}
