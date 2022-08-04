package lt.codeacademy.eshop.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.eshop.dto.Product;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import java.math.BigDecimal;
import java.util.UUID;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
public class ProductEntity {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "VARCHAR(36)", updatable = false)

    private UUID id;
    private String name;
    private String description;
    private String category;
    private Integer quantity;
    private BigDecimal price;

    public  static ProductEntity convert(Product entity) {
        return new ProductEntity(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getQuantity(),
                entity.getPrice());
    }

}
