package lt.codeacademy.data;

import org.bson.types.ObjectId;

/*public record Employer(ObjectId id, String name, String surname, String job, Double salary, String description) {
}*/

public class Employer {
    private ObjectId id;
    private String name;
    private String surname;
    private String job;
    private Double salary;
    private String description;

    public Employer(ObjectId id, String name, String surname, String job, Double salary, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.salary = salary;
        this.description = description;
    }

    public Employer() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}