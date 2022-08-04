package lt.codeacademy.eShop.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
public class Product{

    private UUID id;
    private String name;
    private String description;
    private String category;
    private Integer quantity;
    private BigDecimal price;


}
