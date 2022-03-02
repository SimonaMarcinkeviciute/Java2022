package lt.codeacademy.lessons.second;

public class TaskSecond {

    public static void main(String[] args) {
        spausdink("Simona", "Marcinkeviciute", "Java", 80);
    }

    public static void spausdink(String vardas, String pavarde, String kalba, int savaiciuSkaicius){
        System.out.println("As " + vardas + " " + pavarde + ", tikrai ismoksiu programuoti " +
                kalba + " kalba per " + savaiciuSkaicius + " savaites." );

    }
}
