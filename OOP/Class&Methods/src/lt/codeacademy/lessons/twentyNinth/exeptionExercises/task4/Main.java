package lt.codeacademy.lessons.twentyNinth.exeptionExercises.task4;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        EmailSender emailSender = new EmailSender();

        List<Email> emails = new ArrayList<>();
        emails.add(new Email("aaa@aaa.lt", "subject1", Busena.NAUJAS));
        emails.add(new Email("bbb@bbb.lt", "subject2", Busena.NAUJAS));
        emails.add(new Email("ccc@ccc.lt", "subject3", Busena.NAUJAS));
        emails.add(new Email("ddd@ddd.lt", "subject4", Busena.NAUJAS));
        emails.add(new Email("eee@eee.lt", "subject5", Busena.NAUJAS));

        emailSender.sendEmail(emails);
    }
}
