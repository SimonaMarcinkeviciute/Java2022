package lt.codeacademy.lessons.fiftheen.staticFinal;

public class Student {
    private final int sudentoID;
    private String vardas;
    private final int metai;

    // final reiksmes priskiriam per konstruktoriu,k ad jie butu skirtingi bet nemodifikuojmi


    public Student(int sudentoID, String vardas, int metai) {
        this.sudentoID = sudentoID;
        this.vardas = vardas;
        this.metai = metai;
    }

    // metodai kurie pasiima reiksme

    public int getSudentoID() {
        return sudentoID;
    }

    public String getVardas() {
        return vardas;
    }

    public int getMetai() {
        return metai;
    }

    // metodas kuris pakeicia reikme

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void printInfo() {
        System.out.printf("ID: s% NAME: %s AGE: %s\n");
    }
}
