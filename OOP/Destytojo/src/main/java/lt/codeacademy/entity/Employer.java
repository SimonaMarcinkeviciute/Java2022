package lt.codeacademy.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "employers")
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private String email;
    private BigDecimal salary;
    @OneToMany(mappedBy = "employer" , cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Invoice> invoices;

    public Employer(String name, String surname, String phone, String email, BigDecimal salary) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.salary = salary;
    }
}

