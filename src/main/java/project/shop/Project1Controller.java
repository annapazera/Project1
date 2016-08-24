package project.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import static jdk.internal.dynalink.support.NameCodec.encode;

@Controller
public class Project1Controller {

    private ProductRepository productRepository;
    private ShoppingCart shoppingCart;
    private ClientRepository clientRepository;


    @Autowired
    public Project1Controller(ProductRepository productRepository, ShoppingCart shoppingCart, ClientRepository clientRepository) {
        this.productRepository = productRepository;
        this.shoppingCart = shoppingCart;
        this.clientRepository = clientRepository;
    }

    @RequestMapping("/")
    public String dodajProdukt(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "newSklepik";
    }

    @RequestMapping("/admin")
    public String form() {
        return "panelAdministracyjny";
    }

    @RequestMapping("/placenie")
    public String formularz(Model model) {
        model.addAttribute("suma", shoppingCart.sumujCenyKupionychProduktow());
        return "platnosci";
    }

    @RequestMapping("/DodajProdukt")
    public String dodajProdukt(@RequestParam(value = "name", required = true) String name,
                               @RequestParam(value = "category", required = true) String category,
                               @RequestParam(value = "price", required = true) String price,
                               @RequestParam(value = "description", required = true) String description, Model model) throws ProduktJuzIstniejeException {


        if (productRepository.productExistsWithGivenName(name)) {
            String error = encode("Produkt o takiej nazwie już istnieje!");
            return "redirect:/admin?error= " + error;

        }
        Product product = new Product(name, category, price, description);
        productRepository.createNewProduct(product);
        return "redirect:/AniSklep";

    }
    @RequestMapping("/AniSklep")
    public String sklep (Model model){
        model.addAttribute("products", productRepository.getAllProducts());
        return "newSklepik";
    }


    @RequestMapping("/kup")
    public String kupowanie(@RequestParam(value = "name", required = true) String name) throws ProduktJuzWKoszykuException {
        Product produktDoKupienia = productRepository.getProductByName(name);
        shoppingCart.addProduct(produktDoKupienia);
        return "redirect:/kupioneProdukty";
    }

    @RequestMapping("/kupioneProdukty")
    public String kupione(Model model) {
        model.addAttribute("kupioneProdukty", shoppingCart.getShoppingCartProducts());
        return "kupione";
    }

    @RequestMapping("/addClient")
    public String daneKlienta(@RequestParam(value = "imie", required = true) String imie,
                              @RequestParam(value = "nazwisko", required = true) String nazwisko,
                              @RequestParam(value = "ulica", required = true) String ulica,
                              @RequestParam(value = "nrDomu", required = true) String nrDomu,
                              @RequestParam(value = "nrMieszkania", required = true) String nrMieszkania,
                              @RequestParam(value = "kod", required = true) String kod,
                              @RequestParam(value = "miasto", required = true) String miasto, Model model) {

        Client client = new Client(imie, nazwisko, ulica, nrDomu, nrMieszkania, kod, miasto);
        clientRepository.addClient(client);
        return "podziekowanie";


    }

    private String encode(String text) {
        try {
            return URLEncoder.encode(text, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }

    }
}