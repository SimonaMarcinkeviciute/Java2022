package lt.codeacademy.eshop.exeption;

import java.util.UUID;

public class ProductNotFound extends RuntimeException{

    private final UUID productId;

    public ProductNotFound(UUID productId) {
        this.productId = productId;
    }

    public UUID getProductId() {
        return productId;
    }
}
