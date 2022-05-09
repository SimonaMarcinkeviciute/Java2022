package lt.codeacademy.lessons.fiftheen.staticFinal;

public class StaticTestFinal {
    static final int numbOne = 6;
    static int numbTwo;



    void priskirk(int numbOne, int numbTwo) {
        // galima pasiekti static kintamuosius ir pagal klasesvarda
        // kai kintamasis staic final neina priskirti, kai static final reikia is karto prideklaruoti
        //this.numbOne = numbOne;
        this.numbTwo = numbTwo;
        System.out.println(numbOne);
        System.out.println(numbTwo);
    }
}
