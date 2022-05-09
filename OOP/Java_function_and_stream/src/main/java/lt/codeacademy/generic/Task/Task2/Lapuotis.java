package lt.codeacademy.generic.Task.Task2;

public class Lapuotis implements Medis{
    private final MedziuRusys medziuRusys;

    public Lapuotis(MedziuRusys medziuRusys) {
        this.medziuRusys = medziuRusys;
    }

    @Override
    public void turi() {
        System.out.printf("%s turi labus\n", medziuRusys.getName());
    }
}
