package lt.codeacademy.lessons.nineteenth.collections;

import java.util.ArrayList;
import java.util.List;

public class KoordinateMain {
    public static void main(String[] args) {
        List<Koordinate> sarasas = new ArrayList<>();
        sarasas.add(new Koordinate(2, 5));
        sarasas.add(new Koordinate(1, 5));
        sarasas.add(new Koordinate(5, 9));
        sarasas.add(new Koordinate(4, 0));
        sarasas.add(new Koordinate(0, 0));
        sarasas.add(new Koordinate(9, 1));

        System.out.println();
        Koordinate koordinate = null;
        for (Koordinate c : sarasas) {
            //pasiimti reiksmes reikalingi getteriai, nes kintamieji private
            if(c.getX() == 0 && c.getY() == 0) {
                koordinate = c;
                break;
            }
        }

        System.out.printf("Kordinate yra sarase %s\n", sarasas.indexOf(koordinate));
        // tam kad butu galima pakeisti koordinates reikalingas buvo seteris
        koordinate.setX(1);
        koordinate.setY(1);

        System.out.println(sarasas);
    }
}
