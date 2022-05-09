package lt.codeacademy.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericMain {
    public static void main(String[] args) {
        Box box = new Box();
        box.setObject(50);

        // Integer value = (Integer) box.getObject(); // buti tikrinti pries castinima
        if (box.getObject() instanceof Integer value) {
            System.out.println(value);
        }
        box.setObject("50");

        //value = (Integer) box.getObject(); //ClassCastException
        if (box.getObject() instanceof String value) {
            System.out.println(value);
        }

        // Generic  Box
        //apsisaugom nuo netaisyklingo tipo
        GenericBox<Integer> genericBox = new GenericBox<>();
        genericBox.setE(50);
        //neleistu uzsetint string
        //genericBox.setE("50");

        Pair<String, Integer> pairExample = new MyPair<>("Andrius", 33);
        Pair<Double,Integer> pairExample2 = new MyPair<>(55.5, 55);

        System.out.println(pairExample.getKey());
        System.out.println(pairExample.getValue());

        //Raw tipas
        //jei nenurodai tipo, vel galima gauti exeption
        GenericBox rawGenericBox = new GenericBox();
        rawGenericBox.setE("50");
        rawGenericBox.setE(50);

        GenericMain main = new GenericMain();

        main.testGenericMethod("test");
        main.testGenericMethod(50);
        main.testGenericMethod(true);
        main.testGenericMethod(genericBox);

        Integer integer = main.testGenericMethod2(50);

        String o = main.testGenericMethod3();

        Pair<String, String> p1 = new MyPair<>("As", "Tu");
        Pair<String, String> p2 = new MyPair<>("TU", "JIS");

        System.out.println(PairComaparator.compare(p1, p2));

        Clculator<Integer> clculator = new Clculator<>(50, 50);
        Number sum = clculator.sum();
        System.out.println(sum);

        GenericBox<Number> numberBox = new GenericBox<>();
        GenericBox<Integer> intBox = new GenericBox<>();
        main.testParameter(numberBox);
        //neduoda nes skirtingas tipas
        //main.testParameter(intBox);

        List<? extends Number> dummyList = new ArrayList<>();
        //TAIP NEGALIMA
        //dummyList.add(55);
        List<Integer> intList = List.of(12, 3, 66);
        main.printList(intList);
        List<Double> doubleList = List.of(55.5, 88.5, 63.7);
        main.printList(doubleList);


    }

    private void printList(List<? extends Number> list) {
        list.forEach(System.out::println);
    }

    private void testParameter(GenericBox<Number> box) {

    }

    private <E> void testGenericMethod(E type) {

    }

    private <E> E testGenericMethod2(E e) {
        return e;
    }

    private <K, V> void testGenericMethod3(K k, V v) {

    }

    private <E> E testGenericMethod3() {
    return null;
    }
}
