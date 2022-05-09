package lt.codeacademy.lessons.twentieth.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTask {
    public static void main(String[] args) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);

        System.out.println(numbers + " aibes dydis: " + numbers.size());

        numbers.add(1);

        System.out.println(numbers + " aibes dydis: " + numbers.size());
        System.out.println("Ar yra elementas: " + numbers.contains(4));

        numbers.remove(4);
        System.out.println(numbers + " aibes dydis: " + numbers.size());

        numbers.clear();
        System.out.println(numbers + " aibes dydis: " + numbers.size());


    }
}
