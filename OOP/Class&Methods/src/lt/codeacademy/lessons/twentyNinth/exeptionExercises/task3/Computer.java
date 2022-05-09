package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task3;

public class Computer extends Device{

    public Computer(boolean isOn, int id) {
        super(isOn, id);
    }

    @Override
    public String toString() {
        return "Computer";
    }
}
