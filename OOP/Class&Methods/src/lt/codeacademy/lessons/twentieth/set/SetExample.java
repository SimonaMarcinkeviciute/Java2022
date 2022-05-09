package lt.codeacademy.lessons.twentieth.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetExample {
    public static void main(String[] args) {
        // saugo unikalius, nesidubluojancius elementus
        SetExample example = new SetExample();
        example.hashSetExample();
        example.linkedHahSetExample();
        example.treeSetExample();

    }

    private void hashSetExample() {
        Set<String> names = new HashSet<>();
        names.add("Petras");
        names.add("Jonas");
        names.add("Antanas");
        names.add("Jokubas");
        names.add("Petras");

        System.out.println(names.size());
// neturi get metodo, pagal indeksa. negalima atspausdinti po viena
        // reiksm,es sudedemos neaiskia struktura
        System.out.println(names);
    }

    private void linkedHahSetExample() {
        Set<String> names = new LinkedHashSet<>();
        names.add("Petras");
        names.add("Jonas");
        names.add("Antanas");
        names.add("Jokubas");
        names.add("Petras");
//atspausdna taip kaip sudejom
        System.out.println(names);
    }

    private void treeSetExample() {
        Set<String> names = new TreeSet<>();
        names.add("Petras");
        names.add("Jonas");
        names.add("Antanas");
        names.add("Jokubas");
        names.add("Petras");
//atspausdina pagal abecele arba nuo maziausio skaiciaus
        System.out.println(names);
// objektu palyginti negali, todel atspausdina ir tuos pacius
        Set<Person> person = new HashSet<>();
        person.add(new Person("Andrius", 15));
        System.out.println(person);

        Set<Person> person1 = new TreeSet<>();
        person1.add(new Person("Andrius", 15));
        person1.add(new Person("Andrius", 96));
        person1.add(new Person("Andrius", 74));
//ismes exeption, nes neturi rusiavimo, reikia isideti comparaton i person klase
        //System.out.println(person1);



    }
}
