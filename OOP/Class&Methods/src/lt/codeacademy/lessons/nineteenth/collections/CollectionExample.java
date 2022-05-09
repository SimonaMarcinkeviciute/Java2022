package lt.codeacademy.lessons.nineteenth.collections;

import java.util.*;

public class CollectionExample {
    public static void main(String[] args) {
        // ArrayList sukurimas, dazniausiai sutinkamas
        ArrayList<String> names = new ArrayList<>();
        List<String> names2 = new ArrayList<>();


        //LinkedList
        LinkedList<String> cities = new LinkedList<>();
        List<String> cities2 = new LinkedList<>();


// skliausteliuose nurodoma kas ten. ir modifikuoti jo negalima
        //   galima is karto sudeti daug reiksmiu
        List<String> names3 = List.of();

        // uzpildyti molekcijas, pildomas po viena,

        names.add("Andrius");
        names2.add("Petras");
        cities.add("Vilnius");
        cities2.add("Kaunas");

        // atsispausdinti, pasiimti reiksmes
        printList(names);
        printList(names2);
        printList(cities);
        printList(cities2);

        //String tipo rusiavimas pagal abecele
        names.sort((o1, o2) -> o1.compareTo(o2));
        names.sort(String::compareTo);
        Collections.sort(names);

        //atbulai ne viskas
        Collections.sort(names);

        // swap (pavadinimas, 0 , 6)

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);









    }
    // parametruose geriau naudoti tiesiog List, kad galima butu paduoti parametrus
    private  static void printList(List<String> list) {
//atspausdinti elementu skaiciu
        System.out.printf("Listo elementu skaicius: %s\n ", list.size());
// patikrinti ar kolekcijoje yra reiksame
        System.out.println(list.contains("Andrius"));
        // ismesti reiksme, daromas ne iteracijos metu
        list.remove("Antanas");


        // pirmas budas
        String value = list.get(0);
        System.out.println(value);
        // antras budas atspausdinti
        for(int i = 0; i < list.size(); i++) {
            System.out.println(i);
        }
        // budas atspausdinti geresni budai
        for (String items : list) {
            System.out.println(items);
        }
        //budas atspausdinti geresni budai
        list.forEach(System.out::println);
        // isvalo kolekcija
        list.clear();
        //tikrina ar nera tuscia
        list.isEmpty();
        //suzinom elemento indeksa
        list.indexOf("Andrius");
// naudoti iteratoriu jei norim isdeletiny
        Iterator<String> iterator = list.iterator();
        while ((iterator.hasNext())) {
            String value1 = iterator.next();
            if(value.equals("Ona")) {
                iterator.remove();
            }
            System.out.println(value1);
        }
    }
}
