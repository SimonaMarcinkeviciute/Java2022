package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    //uzklausa kuri implementuos pagal kategorija
    List<ProductEntity> findAllByCategory(String category);

    @Query("SELECT p FROM ProductEntity p WHERE p.category = :category AND p.price > :price")
    List<ProductEntity> getProductsByCategoryAndPrice(@Param("category") String category, @Param("price")BigDecimal price);


}
