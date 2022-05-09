package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task2;

public class Main {

    public static void main(String[] args) {
        Asmuo destytojas = new Destytojas("Petras", "Petraitis");
        Asmuo studentas = new Studentas("Antanas", "Antanaitis");

        destytojas.spausdinkInformacija();
        System.out.println(destytojas);
        studentas.spausdinkInformacija();
        System.out.println(studentas);
    }
}
