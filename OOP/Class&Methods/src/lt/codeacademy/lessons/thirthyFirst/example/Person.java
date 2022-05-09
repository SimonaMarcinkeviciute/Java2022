package lt.codeacademy.lessons.thirthyFirst.example;

import java.io.Serializable;

public class Person implements Serializable {
    private final String name;
    private final int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }



    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
