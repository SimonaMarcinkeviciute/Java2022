package lt.codeacademy.lessons.twentieth.linkedList;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // jei noriu turieti linkeList metodus, turiu
        //pasakyti kad tai yra LinkedList kintamasis
        LinkedList<Integer> names = new LinkedList<>();
        names.add(1);
        names.addFirst(2);
        names.addLast(9);
        names.add(10);
        // istrina pirma reiksme, jei nera grazina null
        Integer poll = names.poll();
        // ismeta taip pat pirma elementa, , jei nera grazina exepyiomn
        Integer pop = names.pop();
// ideda elemta i pradzia
        names.push(5);
        // grazina pirma el jo neistrinant
        names.getFirst();
        // grazina bet neistrina paskurini
        names.getLast();


    }
}
