package lt.codeacademy.function;

import java.util.function.Function;


public class MultipleFunction {


    String value;
    public static void main(String[] args) {
        Function<String, Function<String, String>> multipleFunction = value -> {
            Function<String, String> otherFunction = value2 -> value + " " + value2;
            return otherFunction;
        };

        String result = multipleFunction.apply("Pirmas").apply("Antras");
        System.out.println(result);

        //geresnis uzrasymas
        Function<String, Function<String, String>> myOther = value -> value2 -> value + " " + value2;

        MultipleFunction mf = new MultipleFunction();
        String value = mf.first("Testas").second("kitas");
        System.out.println(value);

    }

    public MultipleFunction first(String value) {
        this.value = value;
        return this;
    }

    public String second(String value) {
        return  this.value + " " + value;
    }
}
