package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Monitoring monitoring = new Monitoring();
        List<Device> devices = new ArrayList<>();
        devices.add(new SmartWatch(true, 0));
        devices.add(new Computer(true, 1));
        devices.add(new MobilePhone(true, 2));
        monitoring.pingAllDevices(devices);

        devices.get(1).setOn(false);
        System.out.println("----------------");

        monitoring.pingAllDevices(devices);

    }
}
