/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class Ksiazka {
    private String tytul;
    private String autor;
    public String wydawnictwo;
    public String opis;
    public int iloscStron;
    public double cena;

    public Ksiazka (String tytul, String autor){
        this.tytul=tytul;
        this.autor=autor;
    }

    public void pokazOpis(){
        System.out.println(opis);
    }
}
