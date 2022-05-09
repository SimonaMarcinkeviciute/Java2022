package lt.codeacademy.lessons.twentyFourth.abstraktiKlase;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();
        dog.printInfo();

        Animal animal = new Cat();
        animal.sound();
        animal.printInfo();
// norint sukurti abstrakt klases objekta, reikia butinai ji overide
      /*  Animal animal1 = new Animal() {
            @Override
            public void sound() {
                System.out.println("Inline");
            }
        }

        animal1.sound(); */
    }
}
