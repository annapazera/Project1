package project.shop;

/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class Product {
    private String name;
    private String category;
    private String price;
    private String description;

    public Product (String name, String category, String price, String description){
        this.name= name;
        this.category=category;
        this.price=price;
        this.description=description;
    }


    public String getName (){
        return name;
    }
    public String getCategory (){
        return category;
    }
    public float getPrice (){
        return Float.parseFloat(price);
    }
    public String getDescription (){
        return description;
    }

    public String toString (){
        return "name:" + name+ ";"+ " category:" + category + ";" + "price:" + price + ";"+ "description: "+description;
    }
}
