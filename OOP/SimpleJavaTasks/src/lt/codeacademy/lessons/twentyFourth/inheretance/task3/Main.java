package lt.codeacademy.lessons.twentyFourth.inheretance.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Asmuo> asmenys = new ArrayList<>();
        asmenys.add(new Asmuo("Antanas", "Antanaitis"));
        asmenys.add(new Asmuo("Simona", "Marcinkeviciute"));

        System.out.println(asmenys);
    }
}
