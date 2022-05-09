package lt.codeacademy.lessons.thirthySecond.files.task1;

import java.io.*;
import java.util.*;

public class Main {
    private static final String PERSON_FILE_NAME = "people.txt";
    private static final String PAYMENT_FILE_NAME = "payment.txt";
    private static final String SORTED_PERSON_FILE_NAME_RECEIVED = "sorted_peopl_receivede.txt";
    private static final String SORTED_PERSON_FILE_NAME_SENT = "sorted_people_sent.txt";
    private static final String ID = "id";
    private static final String REGEX = ",";


    private final Map<Integer, Person> persons = new HashMap<>();
    private final List<Payment> payments = new ArrayList<>();

    public static void main(String[] args) {
        Main task = new Main();
        task.fillPersonsData();
        task.readPayments();

        task.writeSortedPersonsByTeceivedMoney();
        task.menu();
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                a. Atvaizduoti vartotoja kuris padare daugiausiai pervedimu ir kiek ju padare.
                b.Atvaizduoti vartotoja kuris gavo daugiausiai pervedimu ir kiek ju gavo.
                c.Atvaizduoti didziausia pervedima.
                d.Atvaizduoti maziausia pervedima
                """);
        System.out.println("Pasirinkite ka norite atlikti");
        String action = scanner.nextLine();

        switch (action) {
            case "a" -> showMostSentMoneyPerson();
            case "b" -> showMostReceivedMoneyPerson();
            case "c" -> showMaxPayment();
            case "d" -> showMinPayment();
            default -> System.out.println("Tokio veiksmo nera");
        }

    }

    private void showMostSentMoneyPerson() {
        Person person = null;
        for (Person p : persons.values()) {
            if (person == null || person.getCountSentMoney() < p.getCountSentMoney()) {
                person = p;
            }
        }
        System.out.printf("%s %s padare pervedimu %s", person.getName(), person.getSurname(), person.getCountSentMoney());
    }

    private void showMostReceivedMoneyPerson() {
        List<Person> sortedPersons = new ArrayList<>(persons.values());
        sortedPersons.sort(Person.SORT_BY_RECEIVED_MONEY_COUNT);

        Person person = sortedPersons.get(0);

        System.out.printf("%s %s gavo pavedimu: %s\n", person.getName(), person.getSurname(), person.getCountReceiveMoney());
    }

    private void readPayments() {
        try (BufferedReader br = new BufferedReader(new FileReader(PAYMENT_FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(ID)) {
                    continue;
                }

                String[] splits = line.split(REGEX);
                if (splits.length < 4) {
                    continue;
                }
                Payment payment = new Payment(
                        Integer.parseInt(splits[0].trim()),
                        Integer.parseInt(splits[1].trim()),
                        Integer.parseInt(splits[2].trim()),
                        Integer.parseInt(splits[3].trim())
                );
                payments.add(payment);

                countReceiverMoney(payment);
                countSenderMoney(payment);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void fillPersonsData() {
        try (BufferedReader br = new BufferedReader(new FileReader(PERSON_FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(ID)) {
                    continue;
                }

                String[] splits = line.split(REGEX);
                if (splits.length < 3) {
                    continue;
                }

                int id = Integer.parseInt(splits[0]);
                persons.put(id, new Person(id, splits[1].trim(), splits[2].trim()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void countReceiverMoney(Payment payment) {
        Person person = persons.get(payment.receverId());
        if (person != null) {
            person.setReceivedMoney(person.getReceivedMoney());
        }
    }

    private void countSenderMoney(Payment payment) {
        Person person = persons.get(payment.senderId());
        if (person != null) {
            person.setSentMoney(person.getSentMoney() +payment.sum());

        }
    }

    private void writeSortedPersonsByTeceivedMoney() {
        //sudeti Map i lista
        List<Map.Entry<Integer, Person>> sortedPersons = new ArrayList<>(persons.entrySet());
        sortedPersons.sort(Person.SORT_BY_RECEIVED_MONEY);
// irasem objekta per buffer writter surikiuotus duomenis is list
        writePersonsToFile(sortedPersons, SORTED_PERSON_FILE_NAME_RECEIVED);

    }

    private void writeSortedPersonsBySentMoney() {
        //galima perkelti reiksmes , kai nereikia key is tokiu budu
        // List<Person> people = new ArrayList<>(persons.entrySet());
        //perkelimas Map i Lista
        List<Map.Entry<Integer, Person>> sortedPersons = new ArrayList<>(persons.entrySet());
        sortedPersons.sort(Person.SORT_BY_SENT_MONEY);

        writePersonsToFile(sortedPersons, SORTED_PERSON_FILE_NAME_SENT);
    }

    private void writePersonsToFile(List<Map.Entry<Integer, Person>> sortedPersons, String fileName) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(SORTED_PERSON_FILE_NAME_RECEIVED))) {
            for (Map.Entry<Integer, Person> entry : sortedPersons) {
                bw.write(entry.getValue().toString());
                bw.newLine();
            }
            //reikalingas pries close
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showMaxPayment() {
        Payment payment = null;
        for(Payment p : payments) {
            if(payment == null || payment.sum() < p.sum()) {
                payment = p;
            }
        }


       Person receiverPerson =  persons.get(payment.receverId());
        Person senderPerson = persons.get(payment.senderId());

        if(receiverPerson == null || senderPerson == null) {
            return;
        }

        System.out.printf("Siuntejas: %s %s, suma: %s, gavejas %s %s", senderPerson.getName(), senderPerson.getSurname(), payment.sum(), receiverPerson.getName(), receiverPerson.getSurname());
    }

    private void showMinPayment() {
        Payment payment = null;
        for(Payment p : payments) {
            if(payment == null || payment.sum() > p.sum()) {
                payment = p;
            }
        }


        Person receiverPerson =  persons.get(payment.receverId());
        Person senderPerson = persons.get(payment.senderId());

        if(receiverPerson == null || senderPerson == null) {
            return;
        }

        System.out.printf("Siuntejas: %s %s, suma: %s, gavejas %s %s", senderPerson.getName(), senderPerson.getSurname(), payment.sum(), receiverPerson.getName(), receiverPerson.getSurname());

    }


}
