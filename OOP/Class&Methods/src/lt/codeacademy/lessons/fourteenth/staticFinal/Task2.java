package lt.codeacademy.lessons.fourteenth.staticFinal;

public class Task2 {
    public static int number;

    public Task2() {
        System.out.println("Reiksme yra: " + number++);
    }

    static void isvalyti() {
        System.out.println("Isvalyti reiksme yra" + number);
        number = 0;
    }
}


