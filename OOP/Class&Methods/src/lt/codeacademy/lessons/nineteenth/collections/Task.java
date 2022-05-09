package lt.codeacademy.lessons.nineteenth.collections;

import java.util.ArrayList;
import java.util.List;

public class Task {
    public static void main(String[] args) {
        List<String> texts = List.of("Petras", "Vilnius", "Klaipeda");
        //palyginti tekstu ilgius
        String text = "";
        for (String t: texts) {
            if(t.length() > text.length()) {
                text = t;
            }
        }

        System.out.println(text);

        // arba tokiu budu
        List<String> names = new ArrayList<>();
        names.add("Petras");
        names.add("Vilnius");
        names.add("Klaipeda");

        names.sort((o1, o2) -> {
            if ((o1.length() == o2.length())) {
                return 0;
            }
            return o1.length() > o2.length() ? - 1 : 1;
        });
    }


}
