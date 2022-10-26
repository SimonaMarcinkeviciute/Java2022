package lt.codeacademy.lessons.twentyFourth.inheretance.task3;

public class Asmuo {
    private  String vardas;
    private  String pavarde;

    public Asmuo(String vardas, String pavarde) {
        this.vardas = vardas;
        this.pavarde = pavarde;
    }

    public String getVardas() {
        return vardas;
    }

    public String getPavarde() {
        return pavarde;
    }

    public void setVardas(String vardas) {
        this.vardas = vardas;
    }

    public void setPavarde(String pavarde) {
        this.pavarde = pavarde;
    }

    @Override
    public String toString() {
        return String.format("Asmuo [vardas=%s, pavarde=%s]",vardas, pavarde);
    }
}
