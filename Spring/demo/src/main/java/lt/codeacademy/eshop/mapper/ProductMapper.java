package lt.codeacademy.eshop.mapper;

import lt.codeacademy.eshop.dto.Product;

import org.springframework.jdbc.core.RowMapper;
import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
//reikalingas tik JDBS template
public class ProductMapper implements RowMapper<Product> {


    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Product(
                UUID.fromString(rs.getString("id")),
                rs.getString("name"),
                rs.getString("description"),
                rs.getString("category"),
                rs.getInt("quantity"),
                rs.getBigDecimal("price")
        );

    }
}
