package lt.codeacademy.eShop.repository;

import lt.codeacademy.eShop.dto.Product;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
public class ProductRepository {
    private final Map<UUID, Product> products;

    public ProductRepository() {
        products = new HashMap<>();
    }

    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }

    public List<Product> getProducts() {
        return products.values()
                .stream()
                .toList();
    }

    public Product getProduct(UUID id) {
        return products.get(id);
    }

    public void delete(UUID id) {
        products.remove(id);
    }
}
