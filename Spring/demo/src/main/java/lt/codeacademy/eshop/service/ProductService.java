package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.dto.Product;
import lt.codeacademy.eshop.entity.ProductEntity;

import lt.codeacademy.eshop.exeption.ProductNotFound;
import lt.codeacademy.eshop.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void createProduct(Product product) {
        productRepository.save(ProductEntity.convert(product));
    }

    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(Product::covert);
    }

    public Product getProduct(UUID id) {
        return productRepository.findById(id)
                .map(Product::covert)
                .orElseThrow(() -> new ProductNotFound(id));
    }

    public void updateProduct(Product product) {
        productRepository.save(ProductEntity.convert(product));
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return productRepository.findAllByCategory(category).stream()
                .map(Product::covert)
                .toList();
    }

    public List<Product> getProductsByCategoryAndPrice(String category, BigDecimal price) {
        return productRepository.getProductsByCategoryAndPrice(category, price).stream()
                .map(Product::covert)
                .toList();
    }

}
