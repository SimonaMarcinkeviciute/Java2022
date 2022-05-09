package lt.codeacademy.function;

import java.util.function.*;

public class FunctionExample {
    public static void main(String[] args) {

        FunctionExample example = new FunctionExample();
        Supplier<Integer> supplier = () -> 50;
        //grazina, bet nieko nepriima

        //nereikia {} jei yra viena eilute
        /*Supplier<Integer> supplier = () -> {
            int a = 50;
            return a;
        };*/

        System.out.println(supplier.get());
        example.testSupplier(supplier);
        example.testSupplier(() -> 60);
//priima per parametrus, bet nieko negrazina
        Consumer<String> consumer = (value) -> System.out.println(value.toUpperCase());
        //nebutini skliausteliai jei viena reiksme
       // Consumer<String> consumer = value -> System.out.println(value.toUpperCase())
        //iskviesti
        consumer.accept("Andrius");

//pirmas parametras ka priima, antras ka grazina
        Function<Integer, String> function = value -> String.valueOf(value * 10);
        //iskviesti
        String result = function.apply(10);
        System.out.println(result);
        // priima du parametrus ir viena grazina
      //  BiFunction<Integer, Integer, String> biFunction= (x, y) -> x != null && x.equals(y);

        //viena priima reiksme grazina boolean
        Predicate<String> predicate = value -> value!= null && value.startsWith("test");
        if(predicate.test("testing")){
            System.out.println("Praleidziam");
        }else {
            System.out.println("Nepavyko");
        }
        //priima dvi reiksmes

        BiPredicate<String, String> biPredicate = (v1, v2) -> v1 != null && v1.equals(v2);
        System.out.println(biPredicate.test("a", "a"));//true
        System.out.println(biPredicate.test("a", "aa"));//falce
//is karto nusistato kintamaji
        IntConsumer intConsumer = value -> System.out.println(value);
        intConsumer.accept(500);

        // du kintamieji
        BiConsumer<Integer, Integer> biConsumer = (x,y) -> System.out.println(x*y);
        biConsumer.accept(50, 80);

        // mano susikurtas
        MyFunctionalInterface myFunctionalInterface = (v1, v2, v3) -> System.out.println(v1 + v2 + v3);
        myFunctionalInterface.doSomething(50, 50, 40);

        example.createFunctionInterface().doSomething(40, 50, 10);

        // galima kviesti funkcijas kurios atlieka skirtingus veiksmus
        example.testMyFunctionInterface((a, b, c ) -> System.out.println(a / c * b));
        example.testMyFunctionInterface((a, b, c ) -> System.out.println(a * c - b));

       // BiFunction<Integer, Integer, Integer> myFunction = (v1, v2) -> v1 * v2;
        //BiFunction<Integer, Integer, Integer> myFunction = Math::multiplyExact;
        BiFunction<Integer, Integer, Integer> myFunction = example::sum;
        int result1 = myFunction.apply(50, 70);
        System.out.println(result1);
    }

    private int sum(int a, int b) {
        return a + b;
    }

    public void testSupplier(Supplier<Integer> supplier) {
        System.out.println(supplier.get());
    }

    private MyFunctionalInterface createFunctionInterface() {
        return (v1, v2, v3) -> System.out.println(v1 - v2 * v3);
    }

    private void testMyFunctionInterface(MyFunctionalInterface function) {
        function.doSomething(50, 70, 80);
    }


}
