package lt.codeacademy.JsonFileTask3;

import com.github.javafaker.Faker;
import com.github.lbovolini.mapper.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Main {

    private ObjectMapper objectMapper;
    private File file;

    public static void main(String[] args) throws IOException {

        Main task = new Main();
        task.objectMapper = new ObjectMapper();
        Faker faker = new Faker();


        task.file = new File("companies.json");
        if (!task.file.exists()) {
            task.file.createNewFile();
        }

        List<Company> Companies = List.of(
                new Company(faker.company().name(), faker.code().ean8(), faker.number().randomDigit(), faker.number().randomDigit()));



    }

    }

