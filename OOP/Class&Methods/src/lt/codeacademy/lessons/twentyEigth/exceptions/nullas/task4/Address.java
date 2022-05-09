package lt.codeacademy.lessons.twentyEigth.exceptions.nullas.task4;

public class Address extends City {
    private final City city;

    public Address(String name, City city) {
        super(name);
        this.city = city;
    }

    public City getCity() {
        return city;
    }
}
