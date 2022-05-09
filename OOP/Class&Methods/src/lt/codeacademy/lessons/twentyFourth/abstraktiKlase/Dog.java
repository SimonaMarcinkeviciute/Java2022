package lt.codeacademy.lessons.twentyFourth.abstraktiKlase;

public class Dog extends Animal{
    //butina overidint abstrakcios klases abstrakcius metodus
    @Override
    public void sound() {
        System.out.println("Wow wow");
    }

    @Override
    public int getAge() {
        return 12;
    }
}
