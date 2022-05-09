package lt.codeacademy.lessons.nineteenth.collections;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        List<String> texts = new ArrayList<>();
        texts.add("Vilnius");
        texts.add("Kaunas");
        texts.add("Klaipeda");
        texts.add("Vilnius");

        System.out.println(texts);

        Task4 task4 = new Task4();
        System.out.println(task4.removeDublocates(texts));

    }

    private List<String> removeDublocates(List<String> list) {
        List<String> newList = new ArrayList<>();

        for(String t: list) {
            if(!newList.contains(t)) {
                newList.add(t);
            }
        }

        return newList;
    }

}
