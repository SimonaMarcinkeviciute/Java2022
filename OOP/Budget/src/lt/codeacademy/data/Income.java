package lt.codeacademy.data;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Income extends Irasas{

    private final boolean isTransferToBank;
    private final IncomeCategory incomeCategory;

// kostruktorius tam, kad uzsetinti reiksmes.


    public Income(BigDecimal sum, LocalDate date, Person person, TransferStatus transferStatus, boolean isTransferToBank, IncomeCategory incomeCategory) {
        super(sum, date, person, transferStatus);
        this.isTransferToBank = isTransferToBank;
        this.incomeCategory = incomeCategory;
    }

    public boolean isTransferToBank() {
        return isTransferToBank;
    }

    public IncomeCategory getIncomeCategory() {
        return incomeCategory;
    }


}
