package lt.codeacademy.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Task3Destytojas {

    public static void main(String[] args) {
        Task3Destytojas destytojas = new Task3Destytojas();
        List<String> names = List.of();
        try(BufferedReader bf = new BufferedReader(new FileReader("people.txt"))){
            //.lines() nuskaito faila eilutemis ir sudeda i lista, tas eilutes
            names = bf.lines().filter(v -> !v.contains("vardas")).map(destytojas.getOnlyNames())
                    .filter(Objects::nonNull).distinct().sorted().toList();
         }catch (IOException e) {
            e.printStackTrace();
        }

        names.forEach(System.out::println);

    }//i MAP galima deti tik function

    private Function<String, String> getOnlyNames() {
        return line -> {
            String[] split = line.split(",");
            String name = null;

            if(split.length == 3) {
                name = split[1];
            }
            return name;
        };
    }
}
