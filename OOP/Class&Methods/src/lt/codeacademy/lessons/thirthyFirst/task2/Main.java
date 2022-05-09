package lt.codeacademy.lessons.thirthyFirst.task2;

import lt.codeacademy.lessons.thirthyFirst.example.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class    Main {
    public static void main(String[] args) {
        List<Driver> drivers = new ArrayList<>();
        drivers.add(new Driver("James", "Kia", "BBB716", "160648"));
        drivers.add(new Driver("Robert", "Tesla", "EV0010", "144969"));
        drivers.add(new Driver("John", "Mazda", "JAY777", "144395"));
        drivers.add(new Driver("Michael", "Toyota", "GHM496", "81702"));
        drivers.add(new Driver("William", "Honda", "LRS001", "83210"));

        File file = new File("drivers.csv");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Driver driver : drivers) {

            try (ObjectOutputStream ob = new ObjectOutputStream(new FileOutputStream(file, true))) {
                ob.writeObject(driver.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        for (Driver driver : drivers) {

            try (ObjectInputStream ob = new ObjectInputStream(new FileInputStream(file))) {
                ob.readObject();
                System.out.println(driver);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}





