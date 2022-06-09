package lt.codeacademy.service;

import lt.codeacademy.entity.Employer;
import lt.codeacademy.entity.Invoice;
import lt.codeacademy.repository.EmployerRepository;

import java.util.List;

public class EmployerService {
    private final EmployerRepository repository;

    public EmployerService() {
        repository = new EmployerRepository();
    }

    public void createEmployer(Employer employer) {
        repository.createEmployer(employer);
    }

    public List<Employer> getEmployers() {
        return repository.getEmployers();
    }



    public void UpdateEmployerSalary(Employer employer) {
        repository.updateEmployerSalary(employer);
    }


    public void deleteEmployer(Employer employer) {
        repository.deleteEmployer(employer);

    }
}
