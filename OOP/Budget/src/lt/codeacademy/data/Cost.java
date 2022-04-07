package lt.codeacademy.data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Cost extends Irasas {

    private final CostTypes costType;
    private final CostCategory costCategory;


    public Cost(BigDecimal sum, LocalDate date, Person person, TransferStatus transferStatus, CostTypes costType, CostCategory costCategory) {
        super(sum, date, person, transferStatus);
        this.costType = costType;
        this.costCategory = costCategory;
    }

    public CostTypes getCostType() {
        return costType;
    }

    public CostCategory getCostCategory() {
        return costCategory;
    }

}
