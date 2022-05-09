package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task1;

import java.time.LocalDate;

public class Sunkvezimis extends TransportoPriemones{
    private final int maksimalusKrovinioDydis;

    public Sunkvezimis(LocalDate registracijosData, String spalva, int maksimalusKrovinioDydis) {
        super(registracijosData, spalva);
        this.maksimalusKrovinioDydis = maksimalusKrovinioDydis;
    }

    @Override
    public void drive() {
        System.out.println("Sunkvezimis vaziuoja");
    }

    public double getMaxSvoris() {
        return maksimalusKrovinioDydis;
    }
}
