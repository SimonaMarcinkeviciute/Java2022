package lt.codeacademy.lessons.thirthyFirst.task2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class MainDestytojo {
    public static void main(String[] args) throws IOException {
        MainDestytojo task = new MainDestytojo();

        File file = task.createFile();
        if (file == null) {
            return;
        }

        List<Driver> drivers = List.of(
                new Driver("Petras", "Volvo", "ABC123", "190000"),
                new Driver("John", "Audi", "ACB321", "25000")
        );

        task.write(file, drivers);
    }

    private File createFile() {
        File file = null;
        try {
            file = new File("drivers.csv");
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }

    private void write(File file, List<Driver> drivers) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            for (Driver driver : drivers) {
                bw.write(driver.toString());
                bw.newLine();
            }

            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
