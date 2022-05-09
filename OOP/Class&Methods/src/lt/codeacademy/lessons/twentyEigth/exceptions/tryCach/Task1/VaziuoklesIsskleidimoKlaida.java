package lt.codeacademy.lessons.twentyEigth.exceptions.tryCach.Task1;

public class VaziuoklesIsskleidimoKlaida extends Exception{
    private final String priezastis;


    public VaziuoklesIsskleidimoKlaida(String message, String priezastis) {
        super(message);
        this.priezastis = priezastis;
    }

    public String getPriezastis() {
        return priezastis;
    }
}
