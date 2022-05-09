package lt.codeacademy.lessons.twentieth.linkedList;

import java.util.LinkedList;

public class Task7 {
    public static void main(String[] args) {
        LinkedList<String> texts = new LinkedList<>();
        texts.add("Vienas");
        texts.add("Du");
        texts.add("Trys");
        texts.add("Keturi");

        System.out.println(texts.getFirst());
        System.out.println(texts.getLast());
        System.out.println("---------------");
        System.out.println(texts.pollFirst());
        System.out.println(texts.pollLast());
        System.out.println("---------------");
        // supushinam i prieki
        texts.push("Penki");
        System.out.println(texts);
        System.out.println("---------------");
        // istrina pirma
        System.out.println(texts.pop());
        System.out.println(texts);



    }
}
