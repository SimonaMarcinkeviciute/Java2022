package lt.codeacademy.lessons.twentyFourth.inheretance.PersonStrudent.twentySecond;

public class TestEvaluatuanNext {

    public static void main(String[] args) {


    }

    private int count(String key, String value, String answer) {

        int trueAnswer = 0;

        String modifiedKey = key.replaceAll("[^0-9]", " ");
        int actionIndex = modifiedKey.indexOf(" ");
        char action = key.charAt(actionIndex);
        String[] conditionNumbers = modifiedKey.split(" ");

        switch (action) {
            case '+' -> trueAnswer = Integer.parseInt(conditionNumbers[0]) + Integer.parseInt(conditionNumbers[1]);

            case '-' -> trueAnswer = Integer.parseInt(conditionNumbers[0]) - Integer.parseInt(conditionNumbers[1]);
            case '*' -> trueAnswer = Integer.parseInt(conditionNumbers[0]) * Integer.parseInt(conditionNumbers[1]);
            case '/' -> trueAnswer = Integer.parseInt(conditionNumbers[0]) / Integer.parseInt(conditionNumbers[1]);
        }

        return trueAnswer;


    }

}
