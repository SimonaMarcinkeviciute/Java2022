package lt.codeacademy.lessons.twentyFirst.map;

//Sukurti HashMap<Integer, String> ir įdėti į jį key-value porų.put(..., ...)•11 -> ”vienuolika”, 12 ->
// “dvylika”, 100 -> “šimtas”, ...•Iš esamo HashMap‘o padaryti kitą HashMap<String, Integer>, kurisbūtų:
// •„vienuolika“ -> 11, “dvylika” ->12, ...•Papildyti programą nauju metodu, kuris mokėtų atspausdinti tokį
// HashMap‘ą pagal ankstesnį formatą•Vėliau atspausdinti tik HasMap‘o raktus

import java.util.HashMap;

public class Task3 {
    public static void main(String[] args) {

        HashMap<Integer, String> numbers = new HashMap<>();
        numbers.put(11, "vienuolika");
        numbers.put(12, "dvylika");
        numbers.put(100, "simtas");

        System.out.println(numbers);

        HashMap<String, Integer> newNumbers = new HashMap<>();

        for (Integer key : numbers.keySet()) {
            newNumbers.put(numbers.get(key), key);
        }

        Task3 task3 = new Task3();
        task3.spausdintiNewNumbers(newNumbers);
        task3.spausdintiKeys(newNumbers);
    }

    private void spausdintiNewNumbers(HashMap<String, Integer> task) {
        // atspausdinti ir rakta ir reiksme
        for (String key : task.keySet()) {
            System.out.printf("Raktas: %s, Reiksme %s.\n", task.get(key), key);
        }
    }

    private void spausdintiKeys(HashMap<String, Integer> task) {
        // atspausdinti  rakta
        for (String key : task.keySet()) {
            System.out.printf("Raktas: %s.\n", key);
        }
    }

}
