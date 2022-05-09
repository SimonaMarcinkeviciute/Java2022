package lt.codeacademy.lessons.twentyFourth.inheretance.PersonStrudent;

import lt.codeacademy.lessons.twentyFourth.inheretance.PersonStrudent.Person;

public class Student extends Person {
    private final String university;

//tevines klases konstruktoriu kviciu super zodeliu
    public Student(String name, String surname, String personCode, String university) {
        super(name, surname, personCode);
        this.university = university;
    }

    public String getUniversity() {
        return university;
    }

    @Override
    public String getPersonCode() {
        //perrasem metoda gauti puse kodo
        //turi viskas atitikti, pavadinimas, perduoti parametrai
        // grazinimo tipas
        String code = super.getPersonCode();
        return code.substring(0, code.length() / 2);
    }

    @Override
    public String printInfo() {
        return String.format("Universitetas: %s", university);

    }
}
