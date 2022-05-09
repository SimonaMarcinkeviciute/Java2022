package lt.codeacademy.manoPabandymai.ManoUnbounded;

public interface Trasformuosiu {
    String tasformauosiu(TestoKlase testoKlase, String value);

    default String testTranformacijosMetod(String value) {
        return "testTransformacijosMetodas" + value;
    }
}
