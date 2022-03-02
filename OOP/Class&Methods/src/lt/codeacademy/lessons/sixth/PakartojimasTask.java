package lt.codeacademy.lessons.sixth;

import java.util.Objects;

public class PakartojimasTask {

    public void sum(int num1, String text2, int num2){

        if (Objects.equals(text2, "+")){
            System.out.println(num1 + num2);
        } else if (Objects.equals(text2, "-")){
            System.out.println(num1 - num2);
        }else if (Objects.equals(text2, "*")){
            System.out.println(num1 * num2);

        }else if(Objects.equals(text2, "/")) {
            System.out.println(num1 / num2);
        }else {
            System.out.println("Bloga ivestis");
        }





    }
}
