package project.shop;

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

    @Override
    public float sumujCenyKupionychProduktow() {
        float suma = 0;
        for (Product product : kupioneProdukty) {
            suma += product.getPrice();

        }
        return suma;

    }}
