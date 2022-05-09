package lt.codeacademy.generic.Task;

import java.util.List;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();

        List<String> stringList = List.of("Hello", "World");
        List<Integer> intList = List.of(1, 2, 3);

        task1.printList(stringList);
        task1.printList(intList);
    }

    private <E> void printList(List<E> elementsList) {
        elementsList.forEach(System.out::println);

    }
}
