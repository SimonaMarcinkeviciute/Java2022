package lt.codeacademy.function;

import java.util.function.IntSupplier;

public class ClosureFunction {
    private int count = 0;

    public IntSupplier supply(int value) {
        return () -> value + ++count;
    }

    public static void main(String[] args) {
        ClosureFunction function = new ClosureFunction();

        IntSupplier s1 = function.supply(55);
        IntSupplier s2 = function.supply(22);
        IntSupplier s3 = function.supply(97);

        System.out.println(s1.getAsInt());
        System.out.println(s2.getAsInt());
        System.out.println(s3.getAsInt());
    }
}
