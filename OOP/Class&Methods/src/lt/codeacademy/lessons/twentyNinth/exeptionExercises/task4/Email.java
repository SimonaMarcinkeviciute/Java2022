package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task4;

public class Email {
    private String adresas;
    private String gavejas;
    private Busena busena;

    public Email(String turinys, String gavejas, Busena busena) {
        this.adresas = turinys;
        this.gavejas = gavejas;
        this.busena = busena;
    }

    public String getAdresas() {
        return adresas;
    }

    public void setAdresas(String turinys) {
        this.adresas = adresas;
    }

    public String getGavejas() {
        return gavejas;
    }

    public void setGavejas(String gavejas) {
        this.gavejas = gavejas;
    }

    public Busena getBusena() {
        return busena;
    }

    public void setBusena(Busena busena) {
        this.busena = busena;
    }

    @Override
    public String toString() {
        return "Email{" +
                "adresas='" + adresas + '\'' +
                ", gavejas='" + gavejas + '\'' +
                ", busena='" + busena + '\'' +
                '}';
    }
}
