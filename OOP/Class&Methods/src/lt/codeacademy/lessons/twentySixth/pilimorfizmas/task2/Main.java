package lt.codeacademy.lessons.twentySixth.pilimorfizmas.task2;

public class Main {
    public static void main(String[] args) {
        X x = new X();
        A a = new A(x);
        B b = new B();

        b.metodasX();
        a.getX().metodasX();


    }
}
