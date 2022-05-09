package lt.codeacademy.lessons.eighth.enums;

public enum MatavimoVienetai {

    MILIMETRAS(100.0f, "cm"),
    METRAS(1.0f, "m"),
    KILOMETRAS(1.000f, "km");

    float atstumas;
    String name;



    MatavimoVienetai(float atstumas, String name) {
        this.atstumas = atstumas;
        this.name = name;
    }

    public float getAtstumas() {
        return atstumas;
    }

    public String getName() {
        return name;
    }
}


