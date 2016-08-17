package project.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Scope("singleton")
@Component
public class ShoppingCartImpl implements ShoppingCart{


    public void addProduct(Product product) throws ProduktJuzWKoszykuException {
        if (products.contains(product)) {
            throw new ProduktJuzWKoszykuException();
        }
        products.add(product);

    }

    @Override
    public void getProducts() {

    }

    @Override
    public void getProducts(Product product) {
        kupioneProdukty.add(product);
    }


}
