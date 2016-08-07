/**
 * Created by Anna Kacprzak on 2016-07-29.
 */
public class BMI {
    private String imie;
    private String nazwisko;
    int wzrost;
    int waga;

    public BMI (String imie, String nazwisko){
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    public int obliczBMI (){
        int bmi = wzrost - waga;
        return bmi;
    }

    @Override
    public String toString() {
        return "BMI{" +
                "imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", wzrost=" + wzrost +
                ", waga=" + waga +
                '}';
    }
}
