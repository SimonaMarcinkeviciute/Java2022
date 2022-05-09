package lt.codeacademy.lessons.sixteen.Equels;

public class Task2 {
    public static void main(String[] args) {
        Task2 asmuo = new Task2();
        Task2 tankas = new Task2();


        System.out.println(asmuo==tankas);
        System.out.println(asmuo.equals(tankas));

        asmuo = tankas;

        System.out.println(asmuo==tankas);
        System.out.println(asmuo.equals(tankas));


    }
}
