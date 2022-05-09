package lt.codeacademy.lessons.fiftheen.staticFinal;

public class Main {
    public static void main(String[] args) {
        BlaBlaBla blaBlaBla = new BlaBlaBla();
        System.out.println(blaBlaBla.getNumber());
        new BlaBlaBla();
        new BlaBlaBla();
        new BlaBlaBla();
        new BlaBlaBla();
        blaBlaBla = new BlaBlaBla();
        System.out.println(blaBlaBla.getNumber());
        blaBlaBla = new BlaBlaBla();
        System.out.println(blaBlaBla.getNumber());

    }
}
