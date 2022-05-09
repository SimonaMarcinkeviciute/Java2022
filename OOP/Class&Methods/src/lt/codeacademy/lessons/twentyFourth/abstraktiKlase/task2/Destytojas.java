package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task2;

public class Destytojas extends Asmuo{

    public Destytojas(String vardas, String pavarde) {
        super(vardas, pavarde);
    }

    @Override
    public void spausdinkInformacija() {
        System.out.printf(super.toString());
    }
}
