package lt.codeacademy.lessons.fourteenth.staticFinal;

public class Task1Mani {


    public static void main(String[] args) {
        //statini metoda is statinio be objekto
        //ne statiniai metodai prie statiniuu kintamuju prieina
        Task1.staticMethod(10);

        Task1 task1 = new Task1();
        task1.setValue(10);

    }

}
