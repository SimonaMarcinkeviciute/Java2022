package lt.codeacademy.lessons.twentyFifth.taskApstraktiVertinimas;

public class VisiIslaikyti extends Vertinimas {

    public VisiIslaikyti(int pazimys1, int pazimys2, int pazimys3) {
        super(pazimys1, pazimys2, pazimys3);
    }

    @Override
    public int galutinisBalas() {
        int vidurkis;
        if(getPazimys1() > 4 && getPazimys2() > 4 && getPazimys3() > 4) {
          //  getPazimys1() + getPazimys2() + getPazimys3() / 3;
        }
        return 0;
    }
}
