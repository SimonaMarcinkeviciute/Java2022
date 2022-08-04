package lt.codeacademy.eshop.repository;

import lt.codeacademy.eshop.dto.Product;
import lt.codeacademy.eshop.entity.ProductEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.*;
// nebereikalinga repository
@Repository
public class ProductRepositoryNereikalinga {
    private final Map<UUID, Product> products;
    //private final JdbcTemplate jdbcTemplate;
   // private final DataSource dataSource;
    private final ProductRepository productJpaRepository;

    public ProductRepositoryNereikalinga(DataSource dataSource, JdbcTemplate jdbcTemplate, ProductRepository productJpaRepository) {
        products = new HashMap<>();
       // this.dataSource = dataSource;
        //this.jdbcTemplate = jdbcTemplate;
        this.productJpaRepository = productJpaRepository;
    }

    public void saveProduct(Product product) {
        products.put(product.getId(), product);
    }

    //vekia tik sitas pagal paskirti
    public List<ProductEntity> getProducts() {
        return productJpaRepository.findAll();
        //return  jdbcTemplate.query("select * from PRODUCTS", new ProductMapper());
    }

    public Product getProduct(UUID id) {
        return products.get(id);
    }

    public void delete(UUID id) {
        products.remove(id);
    }

    /*public List<Product> getDataSourceProduct() {

        List<Product> products = new ArrayList<>();
        try{
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from PRODUCTS");
            while (resultSet.next()) {
                products.add(new Product(UUID.fromString(resultSet.getString("id")),
                        resultSet.getString("name"),
                        resultSet.getString("description"),
                        resultSet.getString("category"),
                        resultSet.getInt("quantity"),
                        resultSet.getBigDecimal("price")
                ));
            }
        }catch (Exception e) {
            System.out.println(e);
        }

        return products;
    }*/

    public List<ProductEntity> getProductsByCategory(String category) {

        return productJpaRepository.findAllByCategory(category);
    }


}
