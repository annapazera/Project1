package project.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class Project1Controller {

    private ArrayList<Product> listaProduktow = new ArrayList<Product>();

    @RequestMapping("/form01")
    public String form() {
        return "form02";
    }

    @RequestMapping("/AniSklep")
    public String sklep(@RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "category", required = true) String category,
                        @RequestParam(value = "price", required = true) String price,
                        @RequestParam(value = "description", required = true) String description, Model model) throws ProduktJuzIstniejeException {

        for (Product item : listaProduktow) {
            if (item.getName().equals(name)) {
                throw new ProduktJuzIstniejeException();
            }
        }

        Product product = new Product(name, category, price, description);
        listaProduktow.add(product);

        model.addAttribute("products", listaProduktow);

        return "newSklepik";

    }

    @RequestMapping("/kup")
    public String kupowanie(@RequestParam(value = "name", required = true) String name, Model model) {
        for (Product product : listaProduktow) {

            if (name.equals(product.getName())) {

                model.addAttribute("product", product);


            }
        }
        return "kupione";
    }
}