package lt.codeacademy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lt.codeacademy.data.Gender;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "passports")

public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String code;
    private String country;
    private Gender gender;


}
