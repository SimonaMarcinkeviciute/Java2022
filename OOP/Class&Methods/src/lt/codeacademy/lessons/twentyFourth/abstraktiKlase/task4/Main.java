package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task4;

public class Main {
    public static void main(String[] args) {

        Figura apskritimas = new Apskritimas();
        Figura kvadratas = new Kvadratas();

        System.out.printf("Apskritimo perimetras: %.2f, plotas: %.2f\n", apskritimas.gautiPerimetra(4), apskritimas.gautiPlota(4));
        System.out.printf("Kvadrato perimetras: %.2f, plotas: %.2f\n", kvadratas.gautiPerimetra(4), kvadratas.gautiPlota(4));
    }
}
