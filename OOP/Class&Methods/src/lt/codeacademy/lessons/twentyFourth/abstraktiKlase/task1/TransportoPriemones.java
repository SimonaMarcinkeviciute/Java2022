package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class TransportoPriemones {
    private final LocalDate registracijosData;
    private final String spalva;

    public TransportoPriemones(LocalDate registracijosData, String spalva) {
        this.registracijosData = registracijosData;
        this.spalva = spalva;
    }

    public void getRegistracijosData() {
        System.out.println(registracijosData.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
    }

    public abstract void drive();
}
