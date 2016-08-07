/**
 * Created by Anna Kacprzak on 2016-07-29.
 */
public class Osoba {

    public Osoba(String imie, String nazwisko, int wiek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.wiek = wiek;

    }

    private String imie;
    private String nazwisko;
    private int wiek;

    @Override
    public String toString() {
        return "Osoba{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wiek=" + wiek +
                '}';
    }

    public void wyswietlDane () {
        System.out.println(imie + " " + nazwisko);
    }
}
