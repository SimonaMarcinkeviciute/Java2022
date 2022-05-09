package lt.codeacademy.lessons.twentyFirst.map;

import lt.codeacademy.lessons.twentieth.set.Person;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args) {

        // sukkurimas
//atspaysdint 4 yrasus,, atspausdins 3 key Ona, nes perraso buvusia reiksme
        Map<Integer, String> names = new HashMap<>();
        names.put(1,"Andrius");
        names.put(3,"Petras");
        names.put(5,"Jonas");
        names.put(2,"Andrius");
        names.put(3,"Ona");

        System.out.println(names.get(3));
        System.out.println(names);
        System.out.println(names.size());
        System.out.println(names.isEmpty());
        System.out.println(names.values());
        System.out.println(names.containsKey(5));
        System.out.println(names.replace(3, "Ona"));

        Map<Integer, String> cars = new LinkedHashMap<>();
        cars.put(2,"bmw");
        cars.put(5,"audi");
        cars.put(6,"vw");
        cars.put(7,"opel");
        cars.put(1,"toyota");
// atspausdins taip kaip sudejom
        System.out.println(cars);


             // rikiuoja pgal key
        Map<Integer, String> cieties = new TreeMap<>();
        cieties.put(5, "Alytus");
        cieties.put(2, "Panevezys");
        cieties.put(10, "Kaunas");



        Map<String, String> names2 = Map.of("k1", "v1");
        //galima gauti reiksme pagal key
        System.out.println(names2.get("k1"));

        // taip galima gauti key reiksmes
        for (String key : names2.keySet()) {
            System.out.println(key);
        }
        // taip galima psiimti abi reiksmes.
        for (String key : names2.keySet()) {
            System.out.printf("s%-s%", key, names2.get(key));
        }
//atspausdinti reiksmes
        for (String value : names2.values()) {
            System.out.println(value);
        }
        // gauti key ir values
        for(Map.Entry<String, String> entry : names2.entrySet()){
            System.out.printf("%s-%s\n", entry.getKey(), entry.getValue());
        }
        //atspausdins visus objektus, nes key yra unikalus
        Map<String, Person> persons = new HashMap<>();
        persons.put("Andrius", new Person("Andrius", 82));
        persons.put("Petras", new Person("Andrius", 82));
        persons.put("Antanas", new Person("Jonas", 10));
        persons.put("Jokubas", new Person("Andrius", 82));

// atspausdins jei tures tuos perrasymo objektu metodus
        //tik unikalius objektus, jei nebus tu metodu, tai viska
        Map<Person, Integer> persons2 = new HashMap<>();
        persons2.put(new Person("Andrius", 82), 5);
        persons2.put(new Person("Jonas", 10), 10);
        persons2.put(new Person("Andrius", 82), 59);


    }
}
