package project.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna Kacprzak on 2016-08-12.
 */
@Scope("singleton")
@Component
public class InMemoryProductRepository implements ProductRepository {
    private List<Product> products = new ArrayList<Product>();

    @Override
    public boolean productExistsWithGivenName(String name) {
        for (Product product : products) {
            if (product.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void createNewProduct(Product product) {

        products.add(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductByName(String name) {

        for (Product product : products) {

            if (name.equals(product.getName())) {
                return product;
            }
        }
        return null;

    }
}

