package lt.codeacademy.lessons.twentyFourth.inheretance.task1;

public class Main {
    public static void main(String[] args) {
        Vaisius vaisius = new Vaisius();
        Vaisius vaisius1 = new Vaisius();
        Vaisius egzotinisVaisius = new EgzotinisVaisius();
        Vaisius lietuviskasVaisius = new LietuviskasVaisius();
        Vaisius mangas = new Mangas();
        Vaisius ananasas = new Ananasas();
        Vaisius kriause = new Kriause();
        Vaisius obuolys = new Obuolys();
        Vaisius antaninis = new Antaninis();
        Vaisius alyvinis = new Alyvinis();

        vaisius.kasAsEsu();
        egzotinisVaisius.kasAsEsu();
        lietuviskasVaisius.kasAsEsu();
        mangas.kasAsEsu();
        ananasas.kasAsEsu();
        kriause.kasAsEsu();
        obuolys.kasAsEsu();
        antaninis.kasAsEsu();
        alyvinis.kasAsEsu();

        System.out.println(vaisius.equals(vaisius1));
    }
}
