package lt.codeacademy.lessons.eighth.enums;

import java.util.Arrays;

public enum Days {

    PIRMADIENIS("Pirmadieni", 1),
    ANTRADIENIS("Antradienis", 2),
    TRECIADIENIS("Treciadienis", 3),
    KETVIRTADIENIS("Ketvirtadienis", 4);

    //final modifikatorius prie kintamujju reiskia, kad reiksmes
    //viena karta priskiriamos ir jos yra nekintamos

    private final String name;
    private final int number;

    //jei turim kitamuju ir konstruktoriu su parametrais,
    //visos konstantos turi tureti parametrus

    Days(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

    //galima pagal paduota skaiciu susirasti
    //kuri tai konstanta

    public static Days getDayByNumber(int number) {
        Arrays.stream(Days.values()).filter(c -> c.getNumber() == number).findFirst().orElse(null);

        return null;
    }
}