package lt.codeacademy.faker;

import org.apache.commons.codec.digest.DigestUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CommonsCodec {
    Scanner scanner = new Scanner(System.in);
    private final Map<String, String> logIns = new HashMap<>();

    public static void main(String[] args) {
        CommonsCodec codec = new CommonsCodec();
        codec.selectAction();
    }

    private void menu() {
        System.out.println("""
                [1] registruotis
                [2] prisijungti
                [3] baigti programa
                """);
    }

    private void selectAction() {
        String action = "";

        while (!action.equals("3")) {
            menu();
            System.out.println("Pasirinkite veiksma");
            action = scanner.nextLine();
            switch (action){
                case "1" -> logIn();
                case "2" -> signIn();
                default -> System.out.println("Tokio pasirinkimo nera");
            }
        }
    }

    private void logIn () {
        System.out.println("Iveskite vartotojo varda: ");
        String name = scanner.nextLine();
        System.out.println("Iveskite slaptazodi: ");
        String password = scanner.nextLine();
        System.out.println("Pakartokita slaptazodi: ");
        String repeatPassword = scanner.nextLine();

        if(password.equals(repeatPassword)) {
            String codePassword = DigestUtils.sha256Hex(password);
            logIns.put(codePassword, name);
        } else {
            System.out.println("Slaptazodziai nesutampa, pakartokite: ");
            logIn();
        }
    }

    private void signIn() {
        System.out.println("Iveskite varda: ");
        String name = scanner.nextLine();
        System.out.println("Iveskite slaptazodi: ");
        String password = scanner.nextLine();

        String codePassword = DigestUtils.sha256Hex(password);

        if(logIns.containsKey(codePassword) && logIns.get(codePassword).equals(name)) {
            System.out.println("Toks vartotojas ezistuoja, prisijungete.");
        }else {
            System.out.println("Neteisingas slaptazodis arba vartotojo vardas.");
        }
    }
}
