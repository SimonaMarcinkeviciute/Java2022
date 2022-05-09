package lt.codeacademy.function.uzduotys.task2;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*Sukurkite metodą, kuris per parametrus paimtu Funkcija ir listą. Parašykite 2 metoduskurie grąžina funkciją.
Vienas metodas turi grąžinti surykiuota listą, antras metodas turigrąžinti listo elementus pavertes iš didžiųjų
raidžių.
 */
public class Task2 {
    public static void main(String[] args) {
        Task2 task2 = new Task2();
        List<String> text = new ArrayList<>();
        text.add("Kaunas");
        text.add("Vilnius");
        text.add("Klaipeda");

        Function<List<String>, List<String>> function1 = task2.myMethod2();
        Function<List<String>, List<String>> function2 = task2.myMethod3();

        task2.myMethod(function1, text);
        task2.myMethod(function2, text);
    }

    private void myMethod(Function<List<String>, List<String>> function, List<String> texts) {
        System.out.println(function.apply(texts));

        //galima ir taip isspausdinti
        /*texts = function.apply(texts);
        texts.forEach(System.out::println); */
    }

    private Function<List<String>, List<String>> myMethod2() {

        return value -> {
            Collections.sort(value);

            return value;
        };
    }

    private Function<List<String>, List<String>> myMethod3() {

       /* return value -> {
            List<String> upperCaseList = new ArrayList<>();
            for (String a : value) {
                String b = a.toUpperCase();
                upperCaseList.add(b);
            }

            return upperCaseList;
        }; */

        //Streamo pavyzdys

        return  names -> names.stream().map(String::toUpperCase).collect(Collectors.toList());
    }
}
