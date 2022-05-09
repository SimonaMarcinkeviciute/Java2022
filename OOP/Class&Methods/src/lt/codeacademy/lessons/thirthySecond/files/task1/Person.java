package lt.codeacademy.lessons.thirthySecond.files.task1;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.Map;

public class Person {
    private final int id;
    private final String name;
    private final String surname;
    private int receivedMoney;
    private int sentMoney;
    private int countSentMoney;
    private int countReceiveMoney;

    public Person(int id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        receivedMoney = 0;
        sentMoney = 0;
        countSentMoney = 0;
        countReceiveMoney = 0;
    }

    public int getId() {
        return id;
    }

    public int getCountSentMoney() {
        return countSentMoney;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getReceivedMoney() {
        return receivedMoney;
    }

    public void setReceivedMoney(int receivedMoney) {
        countReceiveMoney ++;
        this.receivedMoney = receivedMoney;
    }

    public int getSentMoney() {
        return sentMoney;
    }

    public void setSentMoney(int sentMoney) {
        countSentMoney ++;
        this.sentMoney = sentMoney;
    }

    public int getCountReceiveMoney() {
        return countReceiveMoney;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", receivedMoney=" + receivedMoney +
                ", sentMoney=" + sentMoney +
                '}';
    }

    public static final Comparator<Map.Entry<Integer, Person>> SORT_BY_SENT_MONEY = (o1, o2) ->  {
        return Integer.compare(o1.getValue().getSentMoney(), o2.getValue().getSentMoney());
    };

    //issisortinti nuo didziausio link maziausio. funkcija
    public static final Comparator<Map.Entry<Integer, Person>> SORT_BY_RECEIVED_MONEY = (o1, o2) -> {
        int money1 = o1.getValue().getReceivedMoney();
        int money2 = o2.getValue().getReceivedMoney();
//apsukus surikiuotu atvirksciai
        return Integer.compare(money1, money2);
    };

    public static final Comparator<Person> SORT_BY_RECEIVED_MONEY_COUNT = (o1, o2) -> {
        return Integer.compare(o1.getCountReceiveMoney(), o2.getCountReceiveMoney());
    };
}
