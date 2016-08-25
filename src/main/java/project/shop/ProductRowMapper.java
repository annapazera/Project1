package project.shop;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Anna Kacprzak on 2016-08-25.
 */
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        String name = resultSet.getString("name");
        String category = resultSet.getString("category");
        String price = resultSet.getString("price");
        String description = resultSet.getString("description");
        Product product = new Product(name, category, price, description);
        return product;
    }
}
