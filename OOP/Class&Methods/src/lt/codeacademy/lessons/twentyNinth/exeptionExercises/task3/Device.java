package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task3;

public class Device {
    private static int count = 0;
    private boolean isOn;
    private final int id;

    public Device(boolean isOn, int id) {
        this.isOn = isOn;
        this.id = id;
    }

    public void ping(Device device) throws DeviceIsOfExeption {

        if (!device.isOn) {
            throw new DeviceIsOfExeption();
        }
    }

    public boolean isOn() {
        return isOn;
    }

    public int getId() {
        return id;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

}
