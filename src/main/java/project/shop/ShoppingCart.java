package project.shop;

import java.util.ArrayList;
import java.util.List;


public interface ShoppingCart {
    List<Product> products = new ArrayList<Product>();
  void addProduct (Product product) throws ProduktJuzWKoszykuException;
}
