package lt.coseacademy.EgzaminuPrograma.program;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.coseacademy.EgzaminuPrograma.Exam;
import lt.coseacademy.EgzaminuPrograma.Main;
import lt.coseacademy.EgzaminuPrograma.Student;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class UniversityExamsProgram {

    protected ObjectMapper mapper = new ObjectMapper();
    protected Map<Integer, Student> students = new HashMap<>();
    protected File file = new File("students.json");
    protected File file2 = new File("exams.json");
    protected Map<Integer, Exam> exams = new HashMap<>();
    protected static final int MAX_RETRY = 5;
    protected Main main = new Main();

    public Integer getId() {
        return null;
    }

    public void Registration(Scanner scanner) {}

    public void login(Scanner scanner) {}

    public boolean isIdCorrect(Scanner scanner) {
        return false;
    }

    public void fileReader() {
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        studentFileReader();
        examsFileReader();
    }

    public void writteExamsToFile(){
        try {
            mapper.writeValue(file2, exams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writteStudentsToFile() {
        try {
            mapper.writeValue(file, students);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void studentFileReader() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (file.length() != 0) {
            try {
                students = mapper.readValue(file, new TypeReference<>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void examsFileReader() {
        if (!file2.exists()) {
            try {
                file2.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (file2.length() != 0) {
            try {
                exams = mapper.readValue(file2, new TypeReference<>() {
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
