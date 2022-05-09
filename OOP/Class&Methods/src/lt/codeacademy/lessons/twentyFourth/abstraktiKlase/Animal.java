package lt.codeacademy.lessons.twentyFourth.abstraktiKlase;

public abstract class Animal {
    //jinai gali tureti ir paparastu metodu
    public void testMethod() {
        System.out.println("Test simple method");
    }

    //abstaktus metodai
    public abstract void sound();

    public abstract int getAge();

    public void printInfo() {
        System.out.println("Gyvuno amzius yra " + getAge());
    }
}
