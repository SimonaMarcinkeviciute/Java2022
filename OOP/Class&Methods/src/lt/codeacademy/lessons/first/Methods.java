package lt.codeacademy.lessons.first;

public class Methods {



    static void pirmas(){
        System.out.println("Pirmas metodas");


    }

    public static void pirmas(int number) {
        System.out.println("Pirmas public static metodas su vienu int parametru" + number);
        //kvieciamas Pirmas private static metodas su vienu String parametru, is statinio i statini metoda,
        //nereikia kurtis objekto. taip pat nereiketu ir is nestatinio statini issikviesti.
        pirmas("Pirmas private static metodas su vienu String parametru");


    }
    //private static metoda galima iskviesti tik toje pacioje klaseje
    private static void pirmas(String text){
        System.out.println(text);



    }
    // protected issikviecia kitoje klases,  nereikia objekto.kam tiksliai naudojama kol kas nezinau
    protected static void pirmas(String text, int number){
        System.out.println(text + number);


    }

    static int antras() {

        return 2;


    }
//  norint issikviesti ne statinius metodus, statiniame metode, net it is tos pacios kllases, reikia susikurti objekta
    // taciau kvieciant metoda ir nestatinio i nestatini, objekto nereikia
    void trecias() {
        System.out.println("Trecias metodas");
        //kvieciamas trecias metodas su int parametru
        trecias(5);

    }

    public void trecias(int number) {
        System.out.println("Trecias public void metodas su vienu int parametru" + number);

    }
    //private galima iskviesti tik toje pacioje klaseje
    private void trecias(String text){
        System.out.println(text);

    }
    protected void trecias(String text, int number){

    }

    int ketvirtas(){
        return 4;
    }


}
