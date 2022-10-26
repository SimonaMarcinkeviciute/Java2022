package lt.codeacademy.generic.Task.Task2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        List<Medis> medis = new ArrayList<>();
        List<Lapuotis> lapuociai = new ArrayList<>();
        List<Berzas> berzai = new ArrayList<>();



    }
    //Atspausdins ivairius, visus medzius, tiek louocius,tie spygliuocius
    private  void ivairusMiskas(List<? extends Medis> medziai) {
        System.out.println("Ivairus miskas");
        medziai.forEach(Medis::turi);
    }

    private <T extends  Spygliuotis> void spygliuociuMiskas(List<T> medziai) {
        System.out.println("Spygliuociu miskas");
        medziai.forEach(Spygliuotis::turi);
    }

    private void berzuMiskas(List<Berzas> medziai) {
        System.out.println("Berzu miskas");
        medziai.forEach(Berzas::turi);
    }


}
