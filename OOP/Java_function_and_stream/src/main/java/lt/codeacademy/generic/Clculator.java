package lt.codeacademy.generic;

public class Clculator <T extends Number>{
    private final T t1;
    private final T t2;

    public Clculator(T t1, T t2) {
        this.t1 = t1;
        this.t2 = t2;
    }

    public Number sum() {
        return t1.doubleValue() + t2.doubleValue();
    }
}
