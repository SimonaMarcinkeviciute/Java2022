package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task3;

public class SmartWatch extends Device{
    public SmartWatch(boolean isOn, int id) {
        super(isOn, id);
    }

    @Override
    public String toString() {
        return "SmartWatch";
    }
}
