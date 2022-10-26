package lt.coseacademy.EgzaminuPrograma;

public enum ExamStatus {
    PASSED("Egzaminas islaikytas"),
    FALED("Egzaminas neislaikytas"),
    WAITING("Egzaminas taisomas");

    final String name;

    ExamStatus(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }


}