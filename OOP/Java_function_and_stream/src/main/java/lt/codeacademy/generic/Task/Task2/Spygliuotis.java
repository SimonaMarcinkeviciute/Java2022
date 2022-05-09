package lt.codeacademy.generic.Task.Task2;

public class Spygliuotis  implements Medis{

    private final MedziuRusys medziuRusys;

    public Spygliuotis(MedziuRusys medziuRusys) {
        this.medziuRusys = medziuRusys;
    }

    @Override
    public void turi() {
        System.out.printf("%s turi spyglius", medziuRusys.getName());
    }
}
