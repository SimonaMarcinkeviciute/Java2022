package lt.codeacademy.manoPabandymai.ManoUnbounded;

public class ManoUnboundedMethodReference {
    public static void main(String[] args) {

        //kuriam nuoroda i klase TestoKlase, ir i jo metoda
        Trasformuosiu trasformuosiu = TestoKlase::testMetodas;
        System.out.println(trasformuosiu.testTranformacijosMetod("Labas"));

        //metodas kvieciamas per sukurta interfeisa
        TestoKlase testoKlase = new TestoKlase();
        System.out.println(trasformuosiu.tasformauosiu(testoKlase, "Labas"));

        //metodas kvieciamas per sukurta objekta
        System.out.println(testoKlase.testMetodas("Labas"));

        //referencas is sukurto, egzistuojancio objekto
            KitaTrasform kitaTrasform = testoKlase::testMetodas;
            //kvies testo klases metoda
        System.out.println(kitaTrasform.getValue("Kita reiksme"));

        //Statonio metodo
        KitaTrasform darkita = TestoKlase::testoDarviena;
        System.out.println(darkita.getValue("Labas"));


    }
}
