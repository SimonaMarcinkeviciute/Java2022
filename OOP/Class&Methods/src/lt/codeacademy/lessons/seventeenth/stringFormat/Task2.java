package lt.codeacademy.lessons.seventeenth.stringFormat;

public class Task2 {
    public static void main(String[] args) {


        String anotherText = String.format("|%20s|\n|%20s|\n|%20s|\n|%20s|\n|%-20s|", "As","tikrai",
                "ismoksiu", "programuoti", "Java");

        System.out.println(anotherText);
    }
}
