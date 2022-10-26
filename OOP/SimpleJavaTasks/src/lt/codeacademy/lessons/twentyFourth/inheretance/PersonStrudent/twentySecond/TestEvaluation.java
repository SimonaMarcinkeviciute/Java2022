package lt.codeacademy.lessons.twentyFourth.inheretance.PersonStrudent.twentySecond;

//        Dėstytojas prašo Jūsų pagalbos sukurti testų sistema jo studentų įvertinimui. Kiekvienas
//        studentas turės paleidęs sistema gauti 10 klausimų su atsakymais. Atsakius į klausimą jam bus
//        rodomas kitas klausimas ir t.t. Kai testas baigtas parodomas studento pažymys ir komentaras.
//        Klausimai nuskaitomi iš (failo arba atminties) kuriame turi būti bent 15 su atsakymais variantų.
//        Jei studentas įveda blogą formatą sistema prašo pakartoti įvedimą tol kol bus įvestas geras
//        formatas.

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestEvaluation {
    private static final String QUESTIONS = "Kiek bus 2+2:a.6 b.7 c.4:c.4;Kiek bus 3*6:a.15 b.18 c.5:b.18;" +
            "Kiek bus 4-2:a.1 b.6 c.2 d.-3:c.2;Lietuvos sostine:a.Vilnius b.Kaunas c.Klaipeda:a.Vilnius;" +
            "Ilgiausia lietuvos upe:a.Neris b.Nemunas c.Sventoji:b.Nemunas;Kiek bus 3*2:a.6 b.8 c.10 d.2:a.6;" +
            "Didziausias lietuvos ezeras:a.Dusia b.Sartai c.Druksiai d.Metelys:c.Druksiai;Kiek bus 2+6:a.1 b.9 c.8:c:8;" +
            "Kiek bus 7*2:a.2 b.6 c.14:c.14;Kiek bus 6+7:a.13 b.11:a.13;Kiek bus 1+1:a.1 b.2 c.4:b.2;Kiek bus 5+2:a.7 " +
            "b.8:a.7;Kiek bus 4/2:a.1 b.6 c.4 d.2:d.2;Kiek bus 10-10:a.0 b.1:a.0;Giliausias Lietuvis ezeras:a.Malkestaitis " +
            "b.Tauraknas c.Gavys:b.Tauragnas";
    final Map<String, String> conditions = new HashMap<>();
    final Map<String, String> trueAnswers = new HashMap<>();

    public static void main(String[] args) {
        TestEvaluation test = new TestEvaluation();
        Scanner scanner = new Scanner(System.in);

        test.fillCodeToMap();
        test.testPoints(scanner);

    }

    private void testPoints(Scanner scanner) {
        int point = 0;

        for (String key : conditions.keySet()) {
            System.out.printf("%s, %s\n", key, conditions.get(key));
            String answer = Input(conditions.get(key), scanner);
            boolean correctAnswer = isCorrectAnswer(key, answer);

            if (correctAnswer) {
                point++;
            }
        }

        System.out.printf("Atsakete tesingu klausimu %s/15", point);
    }

    private String Input(String answers, Scanner scanner) {
        String[] separateAnswers = answers.split(" ");
        boolean isCorrect = false;
        String answer = "";

        System.out.println("Iveskite atsakyma: ");

        while (!isCorrect) {
            answer = scanner.next();

            for (int i = 0; i < separateAnswers.length - 1; i++) {
                if (separateAnswers[i].charAt(0) == answer.charAt(0)) {
                    isCorrect = true;
                    break;
                }
            }

            if (!isCorrect) {
                System.out.println("Neteisinga ivestis, pakartokite");
            }
        }

        return answer;
    }

    private void fillCodeToMap() {
        String[] codes = QUESTIONS.split(";");

        for (String code : codes) {
            String[] splitPair = code.split(":");
            conditions.put(splitPair[0], splitPair[1]);
            trueAnswers.put(splitPair[0], splitPair[2]);
        }
    }

    private boolean isCorrectAnswer(String key, String answer) {
        boolean correctAnswer = false;

        for (String k : trueAnswers.keySet()) {
            if (k.equals(key) && trueAnswers.get(k).charAt(0) == answer.charAt(0)) {
                correctAnswer = true;
            }
        }

        return correctAnswer;
    }


}
