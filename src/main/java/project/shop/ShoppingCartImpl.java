package project.shop;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCartImpl implements ShoppingCart{


    public void addProduct(Product product) throws ProduktJuzWKoszykuException {
        if (products.contains(product)) {
            throw new ProduktJuzWKoszykuException();
        }
        products.add(product);

    }
}
