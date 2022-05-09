package lt.codeacademy.lessons.twentyFifth.interfeisai.task3;

public class PoliceCar implements Emergency, LandVehicle{
    @Override
    public void soundSiren() {
        System.out.println("woo-woo-woo-woo-woo");
    }

    @Override
    public void drive() {
        System.out.println("Policijos masina vaziuoja");
    }

}
