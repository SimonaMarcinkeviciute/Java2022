package lt.codeacademy;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.service.EmployerServise;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class UserControler {

    //reikia user controles kurti konstruktoriuje

    Scanner scanner = new Scanner(System.in);
    EmployerServise employerServise = new EmployerServise();

    private void menu() {
        System.out.println("""
                [1] Prideti nauja darbuotoja
                [2] Pasirinktam darbuotojui israsyti saskaita
                """);
    }

    public void selectAction() {
        System.out.println("Pasirinkite veiksma:");
        String action;
        do {
            menu();
            action = scanner.nextLine();
            switch (action) {
                case "1" -> addDataToEmployer();
                case "2" -> addDataToInvoice();
                case "3" -> System.out.println();
                case "4" -> System.out.println();
                case "5" -> System.out.println("Programa uzdaryta.");
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (!action.equals("5"));
    }

    private void addDataToEmployer() {
        System.out.println("Iveskite darbuotojo varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite darbuotojo pavarde");
        String surname = scanner.nextLine();
        System.out.println("Iveskite darbuotojo telefoto numeri");
        String phoneNumber = scanner.nextLine();
        System.out.println("Iveskite darbuotojo elektornini pasta");
        String email = scanner.nextLine();
        System.out.println("Iveskite darbuoto atlyginima");
        BigDecimal salary = scanner.nextBigDecimal();

        employerServise.createEmployer(name, surname, phoneNumber, email, salary);
    }

    private boolean isCach() {
        boolean isCach = false;
        String action;
        do {
            menu();
            action = scanner.nextLine();
            switch (action) {
                case "1" -> isCach = true;
                case "2" -> isCach = false;
                default -> System.out.println("Neteisingas ivedimas, bandykite dar karta:");
            }
        } while (action.equals("1") || action.equals("2"));

        return isCach;
    }

    private void addDataToInvoice() {
        List<Employer> employers = employerServise.g
        for(Employer employer: employers) {
            System.out.printf("%s. %s %s\n", employer.getId(), employer.getName(), employer.getSurname());
        }
        System.out.println("Select employer");
        Employer employer = getEmployer(employers);
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Kaip ismoketi pinigai: [1] Grynaisiais [2] Pavedimu");
        Boolean isCach = isCach();

        employerServise.createEmployer();
    }

    private Employer getEmployer(List<Employer> employers) {
        Employer employer;
        do {
            Long employerId = getCorrectNumber();
            employer = employers.stream().filter(e -> e.getId().equals(employerId)).findFirst().orElse(null);
            if(employer == null) {
                System.out.println("Employer does not exist, please insert existing employer id");
            }
        } while(employer == null);

        return employer;
    }
}
