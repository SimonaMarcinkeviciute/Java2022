package lt.codeacademy.lessons.ninth.ciklai;

import java.util.Arrays;

public class ForLoopExample {

    public static void main(String[] args) {

       for (int i = 0; i < 5; i++) {
           System.out.println(i);
       }



       int[] items = new int[10];

       // [er masyva iteruoti

       for (int i =0; i < items.length; i++) {
           System.out.println(items[i]);
       }

       // iteruojasi per kolekcija, atspausdina
        //visas masyvo reiksmes, naujas budas

       for(Integer item : items) {
           System.out.println("Value" + item);
       }

       // atspausdina rfeiksmes, naujausias for ciklas

        System.out.println("--------");

        Arrays.stream(items).forEach(System.out::println);

    }
}

