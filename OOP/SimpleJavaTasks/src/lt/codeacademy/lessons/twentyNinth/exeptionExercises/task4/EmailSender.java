package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task4;

import java.util.List;

public class EmailSender {
    public void sendEmail(List<Email> emails) {
        NetworkConnector networkConnector = new NetworkConnector();

        for (Email email : emails) {
            if (email.getBusena().equals(Busena.NAUJAS)) {
                try {
                    System.out.printf("Laiskas siunciamas %s, el.pastas  %s\n", email.getGavejas(), email.getAdresas());
                    networkConnector.send(email);
                } catch (NoNetwirkExeption e) {
                    System.out.println(e.getMessage());
                }finally {
                    System.out.printf("Laisko adresu %s busena - %s\n", email.getAdresas(), email.getBusena());
                }
            }
            while (email.getBusena().equals(Busena.KARTOJAMAS_SIUNTIMAS)) {
                try {
                    System.out.printf("Laiskas adresu %s, siunciamas pakartotinai po 3 sekundziu\n", email.getAdresas());
                    Thread.sleep(3000);
                    networkConnector.send(email);
                } catch (NoNetwirkExeption | InterruptedException ignored) {
                } finally {
                    System.out.printf("Laisko adresu %s busena - %s\n", email.getAdresas(), email.getBusena());
                }
            }
        }
    }
}
