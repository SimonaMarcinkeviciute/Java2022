package lt.codeacademy.stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task3 {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader("people.txt"))) {
            String line;
            while ((line = br.readLine()) != null ) {
                String[] splittedLine = line.split(",");
                if(!splittedLine[1].trim().equals("vardas")){
                    names.add(splittedLine[1].trim());
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

       List<String> sortedNames = names.stream().distinct().sorted().toList();
        System.out.println(sortedNames);
    }

}
