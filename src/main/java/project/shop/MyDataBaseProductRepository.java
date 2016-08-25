package project.shop;

import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;

@Component
public class MyDataBaseProductRepository implements ProductRepository {
    public MyDataBaseProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }

   private DataSource dataSource;

    @Override
    public boolean productExistsWithGivenName(String name) {
        return false;
    }

    @Override
    public void createNewProduct(Product product) {

    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public Product getProductByName(String name) {
        return null;
    }
}
