package lt.codeacademy.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Entry {
    private final int index;
    private BigDecimal sum;
    private final LocalDateTime date;
    private final Person person;
    private final TransferStatus transferStatus;

    public Entry(int index, BigDecimal sum, LocalDateTime date, Person person, TransferStatus transferStatus) {
        this.index = index;
        this.sum = sum;
        this.date = date;
        this.person = person;
        this.transferStatus = transferStatus;
    }

    public int getIndex() {
        return index;
    }

    public BigDecimal getSum() {
        return sum;
    }

    public void setSum(BigDecimal sum) {
        this.sum = sum;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Person getPerson() {
        return person;
    }

    public TransferStatus getTransferStatus() {
        return transferStatus;
    }

    @Override
    public String toString() {
        return ", index=" + index +
                ", sum=" + sum +
                ", date=" + date +
                ", person=" + person +
                ", transferStatus=" + transferStatus;
    }
}
