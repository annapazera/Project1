/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class SkrzyniaBiegow {
    private boolean czyAutomat;
    private int iloscBiegow;

    @Override
    public String toString() {
        return "SkrzyniaBiegow{" +
                "czyAutomat=" + czyAutomat +
                ", iloscBiegow=" + iloscBiegow +
                '}';
    }

    public SkrzyniaBiegow(boolean rodzajSkrzyni, int iloscBiegow) {
        this.czyAutomat =rodzajSkrzyni;
        this.iloscBiegow = iloscBiegow;
    }
}


