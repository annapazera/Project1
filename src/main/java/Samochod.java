/**
 * Created by Anna Kacprzak on 2016-07-29.
 */
public class Samochod {
    private String marka;
    private String model;
    private int wiek;
    private Kolo kolo;

    @Override
    public String toString() {
        return "Samochod{" +
                "marka='" + marka + '\'' +
                ", model='" + model + '\'' +
                ", wiek=" + wiek +
                ", kolo=" + kolo +
                ", silnik=" + silnik +
                ", skrzyniaBiegow=" + skrzyniaBiegow +
                '}';
    }

    private Silnik silnik;
    private SkrzyniaBiegow skrzyniaBiegow;


    public void minalRok (){
        this.wiek+=1;
    }
    public String makraModel (){
        return marka + " " + model;
    }

    public Samochod(String marka, String model, int wiek, Kolo kolo, Silnik silnik, SkrzyniaBiegow skrzyniaBiegow){
        this.marka = marka;
        this.model = model;
        this.wiek = wiek;
        this.kolo=kolo;
        this.silnik=silnik;
        this.skrzyniaBiegow=skrzyniaBiegow;
    }

}
