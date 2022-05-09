package lt.codeacademy.faker;

import com.github.pemistahl.lingua.api.*;

import java.util.Scanner;

import static com.github.pemistahl.lingua.api.Language.*;

public class MainLingua {
   private final LanguageDetector detector = LanguageDetectorBuilder.fromLanguages(ENGLISH, LITHUANIAN, SPANISH).build();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainLingua lingua = new MainLingua();

        lingua.printLanguage(scanner);
    }

    private void printLanguage(Scanner scanner) {
        while (true) {
            System.out.println("Iveskite sakini: ");
            String text = scanner.nextLine();
            if(text.equals("exit")) {
                System.out.println("Programa baigta");
                break;
            }
            System.out.println("Jusu ivesto sakinio kalba: " + detector.detectLanguageOf(text));
        }
    }
}
