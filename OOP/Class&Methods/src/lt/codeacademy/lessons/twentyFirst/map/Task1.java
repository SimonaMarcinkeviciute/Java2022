package lt.codeacademy.lessons.twentyFirst.map;

import java.util.HashMap;

//Toliau tęsti pirmoje užduotyje naudotą programą•Padaryti metodą spausdintiMap, kuris priima paduotą HashMap
// irjį atspausdina ankstesnėje užduotyje aprašytu formatuvoid spausdintiMap(HashMap<Integer, String> mapas)
// {...}•Metodą iškviesti paduodant jam užpildytą HashMap•Iš HashMap‘o pašalinti porą pagal raktą, pvz. 11.
// •Atspausdinti HashMap tuo pačiu formatu•Išvalyti visą HashMap•Atspausdinti HashMap tuo pačiu formatu

public class Task1 {
    public static void main(String[] args) {
        HashMap<Integer, String> task = new HashMap<>();
        task.put(1, "Vienas");
        task.put(2, "Du");
        task.put(3, "Trys");
        task.put(4, "Keturi");
        task.put(5, "Penki");

        System.out.println(task);
        System.out.println(task.containsKey(1));
        System.out.println(task.get(2));

        Task1 task1 = new Task1();
        task1.spausdintiMap(task);
        System.out.println("----------------");

        task.remove(1);

        task1.spausdintiMap(task);
        System.out.println("----------------");

        task.clear();
        task1.spausdintiMap(task);



    }

    private void spausdintiMap(HashMap<Integer, String> task) {
        // atspausdinti ir rakta ir reiksme
        for (Integer key : task.keySet()) {
            System.out.printf("Raktas: %s, Reiksme %s.\n", key, task.get(key));
        }

    }
}
