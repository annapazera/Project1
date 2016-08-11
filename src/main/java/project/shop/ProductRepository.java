package project.shop;

import java.util.List;

public interface ProductRepository {

    boolean productExistsWithGivenName(String name);

    void createNewProduct(Product product);

    List<Product> getAllProducts();

    Product getProductByName(String name);
}
