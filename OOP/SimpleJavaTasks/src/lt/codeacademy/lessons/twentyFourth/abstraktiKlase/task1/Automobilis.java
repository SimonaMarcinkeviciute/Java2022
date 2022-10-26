package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task1;

import java.time.LocalDate;

public class Automobilis extends TransportoPriemones{
    private final int bagazinesTalpa;

    public Automobilis(LocalDate registracijosData, String spalva, int bagazinesTalpa) {
        super(registracijosData, spalva);
        this.bagazinesTalpa = bagazinesTalpa;
    }

    public int getBagazinesTalpa() {
        return bagazinesTalpa;
    }

    @Override
    public void drive() {
        System.out.println("Automobilis vaziuoja");
    }
}
