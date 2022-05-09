package lt.codeacademy.lessons.sixteen.Equels;

public class Task1 {


    public static void main(String[] args) {
        String text1 = "Zodis";
        String text2 = "Zodis";

        System.out.println(text1.equals(text2));
        System.out.println(text1 == text2);


        String text3 = new String("Zodis");
        String text4 = new String("Zodis");
        text4 = text3;

        System.out.println(text3.equals(text4));
        System.out.println(text3 == text4);

        String text5 = "Zodis";
        String text6 = "Kitas zodis";
        text5 = text6;

        System.out.println(text5.equals(text6));
        System.out.println(text5 == text6);





    }


}
