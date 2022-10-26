package lt.codeacademy.lessons.nineteenth.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class MineExamples {
    public static void main(String[] args) {
        ArrayList<String> sarasas = new ArrayList<>();
// prideti elementu i sarasa
        sarasas.add("Pirmas");
        sarasas.add("Antras");
        sarasas.add("Trecias");
        sarasas.add("Ketvirtas");
        sarasas.add("Penktas");

        System.out.println("Saraso elementai: " + sarasas);

//prideti elementu pagal indeksa
        sarasas.add(0, "Sestas");
        sarasas.add(1, "Septintas");
        System.out.println(sarasas);

//istrinti elementus
        sarasas.remove("Trecias");
        sarasas.remove("Penktas");
        System.out.println(sarasas);

//istrinti elementus pagal indeksa
        sarasas.remove(1);
        System.out.println(sarasas);

//galima pakeisti elementa pagal indeksa
        sarasas.set(2, "****");
        System.out.println(sarasas);

// galima gauti indeksa kur stovi objektas
        int objectIndex = sarasas.indexOf("****");
        System.out.println(objectIndex);

//galima gauti elementus pagal indeksa
        String elementas = sarasas.get(2);
        System.out.println(elementas);

//galima gauti saraso dydi
        int sarasoDydis = sarasas.size();
        System.out.println(sarasoDydis);

//galima patikrinti ar yra sarase elementas
        boolean arYra = sarasas.contains("Antras");
        boolean aaYra2 = sarasas.contains("Ketvirtas");
        System.out.println(arYra + " " + aaYra2);

//galima praiteruoti per visus elementus ir gauti jo indeksus
        for (String element : sarasas) {
            int i = sarasas.indexOf(element);
            System.out.println("Elementas: " + element + ", Indeksas: " + i);
        }

//galima isvalyti sarasa
        sarasas.clear();
        System.out.println(sarasas);

//galima patikrinti ar tuscuas
        boolean arTuscias = sarasas.isEmpty();
        System.out.println(arTuscias);

// skirtingi iteravimo budai
        ArrayList<String> sarasas2 = new ArrayList<>();
        sarasas2.add("Vilnius");
        sarasas2.add("Kaunas");
        sarasas2.add("Klaipeda");
        sarasas2.add("Siauliai");

        //iprastas for ciklas
        for(int i = 0; i < sarasas2.size(); i++) {
            System.out.println(sarasas2.get(i));
        }

        //for ciklas masyvams ir sarasams
        for (String element : sarasas2) {
            System.out.println(element);
        }

        //While ciklas
        int i = 0;
        while (sarasas2.size() > i) {
            System.out.println(sarasas2.get(i));
            i++;
        }

        //While + Iterator
        Iterator<String> iterator = sarasas2.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }


        //Saraso rusiavimas pagal abecele
        Collections.sort(sarasas2);
        System.out.println(sarasas2);

        //isrusiuoja abecees tvarka nuo galo
        Collections.sort(sarasas2,Collections.reverseOrder());
        System.out.println(sarasas2);

        //Vieno saraso papildymas kitu, ridedama prie pabaigos
        ArrayList<String> sarasas3 = new ArrayList<>();
        sarasas3.add("Panevezys");
        sarasas3.add("Utena");
        System.out.println(sarasas3);
        sarasas2.addAll(sarasas3);
        System.out.println(sarasas2);

        //saraso elementu sukeitimas
        Collections.swap(sarasas2, 0, 2);
        System.out.println(sarasas2);


        //Primityvus elementai sarase
        ArrayList<Integer> skaiciai = new ArrayList<>();
        skaiciai.add(2);
        skaiciai.add(4);
        skaiciai.add(5);
        skaiciai.add(6);

        System.out.println(skaiciai);

        // issiimti int kintamaji is saraso

        Integer intObjektas = skaiciai.get(1);
        int primKint = intObjektas.intValue();
        System.out.println(primKint);

    }
}
