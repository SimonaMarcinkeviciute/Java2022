package lt.codeacademy.lessons.twentyFifth.taskApstraktiVertinimas;

public abstract class Vertinimas {
    private final int pazimys1;
    private final int pazimys2;
    private final int pazimys3;

    public Vertinimas(int pazimys1, int pazimys2, int pazimys3) {
        this.pazimys1 = pazimys1;
        this.pazimys2 = pazimys2;
        this.pazimys3 = pazimys3;
    }

    public int getPazimys1() {
        return pazimys1;
    }

    public int getPazimys2() {
        return pazimys2;
    }

    public int getPazimys3() {
        return pazimys3;
    }

    public abstract int galutinisBalas();
}
