package lt.codeacademy.lessons.twentyFourth.abstraktiKlase;

public class Cat extends Animal{
    @Override
    public void sound() {
        System.out.println("Miau miau");
    }

    @Override
    public int getAge() {
        return 10;
    }
}
