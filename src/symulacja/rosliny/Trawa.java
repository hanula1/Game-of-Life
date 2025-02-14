package symulacja.rosliny;

import symulacja.Roslina;
import symulacja.Swiat;

import java.awt.*;

public class Trawa extends Roslina {
    public Trawa (Swiat s)
    {
        swiat = s;
        setZnak("t");
        setNazwa("Trawa");
        super.powstanie();
    }

    @Override
    public final void akcja() {
        super.akcja();
        Point tmp = new Point(getPolozenie());
        int rozsianie = (int) (Math.random() * P);
        if (rozsianie == 1) {
            Guarana dziecko = new Guarana(this.swiat);
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
