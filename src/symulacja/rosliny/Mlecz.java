package symulacja.rosliny;

import symulacja.Roslina;
import symulacja.Swiat;

import java.awt.*;

public class Mlecz extends Roslina {
    public Mlecz(Swiat s)
    {
        swiat = s;
        setZnak("m");
        setNazwa("Mlecz");
        super.powstanie();
    }
    @Override
    public final void akcja() {
        super.akcja();
        Point tmp = new Point(getPolozenie());
        for(int i=0; i<3; i++) {
            int rozsianie = (int) (Math.random() * P);
            if (rozsianie == 1) {
                Mlecz dziecko = new Mlecz(this.swiat);
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
}
