package lt.codeacademy.lessons.seventh.salygos;


public class Task4 {

    public  void actionsWithNumbs(int num1, String text2, int num2) {

        switch (text2) {
            case "+" -> addition(num1, num2);
            case "-" -> subtraction(num1, num2);
            case "*" -> multiplication(num1, num2);
            case "/" -> isNotZero(num1, num2);
            case "^" -> exponentiation(num1, num2);
            default -> wrongInput();
        }

    }

    private void addition(int numb1, int numb2) {
        int sum = numb1 + numb2;
        System.out.println("Sudetis: " + sum);
    }

    private void subtraction(int numb1, int numb2) {
        int sum = numb1 - numb2;
        System.out.println("Atimtis: " + sum);
    }

    private void multiplication(int numb1, int numb2) {
        int sum = numb1 * numb2;
        System.out.println("Daugyba: " + sum);
    }

    private void division(int numb1, int numb2) {
        int sum = numb1 / numb2;
        System.out.println("Dalyba: " + sum);
    }

    private void exponentiation(int numb1, int numb2) {
        // Math.pow(numb1, numb2)
        int sum = numb1 ^ numb2;
        System.out.println("Kelimas kvadratu: " + sum);
    }

    public void isNotZero(int num1, int num2) {

        if (num1 != 0 && num2 != 0) {
            division(num1, num2);
        } else wrongInput();

    }

    public void wrongInput() {

        Task4Main task4Main = new Task4Main();

        System.out.println("Bloga ivestis, pakartokite salyga: ");
        task4Main.scr();
    }


}
