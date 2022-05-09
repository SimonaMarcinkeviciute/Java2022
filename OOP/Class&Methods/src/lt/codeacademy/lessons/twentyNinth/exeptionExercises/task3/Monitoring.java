package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task3;

import java.util.List;

public class Monitoring {
    public void pingAllDevices(List<Device> devices) {

        for (Device d : devices) {
            try {
                d.ping(d);
                System.out.printf("Device %s with id %s is ON \n", d.getClass().getSimpleName(), d.getId());
            } catch (DeviceIsOfExeption e) {
                System.out.printf("Device %s with id %s is Off \n", d.getClass().getSimpleName(), d.getId());
            }

        }
    }
}

