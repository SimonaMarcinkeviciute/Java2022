
package lt.codeacademy.controller;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.entity.Invoice;
import lt.codeacademy.service.EmployerService;
import lt.codeacademy.service.InvoiceService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserInterfaceController {
    private final Scanner scanner;
    private final EmployerService employerService;
    private final InvoiceService invoiceService;

    public UserInterfaceController() {
        scanner = new Scanner(System.in);
        employerService = new EmployerService();
        invoiceService = new InvoiceService();
    }

    public void startApplication() {
        String action;
        do {
            showMenu();
            action = scanner.nextLine();
            selectAction(action);
        }while(!action.equals("9"));
    }

    private void showMenu(){
        System.out.println("""
           1. Create employer
           2. Create invoice
           3. Delete invoice
           4. Delete employer
           5. Update employer salary
           9. Exit
								   """);
    }

    private void selectAction(String action){
        switch(action){
            case "1" -> createEmployer();
            case "2" -> createInvoice();
            case "3" -> deleteInvoice();
            case "4" -> deleteEmployer();
            case "5" -> updateEmployerSalary();
            case "9" -> System.out.println("System turning of");
            default -> System.out.println("action does not exist");
        }
    }


    private void updateEmployerSalary() {
        List<Employer> employers = employerService.getEmployers();
        for(Employer employer: employers) {
            System.out.printf("Id: %s Darbuotojas %s %s atlyginimas %s\n"
                    ,employer.getId(), employer.getName(), employer.getSurname(), employer.getSalary());
        }

        System.out.println("Pasirinkite darbuotoja pagal id, kurio atlyginima noresite atnaujinti");
        Employer employer = getEmployer(employers);
        System.out.println("Iveskite nauja atlyginima");
        BigDecimal salary = scanner.nextBigDecimal();
        employer.setSalary(salary);
        employerService.UpdateEmployerSalary(employer);
    }

    private void deleteEmployer() {
        List<Employer> employers = employerService.getEmployers();
        for(Employer employer: employers) {
            System.out.printf("Id: %s Darbuotojas %s %s \n"
                    ,employer.getId(), employer.getName(), employer.getSurname());
        }

        System.out.println("Pasirinkite darbuotoja pagal id, kuri norite istrinti");
        Employer employer = getEmployer(employers);
        employerService.deleteEmployer(employer);
        Set<Invoice> invoices = employer.getInvoices();
        for (Invoice invoice : invoices) {
            invoiceService.deleteInvoice(invoice);
        }
    }

    private void deleteInvoice() {
        List<Invoice> invoices = invoiceService.getInvoice();
        for(Invoice invoice: invoices) {
            System.out.printf("Darbuotojas %s %s. Saskaitos fakturos id %s. sukurtas: %s ismoketas atlyginimas: %s\n"
                    ,invoice.getEmployer().getName(), invoice.getEmployer().getSurname(), invoice.getId(), invoice.getDate(), invoice.getSalary());
        }

        System.out.println("Pasirinkite saskaitos fakturos, kuria norite istrinti, pagal id, ");
        Invoice invoice = getInvoice(invoices);
        invoiceService.deleteInvoice(invoice);
    }

    private Invoice getInvoice(List<Invoice> invoices) {
        Invoice invoice;
        do {
            Long invoiceId = getCorrectNumber();
            invoice = invoices.stream().filter(e -> e.getId().equals(invoiceId)).findFirst().orElse(null);
            if(invoice == null) {
                System.out.println("Invoice does not exist, please insert existing employer id");
            }
        } while(invoice == null);

        return invoice;
    }

    private void createEmployer() {
        System.out.println("Insert name");
        String name = scanner.nextLine();
        System.out.println("Insert surname");
        String surname = scanner.nextLine();
        System.out.println("Insert phone");
        String phone = scanner.nextLine();
        System.out.println("Insert email");
        String email = scanner.nextLine();
        System.out.println("Insert salary");
        BigDecimal salary = new BigDecimal(scanner.nextLine());

        Employer employer = new Employer(name, surname, phone, email, salary);
        employerService.createEmployer(employer);
    }

    public void createInvoice() {
        List<Employer> employers = employerService.getEmployers();
        for(Employer employer: employers) {
            System.out.printf("%s. %s %s\n", employer.getId(), employer.getName(), employer.getSurname());
        }

        System.out.println("Select employer");
        Employer employer = getEmployer(employers);
        System.out.println("Insert salary");
        BigDecimal salary = new BigDecimal(scanner.nextLine());
        System.out.println("Insert payed cash [YES/NO]?");
        boolean isPayedCashed = "yes".equalsIgnoreCase(scanner.nextLine());

        Invoice invoice = new Invoice(LocalDateTime.now(), salary, isPayedCashed);
        invoice.setEmployer(employer);

        invoiceService.createInvoice(invoice);
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

    private Long getCorrectNumber() {
        while(true) {
            try {
                return Long.valueOf(scanner.nextLine());
            }catch(Exception e) {
                System.out.println("Incorrect number, please try again");
            }
        }
    }
}
