package project.shop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Project1Controller {

    private ProductRepository productRepository;
    private ShoppingCart shoppingCart;


    @Autowired
    public Project1Controller(ProductRepository productRepository, ShoppingCart shoppingCart) {
        this.productRepository = productRepository;
        this.shoppingCart = shoppingCart;
    }

    @RequestMapping("/")
    public String sklep(Model model) {
        model.addAttribute("products", productRepository.getAllProducts());
        return "newSklepik";
    }

    @RequestMapping("/admin")
    public String form() {
        return "panelAdministracyjny";
    }
    @RequestMapping("/placenie")
    public String formularz() {
        return "platnosci";
    }

    @RequestMapping("/AniSklep")
    public String sklep(@RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "category", required = true) String category,
                        @RequestParam(value = "price", required = true) String price,
                        @RequestParam(value = "description", required = true) String description, Model model) throws ProduktJuzIstniejeException {


        if (productRepository.productExistsWithGivenName(name)) {
            throw new ProduktJuzIstniejeException();
        }


        Product product = new Product(name, category, price, description);
        productRepository.createNewProduct(product);

        model.addAttribute("products", productRepository.getAllProducts());

        return "newSklepik";

    }

    @RequestMapping("/kup")
    public String kupowanie(@RequestParam(value = "name", required = true) String name, Model model) throws ProduktJuzWKoszykuException {
        Product produktDoKupienia = productRepository.getProductByName(name);
        shoppingCart.addProduct(produktDoKupienia);

        model.addAttribute("kupioneProdukty", shoppingCart.getShoppingCartProducts());
        return "kupione";
    }
    @RequestMapping("/addClient")
    public String daneKlienta (@RequestParam(value="imie", required=true) String imie,
                               @RequestParam(value="nazwisko", required=true) String nazwisko,
                               @RequestParam(value="ulica", required=true) String ulica,
                               @RequestParam(value="nrDomu", required=true) String nrDomu,
                               @RequestParam(value="nrMieszkania", required=true) String nrMieszkania,
                               @RequestParam(value="kod", required=true) String kod,
                               @RequestParam(value="miasto", required=true) String miasto, Model model){

    return "podziekowanie";

}}