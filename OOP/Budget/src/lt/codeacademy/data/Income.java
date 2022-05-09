package lt.codeacademy.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Income extends Entry {
    private static int counter = 0;

    private final boolean isTransferToBank;
    private final IncomeCategory incomeCategory;

    public Income(BigDecimal sum, LocalDate date, Person person, TransferStatus transferStatus,
                  boolean isTransferToBank, IncomeCategory incomeCategory) {
        super(counter++, sum, LocalDateTime.of(date, LocalTime.now()), person, transferStatus);
        this.isTransferToBank = isTransferToBank;
        this.incomeCategory = incomeCategory;
    }

    public boolean isTransferToBank() {
        return isTransferToBank;
    }

    public IncomeCategory getIncomeCategory() {
        return incomeCategory;
    }

    @Override
    public String toString() {
        return "Income{" +
                "isTransferToBank=" + isTransferToBank +
                ", incomeCategory=" + incomeCategory +
                super.toString() +
                '}';
    }
}