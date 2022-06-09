package lt.codeacademy.service;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.repository.EmployerRepository;

import java.math.BigDecimal;
import java.util.List;

public class EmployerServise {
//kostruktoriuje reiketu kurti si objekta
    EmployerRepository employerRepository = new EmployerRepository();

    public void showAllEmployersByIdAndName() {
        List<Employer> employers = employerRepository.getEmployers();
        for (Employer employer : employers) {
            System.out.printf("%s %s ID: %s \n", employer.getName(), employer.getSurname(), employer.getId());
        }
           }

    public void createEmployer(String name, String surname, String phoneNumber, String email, BigDecimal salary) {
        Employer employer = new Employer(null, name, surname, phoneNumber, email, salary);
        employerRepository.createEmployer(employer);
    }


}
