package lt.codeacademy.lessons.nineteenth.collections;

import java.util.ArrayList;
import java.util.Iterator;

public class Task1 {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(5);
        numbers.add(7);

        System.out.println(numbers);

        numbers.remove(1);


        System.out.println(numbers);

    }
}
