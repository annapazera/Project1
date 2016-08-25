package project.shop;

import org.springframework.jdbc.core.JdbcTemplate;
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
        for (Product product : getAllProducts()) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void createNewProduct(Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        return jdbcTemplate.query("SELECT name, category, price, description FROM products",
        new ProductRowMapper());
    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : getAllProducts()) {

            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;
    }
}
