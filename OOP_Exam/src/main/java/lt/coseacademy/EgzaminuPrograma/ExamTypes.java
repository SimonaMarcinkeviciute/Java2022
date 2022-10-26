package lt.coseacademy.EgzaminuPrograma;

public enum ExamTypes {
    TEST("Testas"),
    OPEN_QUESTIONS("Atviri klausimai"),
    MIXED_TEST("Misrus klausimai");

    final String name;

    ExamTypes(String name) {
        this.name = name;

    }

    public String getName() {
        return name;
    }


}
