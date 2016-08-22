package project.shop;

import org.springframework.ui.Model;
import org.testng.annotations.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class Project1ControllerTest {


    private ProductRepository productRepository;
    private ShoppingCart shoppingCart;
    private ClientRepository clientRepository;
    private String name;

    @Test
public void test1() throws ProduktJuzWKoszykuException {

        // given

        ProductRepository productRepository=mock(ProductRepository.class);
        ShoppingCart shoppingCart=mock(ShoppingCart.class);
        ClientRepository clientRepository=mock(ClientRepository.class);

  Project1Controller project1Controller = new Project1Controller(productRepository, shoppingCart, clientRepository );


        Model model=mock(Model.class);
        Product product= mock(Product.class);
        when(product.getName()).thenReturn(name);

        // when
        project1Controller.kupowanie("",model);

        // then


}





}