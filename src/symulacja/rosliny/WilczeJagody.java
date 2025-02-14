package symulacja.rosliny;

import symulacja.Roslina;
import symulacja.Swiat;
import symulacja.Zwierze;

import java.awt.*;

public class WilczeJagody extends Roslina {
    public WilczeJagody (Swiat s)
    {
        swiat = s;
        setSila(99);
        setZnak("wj");
        setNazwa("Wilcze Jagody");
        super.powstanie();
    }

    @Override
    public final void akcja() {
        super.akcja();
        Point tmp = new Point(getPolozenie());
        int rozsianie = (int) (Math.random() * P);
        if (rozsianie == 1) {
            WilczeJagody dziecko = new WilczeJagody(this.swiat);
            boolean success = false;
            if (swiat.pustePole(tmp.x + 1, tmp.y)) {
                dziecko.setPolozenie(tmp.x + 1, tmp.y);
                success = true;
            } else if (swiat.pustePole(tmp.x - 1, tmp.y)) {
                dziecko.setPolozenie(tmp.x - 1, tmp.y);
                success = true;
            } else if (swiat.pustePole(tmp.x, tmp.y + 1)) {
                dziecko.setPolozenie(tmp.x, tmp.y + 1);
                success = true;
            } else if (swiat.pustePole(tmp.x, tmp.y - 1)) {
                dziecko.setPolozenie(tmp.x, tmp.y - 1);
                success = true;
            }
            if (success) {
                dziecko.rysowanie();
                swiat.organizmy.add(dziecko);
            }
        }
    }

}
