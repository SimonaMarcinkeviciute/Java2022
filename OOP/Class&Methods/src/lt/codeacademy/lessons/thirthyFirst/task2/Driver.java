package lt.codeacademy.lessons.thirthyFirst.task2;

import java.io.Serializable;

public class Driver implements Serializable {
    private final String name;
    private final String car;
    private final String licensePlate;
    private final String mileage;

    public Driver(String name, String car, String licensePlate, String mileage) {
        this.name = name;
        this.car = car;
        this.licensePlate = licensePlate;
        this.mileage = mileage;
    }



    @Override
    public String toString() {
        return name + ", " + car + ", " +
                licensePlate + ", " + mileage;
    }
}
