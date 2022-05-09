package lt.codeacademy.lessons.twentyFourth.inheretance.PersonStrudent;

public class Person {
    // private kintamieji reikalauja get ir set metodu, protected kintamuosius galima butu pasiekti tiesiogiai
    private final String name;
    private final String surname;
    private final String personCode;

    public Person(String name, String surname, String personCode) {
        this.name = name;
        this.surname = surname;
        this.personCode = personCode;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPersonCode() {
        return personCode;
    }

    public String printInfo() {
        return String.format("Vardas: %s Pavarde: %s Person code: %s", name, surname, personCode);
    }
}
