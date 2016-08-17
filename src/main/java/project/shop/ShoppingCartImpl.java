package project.shop;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ShoppingCartImpl implements ShoppingCart{

    ArrayList<Product> kupioneProdukty= new ArrayList<>();


    public void addProduct(Product product) throws ProduktJuzWKoszykuException {
        if (kupioneProdukty.contains(product)) {
            throw new ProduktJuzWKoszykuException();
        }
        kupioneProdukty.add(product);
    }

    @Override
    public List<Product> getShoppingCartProducts() {
        return kupioneProdukty;
    }

}
