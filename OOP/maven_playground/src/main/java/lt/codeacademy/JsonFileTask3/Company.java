package lt.codeacademy.JsonFileTask3;

import java.io.Serializable;

public class Company implements Serializable {

    private String name;
    private final String code;
    private int numberOfEmployees;
    private int averageWage;

    public Company(String name, String code, int numberOfEmployees, int averageWage) {
        this.name = name;
        this.code = code;
        this.numberOfEmployees = numberOfEmployees;
        this.averageWage = averageWage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

    public double getAverageWage() {
        return averageWage;
    }

    public void setAverageWage(double averageWage) {
        this.averageWage = averageWage;
    }
}
