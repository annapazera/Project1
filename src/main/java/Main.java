import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class Main {
    public static void main(String[] args) {
        Osoba osoba1= new Osoba ("Ania", "Pazera", 35);
        Osoba osoba2=new Osoba("Tomasz", "Pazera", 34);
        Osoba osoba3=new Osoba("Mikusia", "Kacprzak", 1);

        List<Osoba> lista=new ArrayList<Osoba>();
        lista.add (osoba1);
        lista.add(osoba2);
        lista.add(osoba3);
for (int i=0;i<lista.size();i++){
    System.out.println(lista.get(i));
}
Iterator it=lista.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        for  (Osoba ddd:lista){
            System.out.println(ddd);
        }


//        Kolo kolo= new Kolo (40, 15);
//        kolo.ustawCisnienie(2.5);
//
//        SkrzyniaBiegow skrzyniaBiegow= new SkrzyniaBiegow(true, 5);
//
//        Silnik silnik=new Silnik ();
//        silnik.pojemnosc=100;
//        silnik.moc=60;
//        silnik.momentObrotowy=50;
//
//        Samochod car=new Samochod("Skoda","Fabia", 15, kolo, silnik, skrzyniaBiegow );
//
//        System.out.println(car.toString());
//
//        ShoppingCartImpl shoppingCart=new ShoppingCartImpl();
//        Product product=new Product("Sukienka wieczorowa", "Sukienki", 150, "Piękna sukienka na wesele");
//        Product product2=new Product("Kalosze", "Buty", 70, "Super gumiaki na brzydką pogodę");
//        shoppingCart.products.add(product);
//        shoppingCart.products.add(product2);
//        System.out.println(shoppingCart.products);
//        for (int i=0; i < shoppingCart.products.size() ;i++){
//            System.out.println(shoppingCart.products.get(i));
//        }
    }
}
