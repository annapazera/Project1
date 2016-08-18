package project.shop;

import org.springframework.stereotype.Component;



public class Client {
    private String imie;
    private String nazwisko;
    private String ulica;
    private String nrDomu;
    private String nrMieszkania;
    private String kod;
    private String miasto;

    public Client(String imie, String nazwisko, String ulica, String nrDomu, String nrMieszkania, String kod, String miasto) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrMieszkania = nrMieszkania;
        this.kod = kod;
        this.miasto = miasto;
    }
}
