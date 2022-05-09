package lt.codeacademy.function.uzduotys.task1;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1 {

    //.sort
    public static void main(String[] args) {

        List<String> texts = new ArrayList<>();
        texts.add("f");
        texts.add("b");
        texts.add("a");
        texts.add("d");
        texts.add("g");

        List<String> texts2 = new ArrayList<>();
        texts2.add("1");
        texts2.add("6");
        texts2.add("2");
        texts2.add("99");
        texts2.add("5");

        // is karto sudeti reiksmes
        List<String> listOf = List.of("Labas", "Ka veikki");

       BiFunction<List<String>, List<String>, List<String>> sortList = (value1, value2) -> {
           List<String> text3 = new ArrayList<>();
           text3.addAll(value1);
           text3.addAll(value2);
           Collections.sort(text3);

           return text3;
       };

        System.out.println(sortList.apply(texts, texts2));

        //kitas budas
        BiFunction<List<String>, List<String>, List<String>> sortList2 = (value1, value2)
                -> Stream.concat(value1.stream(), value2.stream())
                .sorted().collect(Collectors.toList());

        System.out.println(sortList2.apply(texts, texts2));

        //dar vienas budas, bet ne visai optimalus
        BiFunction<List<String>, List<String>, List<String>> sortList3 = (value1, value2)
                -> List.of(value1, value2).stream().flatMap(Collection::stream).sorted().collect(Collectors.toList());

    }
}
