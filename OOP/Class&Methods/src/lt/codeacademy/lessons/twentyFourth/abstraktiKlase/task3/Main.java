package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task3;

public class Main {
    public static void main(String[] args) {

        Asmuo studentas = new Studentas("Simona");
        Asmuo studentas2 = new Studentas("Simona");
        Asmuo destytojas = new Destytojas("Simona");

        Asmuo[] asmenys = {studentas, destytojas, studentas2};

        System.out.println(studentas.array(asmenys));
        System.out.println(destytojas.array(asmenys));




    }
}
