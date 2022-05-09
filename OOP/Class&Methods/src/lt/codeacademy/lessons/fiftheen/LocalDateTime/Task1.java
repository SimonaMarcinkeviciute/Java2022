package lt.codeacademy.lessons.fiftheen.LocalDateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Task1 {
    public static void main(String[] args) {
        LocalDateTime laikasDabar = LocalDateTime.now();
        LocalDateTime naujasLaikas = laikasDabar.minusHours(3);
        LocalDateTime darNaujesnisLaikas = naujasLaikas.plusDays(5);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy MM dd HH:mm");
        String formatuotaData = darNaujesnisLaikas.format(dateTimeFormatter);
        System.out.println(formatuotaData);

    }

}
