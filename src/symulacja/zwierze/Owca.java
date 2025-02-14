package symulacja.zwierze;

import symulacja.Swiat;
import symulacja.Zwierze;

import java.awt.*;

public class Owca extends Zwierze {
    public Owca(Swiat s)
    {
        swiat = s;
        setSila(4);
        setInicjatywa(4);
        setZnak("O");
        setNazwa("Owca");
        super.powstanie();
    }
    @Override
    public final void rozmnazanie()
    {
        Point tmp = new Point(getPolozenie());
        Owca dziecko = new Owca(swiat);
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
            //dziecko.rysowanie();
            dziecko.swiat = this.swiat;
            swiat.organizmy.add(dziecko);
            //String pow = "Powstalo nowe zwierze: " + getNazwa();
            //swiat.powiadomienia.add(pow);
        }
    }
}
