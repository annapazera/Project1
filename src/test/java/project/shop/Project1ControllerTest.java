package project.shop;

import org.springframework.ui.Model;
import org.testng.annotations.Test;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.*;

public class Project1ControllerTest {


    private ProductRepository productRepository;
    private ShoppingCart shoppingCart;
    private ClientRepository clientRepository;
    private String name;

    @Test
    public void addsSelectedProductToShoppingCart() throws ProduktJuzWKoszykuException {

        // given
        ProductRepository productRepository = mock(ProductRepository.class);
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        ClientRepository clientRepository = mock(ClientRepository.class);

        Project1Controller sut = new Project1Controller(productRepository, shoppingCart, clientRepository);

        Product expectedProduct = aProduct();
        when(productRepository.getProductByName("shoes")).thenReturn(expectedProduct);

        // when
        sut.kupowanie("shoes");

        // then
        verify(shoppingCart).addProduct(same(expectedProduct));
    }

    private Product aProduct() {
        return new Product("frendzel", "akcesoria", "20000", "Lorem ipsum");
    }


}