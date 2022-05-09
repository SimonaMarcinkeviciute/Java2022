package lt.codeacademy.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Cost extends Entry {
    private static int counter = 0;

    private final CostType costType;
    private final CostCategory costCategory;

    public Cost(BigDecimal sum, LocalDateTime date, TransferStatus transferStatus,
                CostType costType, CostCategory costCategory) {
        this(sum, date, null, transferStatus, costType, costCategory);
    }

    public Cost(BigDecimal sum, LocalDateTime date, Person person, TransferStatus transferStatus, CostType costType,
                CostCategory costCategory) {
        super(counter++, sum, date, person, transferStatus);
        this.costType = costType;
        this.costCategory = costCategory;
    }

    public CostType getCostType() {
        return costType;
    }

    public CostCategory getCostCategory() {
        return costCategory;
    }

    @Override
    public String toString() {
        return "Cost{" +
                "costType=" + costType +
                ", costCategory=" + costCategory +
                super.toString() +
                '}';
    }
}
