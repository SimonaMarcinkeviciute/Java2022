package lt.codeacademy.manoPabandymai;

import java.util.function.*;

public class ManoFunkcijuPavyzdziai {
    public static void main(String[] args) {
        ManoFunkcijuPavyzdziai pavyzdys = new ManoFunkcijuPavyzdziai();

        //SUPLIER

        //grazina bet koki tipa, bet nepriima jokiu parametru
        Supplier<Integer> funkcija = () -> 50;
        //galima prsiskirti rezultata
        int rusultInt = funkcija.get();
        System.out.println(rusultInt);
        //atspasudinti su metodu get.
        System.out.println(funkcija.get());
        //kvieciam metoda testSuplier, per klases ubjekta, paduodant ta funkcija
        pavyzdys.testSuplier(funkcija);
        //arba galima is karto lanbda israiska paduoti
        pavyzdys.testSuplier(() -> 60);

        // CONSUMER
        //Priima per parametrus, bet nieko negrazina
        Consumer<String> consumer = value -> System.out.println(value.toUpperCase());
        //Iskvietimas
        consumer.accept("Labas");
        //Paduoti i metoda
        pavyzdys.testConsumer(consumer);

        //BICONSUMER
        //priima du parametrus, bet nieko negrazina
        BiConsumer<Integer, Integer> biConsumer = (x, y) -> System.out.println(x*y);
        biConsumer.accept(50, 80);

        //FUNCTION
        //Priima parametrus ir grazina rezultata
        Function<Integer, String> function = value -> String.valueOf(value * 10);
        //grazinama rezultata galima priskirti kintamajam
        String result = function.apply(10);
        System.out.println(result);

        //BIFUNCTION
        //Priima du parametrus ir grazina viena rezultata
        BiFunction<Integer, Integer, String> biFunction = (x, y) -> String.valueOf(x * y);
        System.out.println(biFunction.apply(50, 10));

        //PREDICATE
        //Priima viena parametra ir grazina boolean, kai reikia kazka patikrinti
        Predicate<String> predicate = value -> value!= null && value.startsWith("test");
        //norint patikrinti reikia isideti i if
        if(predicate.test("testinga")){
            System.out.println("zodis prasideda test");
        }else{
            System.out.println("Neprasideda");
        }

        //BiPredicate
        //Priima dvi reiksmes, ir jas patikrina, grazina boolean
        BiPredicate<String, String> biPredicate = (x, y) -> x != null && x.equals(y);
        System.out.println(biPredicate.test("a", "aa"));//false

        // FUNKCINIS INTEFEISAS
        FunkcinisInterfeisas functionalInterface = (v1, v2, v3) -> System.out.println(v1 + v2 + v3);
        functionalInterface.doSomething(10, 10, 10);

        //Kvieciam ta funkcini interfeisa aprasyta kaip metoda
        pavyzdys.createInterfeis().doSomething(10, 10, 10);

        //kvieciam metoda, kuriam paduodam savo sukurta interfeisa
        pavyzdys.manoInterfeisas(functionalInterface);

        //Jei atitnka paduoti parametrai galima iskviesti is klases kitos, metoda
        //klase Math ir jos funkcija multiplay, ir gausime ta pati
        //gali buti ir musu customizuota klase, turi atitikti metodo parametrai ir grazinamas tipas
        BiFunction<Integer, Integer, Integer> myFunction = (v1, v2) -> v1 * v2;
        BiFunction<Integer, Integer, Integer> myFunction1 = Math::multiplyExact;
        int myresult = myFunction1.apply(50, 70);
        System.out.println(myresult);

        //per funkcini interfeisa galiu pasiekti ir savo susikurta metoda, per tos klases objekta, jei atitinhka parametrai ir grazinamas tipas
        BiFunction<Integer, Integer, Integer> myFunction2 = pavyzdys::sum;
        System.out.println(myFunction2.apply(1, 5));



    }

    //mano susikurtas klases metodas.
    private int sum(int a, int b) {
        return a + b;
    }
    // SUPLIER
    //taip galima perduoti suplier funkcija i metoda
    public void testSuplier(Supplier<Integer> funkcija) {
        System.out.println(funkcija.get());
    }

    public void testConsumer(Consumer<String> consumer) {
        consumer.accept("Labas");
    }

    //Mano funkcinis interfeisas aprasytas kaip metodas
    private FunkcinisInterfeisas createInterfeis() {
        return (v1, v2, v3) -> System.out.println(v1 - v2 * v3);
    }


    //paduodam savo sukurta funkcini interfeisa i metoda
    public void manoInterfeisas(FunkcinisInterfeisas funkcinisInterfeisas) {
        funkcinisInterfeisas.doSomething(10, 10, 10);
    }



}
