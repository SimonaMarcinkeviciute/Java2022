package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task4;

public class Kvadratas extends Figura {
    @Override
    public double gautiPlota(double ilgis) {
        return Math.pow(ilgis, 2);
    }

    @Override
    public double gautiPerimetra(double ilgis) {
        return 4 * ilgis;
    }
}
