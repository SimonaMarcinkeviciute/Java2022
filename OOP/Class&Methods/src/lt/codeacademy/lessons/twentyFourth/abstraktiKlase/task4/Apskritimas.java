package lt.codeacademy.lessons.twentyFourth.abstraktiKlase.task4;

public class Apskritimas extends Figura {
    @Override
    public double gautiPlota(double ilgis) {
        return Math.PI * Math.pow(ilgis, 2);
    }

    @Override
    public double gautiPerimetra(double ilgis) {
        return 2 * Math.PI * ilgis;
    }
}
