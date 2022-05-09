package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task3;

public class MobilePhone extends Device{

    public MobilePhone(boolean isOn, int id) {
        super(isOn, id);
    }

    @Override
    public String toString() {
        return "MobilePhone";
    }
}
