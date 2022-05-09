package lt.codeacademy.manoPabandymai.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ManoPabandymai {
    public static void main(String[] args) {

        List<String> text = new ArrayList<>();
        text.add("Kaunas");
        text.add("Vilnius");
        text.add("Klaipeda");

        Stream<String> stream = text.stream();


    }
}
