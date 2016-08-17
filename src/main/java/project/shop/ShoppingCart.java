package project.shop;

import java.util.ArrayList;
import java.util.List;


public interface ShoppingCart {

    void addProduct(Product product) throws ProduktJuzWKoszykuException;

    List<Product> getShoppingCartProducts();
}
