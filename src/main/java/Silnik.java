/**
 * Created by Anna Kacprzak on 2016-07-31.
 */
public class Silnik {
    public double pojemnosc;
    public double moc;
    public int momentObrotowy;

    @Override
    public String toString() {
        return "Silnik{" +
                "pojemnosc=" + pojemnosc +
                ", moc=" + moc +
                ", momentObrotowy=" + momentObrotowy +
                '}';
    }
}
