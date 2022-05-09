package lt.codeacademy;

public class Person {
    private final int id;
    private final String name;
    private final String surname;
    private static int counter;

    public Person(int id, String name, String surname) {
        id = counter;
        this.id = id;
        this.name = name;
        this.surname = surname;

    }
}
