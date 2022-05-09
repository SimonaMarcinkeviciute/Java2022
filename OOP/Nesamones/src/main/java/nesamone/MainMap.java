/*package nesamone;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class MainMap {
    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        Map<String, Person> personList = new HashMap<>();

        File file = new File("mapstudents.json");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        MainMap map1 = new MainMap();
        try {
            map1.kazkas(personList, file, mapper);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //objekta i map
        /*String JsonString = mapper.writeValueAsString(person);
        Map<String, Object> objectToMap = mapper.readValue(JsonString, new TypeReference<>() {});
        System.out.println(objectToMap.get("name"));


    }

    public void kazkas(Map<String, Person> personList, File file, ObjectMapper mapper) throws IOException {

        Scanner scanner = new Scanner(System.in);

        System.out.println(personList);
        System.out.println("Iveskite varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite key");
        String key = scanner.nextLine();


        Person person = new Person(name, );
        personList = mapper.readValue(file, new TypeReference<>() {});
        personList.put(key, person);
        mapper.writeValue(file, personList);
    }
}*/
