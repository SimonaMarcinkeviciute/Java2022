package lt.codeacademy.generic.Task.Task2;

public enum MedziuRusys {
    AZUOLAS("Azuoliukas"),
    BERZAS("Berzas"),
    EGLE("Egle"),
    KADAGYS("Kadagys"),
    PUSIS("Pusis");

    private final String name;

    MedziuRusys(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
