package nesamone;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ManoMain {

    private static final int MAX_RETRY = 10;
    public Map<Integer, Student> students = new HashMap<>();

    public void StudentRegistration(Scanner scanner) {

        ObjectMapper mapper = new ObjectMapper();

        File file = new File("students.json");

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            students= mapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
            e.printStackTrace();
        }


        System.out.println("Iveskite slaptazodis");
        String password = scanner.nextLine();

        if (!isRepeatPasswordCorrect(scanner, password)) {
            System.out.println("Userio sukurti nepavyko");
            return;
        }

        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite savo pavarde");
        String surname = scanner.nextLine();

        students.put(getId(students), new Student(name, surname, password));

        System.out.println("Registracija sekminga.");


        try {
            mapper.writeValue(file, students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 /*   public void login(Scanner scanner) {
        System.out.println("Iveskite username:");
        String userName = scanner.nextLine();
        System.out.println("Iveskite slaptazodi:");
        String password = scanner.nextLine();

        String userPassword = credentials.get(userName);
        if (userPassword == null) {
            System.out.println("Tokio vartotojo nera");
            return;
        }

        if (!userPassword.equals(DigestUtils.sha512Hex(password))) {
            System.out.println("Neteisingas slaptazodis");
            return;
        }

        System.out.printf("Sveikiname %s prisijungus\n", userName);
    } */

    private boolean isRepeatPasswordCorrect(Scanner scanner, String password) {
        for (int i = 0; i < MAX_RETRY; i++) {
            System.out.println("Pakartokite slaptazodzio ivedima:");
            String repeatPassword = scanner.nextLine();

            if (!repeatPassword.equals(password)) {
                System.out.println("Slaptazodziai nesutampa");
                continue;
            }

            return true;
        }

        return false;
    }

    private Integer getId(Map<Integer, Student> persons) {
        if (persons == null) {
            return 1;
        }
        return persons.size() + 1;

    }

}

