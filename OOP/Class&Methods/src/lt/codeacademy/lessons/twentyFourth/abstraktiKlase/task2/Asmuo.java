package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task2;

public abstract class Asmuo {
    private final String vardas;
    private final String pavarde;

    public Asmuo(String vardas, String pavarde) {
        this.vardas = vardas;
        this.pavarde = pavarde;
    }



    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    @Override
    public String toString() {
        return
                "vardas - " + vardas + '\'' +
                ", pavarde - '" + pavarde + '\'';
    }

    public abstract void  spausdinkInformacija();
}
