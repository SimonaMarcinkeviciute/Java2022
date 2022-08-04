package lt.codeacademy.eshop.service;

import lt.codeacademy.eshop.dto.Article;
import lt.codeacademy.eshop.entity.ArticleEntity;
import lt.codeacademy.eshop.exception.ProductNotExistException;
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

    public void createProduct(Article article) {
        productRepository.save(ArticleEntity.convert(article));
    }

    public Page<Article> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(Article::convert);
    }

    public Article getProduct(UUID id) {
        return productRepository.findById(id)
                .map(Article::convert)
                .orElseThrow(() -> new ProductNotExistException(id));
    }

    public void updateProduct(Article article) {
        productRepository.save(ArticleEntity.convert(article));
    }

    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    public List<Article> getProductsByCategory(String category) {
        return productRepository.findAllByCategory(category).stream()
                .map(Article::convert)
                .toList();
    }

    public List<Article> getProductsByCategoryAndPrice(String category, BigDecimal price) {
        return productRepository.getProductsByCategoryAndPrice(category, price).stream()
                .map(Article::convert)
                .toList();
    }

}
