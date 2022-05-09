package lt.codeacademy.lessons.thirthyFourth.varargs.task1;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task1 {
    public static void main(String[] args) {

        Task1 task1 = new Task1();
        task1.print(LocalDate.now(), new ManoKlase(), "Labas");
        task1.print(LocalDate.now(), new ManoKlase(), "Labas", "Labas");

    }


    private void print(Object... objects) {

        for(Object t : objects) {
            System.out.println(t);
        }
        System.out.println("-----------------");
    }
}
