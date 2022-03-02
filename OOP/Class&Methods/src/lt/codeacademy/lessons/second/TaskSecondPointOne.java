package lt.codeacademy.lessons.second;

public class TaskSecondPointOne {
    public static void main(String[] args) {
        spausdink("Simona", "Marcinkeviciute", "Java", 80);
        spausdink("Petras", "Petraitis", "Java");
    }

    public static void spausdink(String vardas, String pavarde, String kalba, int savaiciuSkaicius){
        System.out.println("As " + vardas + " " + pavarde + ", tikrai ismoksiu programuoti " +
                kalba + " kalba per " + savaiciuSkaicius + " savaites." );

    }

    public static void spausdink(String vardas, String pavarde, String kalba) {
        System.out.println("As " + vardas + " " + pavarde + ", tikrai ismoksiu programuoti " +
                kalba + " kalba.");
    }
}
