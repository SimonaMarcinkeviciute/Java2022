package lt.codeacademy.lessons.fiftheen.staticFinal;

public class ApskritimoPerimetras {
    static final double PI = Math.PI;

    public static void main(String[] args) {
        ApskritimoPerimetras apskritimoPerimetras = new ApskritimoPerimetras();
        float perimetras = apskritimoPerimetras.perimetras(10f);
        System.out.println(perimetras);
    }

    private float perimetras(float r) {
        return 2 * (float)PI * r;
    }
}
