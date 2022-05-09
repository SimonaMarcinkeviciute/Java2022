package lt.codeacademy;

import lt.codeacademy.data.*;


import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Budget budget = new Budget();
        Scanner scanner = new Scanner(System.in);

        Main main = new Main();

        String action;
        do {
            main.menu();
            action = scanner.nextLine();
            main.selectAction(action, budget, scanner);
        } while (!action.equals("5"));
    }

    private void selectAction(String action, Budget budget, Scanner scanner) {
        switch (action) {
            case "1" -> createCost(scanner, budget);
            case "2" -> createIncome(scanner, budget);
            case "3" -> getCost(scanner, budget);
            case "4" -> getIncome(scanner, budget);
            case "5" -> System.out.println("Programa baige darba");
            case "6" -> System.out.printf("Jusu balansas yra %.2f\n", budget.balansas());
            case "7" -> showCosts(budget);
            case "8" -> showIncomes(budget);
            case "9" -> removeCost(scanner, budget);
            case "10" -> removeIncome(scanner, budget);
            case "11" -> updateIncome(scanner, budget);
            default -> System.out.println("Tokio veiksmo nera");
        }
    }

    private void updateIncome(Scanner scanner, Budget budget) {
        System.out.println("Iveskite id kurias pajamas norite atnaujinti");
        int id = Integer.parseInt(scanner.nextLine());
        Income income = budget.findIncome(id);

        if (income == null) {
            System.out.printf("Pajamu pagal id:%s nerasta, patikrinkite id\n", id);
            return;
        }

        String newSum = getNewValue("Suma %.2f eu", income.getSum().doubleValue(), scanner);
        income.setSum(newSum != null ? new BigDecimal(newSum) : income.getSum());
        String newName = getNewValue("Person name %s", income.getPerson().getName(), scanner);
        income.getPerson().setName(newName != null ? newName : income.getPerson().getName());
    }

    private String getNewValue(String template, Object object, Scanner scanner) {
        System.out.printf(template + "\n", object);
        System.out.println("1 - redaguoti, 2 - toliau");
        String action = scanner.nextLine();

        if (action.equals("1")) {
            System.out.println("Iveskite nauja reiksme:");
            return scanner.nextLine();
        }

        return null;
    }

    private void getIncome(Scanner scanner, Budget budget) {
        System.out.println("Iveskite pajamu kategorija is: " + Arrays.toString(IncomeCategory.values()));
        String text = scanner.nextLine();
        IncomeCategory category = IncomeCategory.valueOf(text);

        System.out.println("Iveskite data, pvz: 2022.02.21");
        String date = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        Income income = budget.getIncome(category, localDate);
        System.out.println(income);
    }

    private void menu() {
        System.out.println("""
                    1. Ivesti islaidas
                    2. Ivesti pajamas
                    3. Gauti Islaidas
                    4. Gauti pajamas
                    5. Pabaiga
                    6. Balansas
                    7. Visos islaidos
                    8. Visos pajamos
                    9. Istrinti islaidas
                    10. Istrinti Pajamas
                    11. Atnaujinti pajamas
                """);
    }

    private void createCost(Scanner scanner, Budget budget) {
        //TODO at home: papildyti daugiau ivedimo is vartotojo

        System.out.println("Iveskite islaidu suma");
        String sum = scanner.nextLine();
        budget.addEntry(new Cost(new BigDecimal(sum), LocalDateTime.now(), TransferStatus.DONE, CostType.CASH, CostCategory.FOOD));
    }

    private void createIncome(Scanner scanner, Budget budget) {

        //TODO at home: papildyti daugiau ivedimo is vartotojo
        System.out.println("Iveskite pajamu suma");
        String value = scanner.nextLine();
        budget.addEntry(new Income(new BigDecimal(value), LocalDate.now(),
                new Person("Andrius", "Baltrunas"), TransferStatus.DONE, true, IncomeCategory.SALARY));
    }

    private void getCost(Scanner scanner, Budget budget) {
        System.out.printf("Iveskite Islaidu kategorija: %s\n", Arrays.toString(CostCategory.values()));
        String category = scanner.nextLine();

        System.out.println("Iveskite data 2022:03:17");
        String date = scanner.nextLine();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:MM:dd");
        LocalDate localDate = LocalDate.parse(date, formatter);

        Cost cost = budget.getCost(CostCategory.valueOf(category), localDate);
        System.out.println(cost);
    }

    private void showIncomes(Budget budget) {
        for (Income income : budget.getIncomes()) {
            System.out.println(income);
        }
    }

    private void showCosts(Budget budget) {
        for (Cost cost : budget.getCosts()) {
            System.out.println(cost);
        }
    }

    private void removeIncome(Scanner scanner, Budget budget) {
        System.out.println("Iveskite indexa kuri norite istrinti");
        int index = Integer.parseInt(scanner.nextLine());

        budget.removeIncome(index);
    }

    private void removeCost(Scanner scanner, Budget budget) {
        System.out.println("Iveskite indexa islaidu kurias istrinti?");
        int index = Integer.parseInt(scanner.nextLine());

        budget.removeCost(index);
    }
}
