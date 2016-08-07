import project.shop.Product;

import project.shop.ProduktJuzIstniejeException;
import project.shop.ProduktJuzWKoszykuException;
import project.shop.ShoppingCart;
import spark.ModelAndView;
import spark.Spark;
import spark.template.freemarker.FreeMarkerEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
/**
 * Created by Anna Kacprzak on 2016-07-29.
 */
public class Project1 {



    public static void main(String[] args) {
        ArrayList <Product> listaProduktow= new ArrayList<Product>();

        Spark.staticFileLocation("/webfiles");
        String port= System.getenv("PORT");
        if (port !=null) {
            int portInt = Integer.parseInt(port);

            Spark.port(portInt);
        }
            Spark.get("/AniSklep", (request, response)->
            {
                String name = request.queryParams("name");
                String category = request.queryParams("category");
                String price = request.queryParams("price");
                double pricex = Double.parseDouble(price);
                String description = request.queryParams("description");

                for (Product item:listaProduktow){
                    if (item.getName().equals(name)){
                        throw new ProduktJuzIstniejeException();
                    }
                }

                Product product=new Product(name,category,pricex,description );
                listaProduktow.add (product);
                Map<String, Object> model = new HashMap();
                model.put("product", product.toString());
                model.put("products", listaProduktow);



                return new ModelAndView(model, "sklepik.ftl");
            }, new FreeMarkerEngine()
            );

//        Osoba osoba = new Osoba ("Ania", "Pazera", 35 );
//
//
//        osoba.wyswietlDane();
//        String dane = osoba.toString();
//        System.out.println(dane);
//
//        Samochod samochod = new Samochod("Skoda" , "Fabia", 15, 1.4 );
//
//        System.out.println(samochod.toString());
//        samochod.minalRok();
//        System.out.println(samochod.toString());
//       String  daneTech=samochod.makraModel();
//        System.out.println("Mój samochód to " + daneTech);

//        BMI bmi = new BMI ("Ania", "Pazera");
//
//        System.out.println(bmi.toString());
//        bmi.wzrost = 175;
//        bmi.waga = 73;
//        System.out.println(bmi.toString());
//
//        System.out.println("Twoje BMI to " + bmi.obliczBMI() );

//        Silnik silnik = new Silnik ();
//        silnik.moc=60;
//        silnik.momentObrotowy=50;
//        silnik.pojemnosc=2.0;
//
//        System.out.println(silnik.toString());
//
//        SkrzyniaBiegow skrzynia = new SkrzyniaBiegow(true, 5) ;
//        Kolo kolo = new Kolo(45, 15);
//        System.out.println(kolo.toString());
//
//        kolo.ustawCisnienie (2.5);
//        System.out.println(kolo.toString());

//        Product product=new Product("Sukienka wieczorowa", "Sukienki", 150, "Piękna sukienka na wesele");
//        System.out.println(product);

//        Ksiazka ksiazka = new Ksiazka ("Thinking in JAVA", "Bruce Eckel");
//        ksiazka.wydawnictwo="Helion";
//        ksiazka.opis="To jest bardzo dobra książka dla uczących sie programować w Javie";
//        ksiazka.iloscStron=1248;
//        ksiazka.cena=100;
//        ksiazka.pokazOpis();

    }



}
