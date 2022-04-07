package lt.codeacademy.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Irasas {
    private static int counter = 0;
    private final int index;
    private final BigDecimal sum;
    private final LocalDate date;
    private final Person person;
    private TransferStatus transferStatus;

    public Irasas(BigDecimal sum, LocalDate date, Person person, TransferStatus transferStatus) {
        index = counter++;
        this.sum = sum;
        this.date = date;
        this.person = person;
        this.transferStatus = transferStatus;
    }

    public static int getCounter() {
        return counter;
    }

    public int getIndex() {
        return index;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public LocalDate getDate() {
        return date;
    }

    public Person getPerson() {
        return person;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(TransferStatus transferStatus) {
        this.transferStatus = transferStatus;
    }

    @Override
    public String toString() {
        return "Irasas{" +
                "index=" + index +
                ", sum=" + sum +
                ", date=" + date +
                ", person=" + person +
                ", transferStatus=" + transferStatus +
                '}';
    }
}


