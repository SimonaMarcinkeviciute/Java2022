package lt.codeacademy.lessons.twentyFifth.taskApstraktiVertinimas;

public class Svoriai extends Vertinimas{

    public Svoriai(int pazimys1, int pazimys2, int pazimys3) {
        super(pazimys1, pazimys2, pazimys3);
    }

    @Override
    public int galutinisBalas() {
        return getPazimys1() + getPazimys2() + getPazimys3() / 3;
    }
}
