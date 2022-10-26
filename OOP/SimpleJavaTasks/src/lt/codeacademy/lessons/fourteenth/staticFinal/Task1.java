package lt.codeacademy.lessons.fourteenth.staticFinal;

public class Task1 {
    int neStatic;

    public void setValue(int i) {
        System.out.println(i);
        neStatic = i;
    }

    public static void staticMethod(int j) {
        System.out.println(j);
        //priskirti statiniame metode nestatinio kintamojo be
        //objekto negalima
        //neStatic = j;
    }
}
