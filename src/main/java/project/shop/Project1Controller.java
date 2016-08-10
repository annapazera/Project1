package project.shop;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class Project1Controller {



    @RequestMapping("/form01")
    public String form(){
        return "form02";
    }

    ArrayList<Product> listaProduktow = new ArrayList<Product>();

    @RequestMapping("/AniSklep")
    public String sklep(@RequestParam(value = "name", required = true) String name,
                        @RequestParam(value = "category", required = true) String category,
                        @RequestParam(value = "price", required = true) String price,
                        @RequestParam(value = "description", required = true) String description, Model model) throws ProduktJuzIstniejeException {


//                    String name = request.queryParams("name");
//                    String category = request.queryParams("category");
//                    String price = request.queryParams("price");
//                    double pricex = Double.parseDouble(price);
//                    String description = request.queryParams("description");

        for (Product item : listaProduktow) {
            if (item.getName().equals(name)) {
                throw new ProduktJuzIstniejeException();
            }
        }

        Product product = new Product(name, category, price, description);
        listaProduktow.add(product);

        model.addAttribute("products", listaProduktow);

        return "newSklepik";


//                    Map<String, Object> model = new HashMap();
//                    model.put("product", product.toString());
//                    model.put("products", listaProduktow);
//
//                    return new ModelAndView(model, "sklepik.ftl");
//                }, new FreeMarkerEngine()
//        );
    }
}
