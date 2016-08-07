/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class Kolo {
    @Override
    public String toString() {
        return "Kolo{" +
                "szerokoscKola=" + szerokoscKola +
                ", cisnienie=" + cisnienie +
                ", promien=" + promien +
                '}';
    }

    private double szerokoscKola;
    private double cisnienie;
    private int promien;



    public Kolo(int promien, double szerokoscKola) {
        this.promien=promien;
        this.szerokoscKola=szerokoscKola;

    }

    public void ustawCisnienie(double iloscAtmosfer){
        cisnienie=iloscAtmosfer;

    }
}
