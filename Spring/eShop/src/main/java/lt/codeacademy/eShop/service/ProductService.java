package lt.codeacademy.eShop.service;

import lt.codeacademy.eShop.dto.Product;
import lt.codeacademy.eShop.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product) {
        product.setId(UUID.randomUUID());
        productRepository.saveProduct(product);
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProduct(UUID id) {
        return productRepository.getProduct(id);
    }

    public void updateProduct(Product product) {
        productRepository.saveProduct(product);
    }

    public void delete(UUID id) {
        productRepository.delete(id);
    }
}
