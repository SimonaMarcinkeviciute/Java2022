package lt.codeacademy.lessons.twentyEigth.exceptions.nullas.task4;

public class Main {
    public static void main(String[] args) {

        Address address = new Address("Lazdyneliu g", new City("Vilnius"));

        Address address1 = new Address(null, new City("Kaunas"));

        System.out.println(getCityName(address));
        System.out.println(getCityName(address1));

    }

    private static String getCityName(Address address) {

        if (address.getName() == null) {
            return "Tokio miesto nepavyko rasti";
        }

        return address.getName();
    }
}
