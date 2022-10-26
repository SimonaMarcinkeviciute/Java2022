package lt.codeacademy.lessons.twentieth.set;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
// sukuria du metodus, jie gales patikrinti ar nera tu paciu objektu
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public int compareTo(Person o) {

        // logika sudelioti objekto reiksmes
       /* if(name.equals(o.getName())) {
            if(age == o.getAge()) {
                return 0;
            }
            return age > o.getAge() ? 1 : -1;
        }
        return name.compareTo(o.getName());*/

        int comp = name.compareTo(o.getName());
        if(comp == 0) {
            if(age == o.getAge()) {
                return 0;
            }
            return  age > o.getAge() ? 1 : -1;
        }
        return comp;
    }
}
