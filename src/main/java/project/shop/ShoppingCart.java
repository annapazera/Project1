package project.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class ShoppingCart {
    private List<Product> products = new ArrayList<Product>();
    Product product = new Product("sukienka wieczorowa", "ubrania", 100, "piękna sukienka");

    public void addProduct(Product product) throws ProduktJuzWKoszykuException {
        if (products.contains(product)) {
            throw new ProduktJuzWKoszykuException();
        }
        products.add(product);

    }
}
