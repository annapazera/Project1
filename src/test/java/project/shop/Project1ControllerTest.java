package project.shop;

import org.mockito.ArgumentCaptor;
import org.springframework.ui.Model;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.BDDMockito.given;
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

    @Test
    public void shouldGetClientsDetails() {


        // given
        ProductRepository productRepository = mock(ProductRepository.class);
        ShoppingCart shoppingCart = mock(ShoppingCart.class);
        ClientRepository clientRepository = mock(ClientRepository.class);

        Project1Controller sut = new Project1Controller(productRepository, shoppingCart, clientRepository);

        Model model=mock(Model.class);
        Client client = mock(Client.class);


        ClientFactory clientFactory = mock(ClientFactory.class);
        Client client2 = mock(Client.class);

        given(clientFactory.createClient("Anna", "Pazera", "Blablabla", "13", "12", "95-050", "Kansas")).willReturn(client2);


        // when
        sut.daneKlienta("Anna", "Pazera", "Blablabla", "13", "12", "95-050", "Kansas", model);

        // then

//        verify(clientRepository).addClient(any());
      //  when(clientRepository.).thenReturn(client);

        ArgumentCaptor<Client> captor = ArgumentCaptor.forClass(Client.class);



        verify(clientRepository).addClient(captor.capture());

        Client actualArgument=captor.getValue();

     //   Assert.assertThat(actualArgument., equalTo("Anna"));

        assertThat(actualArgument).isEqualToComparingFieldByField(new Client("Anna", "Pazera", "Blablabla", "13", "12", "95-050", "Kansas"));


    }



}