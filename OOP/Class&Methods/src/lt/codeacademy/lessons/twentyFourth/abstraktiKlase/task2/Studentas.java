package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task2;

public class Studentas extends Asmuo{

    public Studentas(String vardas, String pavarde) {
        super(vardas, pavarde);
    }

    @Override
    public void spausdinkInformacija() {
        System.out.println(super.toString());
    }
}
