/*package lt.codeacademy.baigiamasisDarbasOOP;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class ExaminationProgram {

    private static final int MAX_RETRY = 10;
    private Map<String, Student> studentsInfo = new HashMap<>();
    private Map<String, String> usersInfo = new HashMap<>();
    private List<Student> students = new ArrayList<>();

    public void StudentRegistration(Scanner scanner) {

        FileWritter fileWritter = new FileWritter();
        ObjectMapper mapper = new ObjectMapper();

        File file = new File("students.json");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            students = mapper.readValue(file, new TypeReference<>() {});
        } catch (IOException e) {
        }

        String userName = getUniqueUserName(scanner);
        System.out.println("Iveskite slaptazodis");
        String password = scanner.nextLine();

        if (!isRepeatPasswordCorrect(scanner, password)) {
            System.out.println("Userio sukurti nepavyko");
            return;
        }

        usersInfo.put(userName, DigestUtils.sha512Hex(password));

        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite savo pavarde");
        String surname = scanner. nextLine();

        Student student = new Student(name, surname);
        studentsInfo.put(userName, student);

        students.add(student);

        System.out.println("Registracija sekminga.");
        System.out.println(studentsInfo);

        fileWritter.objectWritter(file, students);


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
    }

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

    private String getUniqueUserName(Scanner scanner) {
        while (true) {
            System.out.println("Iveskite prisijungimo varda:");
            String newUserName = scanner.nextLine();

            String password = usersInfo.get(newUserName);
            if (password != null) {
                System.out.printf("Vartotjo vardas %s existuoja\n", newUserName);
                continue;
            }

            return newUserName;
        }
    }
}*/
