package project.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class Project1Controller {

    private ProductRepository productRepository;

    ArrayList<Product> kupioneProdukty = new ArrayList<>();

    @RequestMapping("/form01")
    public String form() {
        return "form02";
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
    public String kupowanie(@RequestParam(value = "name", required = true) String name, Model model) {

        kupioneProdukty.add(productRepository.getProductByName(name));

        model.addAttribute("kupioneProdukty", kupioneProdukty);
        return "kupione";
    }
}