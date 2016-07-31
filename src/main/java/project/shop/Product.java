package project.shop;

/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class Product {
    public String name;
    public String category;
    public double price;
    public String description;

    public Product (String name, String category, double price, String description){
        this.name= name;
        this.category=category;
        this.price=price;
        this.description=description;
    }



    public String toString (){
        return "name:" + name+ ";"+ " category:" + category + ";" + "price:" + price + ";"+ "description: "+description;
    }
}
