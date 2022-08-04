package lt.codeacademy.eshop.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lt.codeacademy.eshop.entity.ProductEntity;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private UUID id;
    private String name;
    private String description;
    private String category;
    private Integer quantity;
    private BigDecimal price;

    public static Product convert(ProductEntity entity) {
        return new Product(entity.getId(),
                entity.getName(),
                entity.getDescription(),
                entity.getCategory(),
                entity.getQuantity(),
                entity.getPrice());
    }
}
