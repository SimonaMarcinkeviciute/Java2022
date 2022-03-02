package lt.codeacademy.lessons.third;

public class ConstructorExample {

    public static void main(String[] args) {

        Person person = new Person("Andrius", 45);
        person.printValues();



        Person person1 = new Person("Petras");
        person1.printValues();
    }
}
