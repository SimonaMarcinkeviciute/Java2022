package lt.codeacademy.stream;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamExamples {
    public static void main(String[] args) {

        //MAP
        List<String> names = List.of("Petras", "Jonas", "Antanas", "Ona", "Kazys");

        //kolekcija verciam i stream
        //map, modfikavimui, priima funkcija
        //names.stream().map(v -> v.toUpperCase());
        //collect - grzina nauja lista
        //List<String> uppperCaseNmaes = names.stream().map(String::toUpperCase).toList();
        List<String> uppperCaseNmaes = names.stream().map(String::toUpperCase).toList();

        uppperCaseNmaes.forEach(System.out::println);
        //identiska siam variantui
        //uppperCaseNmaes.forEach(v -> System.out.println(v));

        //konvertuoti string i int
        List<String> stringNumbers = List.of("4", "54", "2");
        List<Integer> integers = stringNumbers.stream().map(Integer::valueOf).toList();

        //FILTER

        //filtruojam vardus, kuriu ilgis yra daugiau arba lygu 6
        //fintFirst, = randa pati pirma kuris atitinka salyga
        List<String> sortedNames = names.stream().filter(v -> v.length() >= 6).map(String::toUpperCase).sorted().toList();
        sortedNames.forEach(System.out::println);

        StreamExamples examples = new StreamExamples();
// suranda pirma varda, kuris ilgesnis uz 6, jei neranda grazina null
        String firstName = names.stream().filter(examples.checkName()).findFirst().orElse(null);

        //FLATMAP
        //apjungia kelias kolekcijas i viena

        List<List<Integer>> numbersOfNumbers = List.of(List.of(5, 8, 6, 5), List.of(9, 8, 5, 4), List.of(55, 8, 9, 5, 22));
        List<Integer> fileteredNumbers = numbersOfNumbers.stream().flatMap(Collection::stream).
                filter(v -> v > 5)
                .toList();

        System.out.println(fileteredNumbers);

        //REDUCE
        //priima funkcija ir apjungia dvi reiksmes,
        Optional<String> reduce = names.stream().reduce((v1, v2) -> v1 + " " + v2);
        /*if(reduce.isPresent()) {
            System.out.println(reduce.get());
        }*/
        reduce.ifPresent(System.out::println);

        //skaiciu bendras ruzultatas
        Integer result = integers.stream().reduce(0, (v, v2) -> v + v2);// Integer::sum
        System.out.println(result);

        //MIN\MAX
        //Didziausia ir maziausia reiksmes
        System.out.println("Max " + integers.stream().max(Integer::compareTo).orElse(0));
        System.out.println("Min " + integers.stream().min(Integer::compareTo).orElse(0));


    }

    private Predicate<String> checkName() {
        return v -> v.length() > 6;
    }
}
