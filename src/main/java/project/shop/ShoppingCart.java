package project.shop;

import java.util.ArrayList;
import java.util.List;


public interface ShoppingCart {
    List<Product> products = new ArrayList<Product>();
    ArrayList<Product> kupioneProdukty = new ArrayList<>();
  void addProduct (Product product) throws ProduktJuzWKoszykuException;


    void getProducts();

    void getProducts(Product product);
}
