package lt.codeacademy.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class TestClass{
    private final String name;
    private static int count = 0;

    public TestClass(String name) {
        this.name = name;
        count ++;
    }

    @Override
    public String toString() {
        return "TestClass{" +
                "name='" + name + '\'' + "count" + count +
                '}';
    }
}

public class CreateStreamExample {
    public static void main(String[] args) {
        //1. Sukurti stream Is listo
        List<Integer> numbers = List.of(1, 56, 47, 5, 62);
        Stream<Integer> stream = numbers.stream();
        stream.forEach(System.out::println);

        //2. Stream.of(..)
        Stream<String> names = Stream.of("Jonas", "Petras", "Ona");
        names.forEach(System.out::println);

        //3. Stream.generate()
        Stream<TestClass> testVlassStream = Stream.generate(() -> new TestClass("Testing")).limit(5);
        testVlassStream.forEach(System.out::println);

        //4.Konvertuoti is masyvo Arrays.stream
        int[] items = {5, 4, 9, 10};
        IntStream itemStream = Arrays.stream(items);
        itemStream.forEach(System.out::println);

        //5 Random.ints
       IntStream randomStream =  new Random().ints(10, 500).limit(10);
       randomStream.forEach(System.out::println);



    }
}
