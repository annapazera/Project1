package project.shop;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyDataBaseProductRepository implements ProductRepository {

    public MyDataBaseProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;

    @Override
    public boolean productExistsWithGivenName(String name) {
        try {
            Product productByName = getProductByName(name);
            if (productByName == null) {
                return false;
            } else {
                return true;
            }
        } catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public void createNewProduct(Product product) {
        jdbcTemplate.update("INSERT into products ( name, category, price, description) VALUES ( ?, ?, ?, ?)", product.getName(), product.getCategory(), product.getPrice(), product.getDescription());
    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT name, category, price, description FROM products",
                new ProductRowMapper());
    }

    @Override
    public Product getProductByName(String name) {
        Product product = jdbcTemplate.queryForObject("SELECT name, category, price, description FROM products WHERE name = ?", new ProductRowMapper(), name);

        if (product == null) {
            throw new EmptyResultDataAccessException(1);
        }

        return product;

    }
}
