package lt.codeacademy.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;
    private BigDecimal salary;
    private boolean cachPayed;

    @ManyToOne(fetch = FetchType.EAGER)
    //mappinamas pagal
    @JoinColumn(name = "employer_id")
    private Employer employer;

    public Invoice(LocalDateTime date, BigDecimal salary, boolean cachPayed) {
        this.date = date;
        this.salary = salary;
        this.cachPayed = cachPayed;
    }
}
