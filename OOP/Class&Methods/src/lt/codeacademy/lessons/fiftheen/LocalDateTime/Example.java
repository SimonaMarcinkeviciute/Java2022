package lt.codeacademy.lessons.fiftheen.LocalDateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Example {
    public static void main(String[] args) {
        // atspausdinti laika dabar
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        //gauti menesio diena
        System.out.println(localDateTime.getDayOfMonth());
        // gauti valandas
        System.out.println(localDateTime.getHour());
        //gauti menesi zodziai atspausdina
        System.out.println(localDateTime.getMonth());
        // atspausdoina suformatuota data
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
        // galima prideti dienu prie esamo laiko
        LocalDateTime naujasLaikas = localDateTime.plusDays(6);
        System.out.println(naujasLaikas);

        // DateTime formatavimas
        LocalDate siandien = LocalDate.now();
        // siandienos data
        System.out.println(siandien);
        // formatuojama data
        String formatuotaSiandien = siandien.format(DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(formatuotaSiandien);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy!!MM!!dd");
        formatuotaSiandien  = siandien.format(formatter);
        System.out.println(formatuotaSiandien);
    }
}
