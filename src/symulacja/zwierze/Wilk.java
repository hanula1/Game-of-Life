package symulacja.zwierze;

import symulacja.Swiat;
import symulacja.Zwierze;

import java.awt.*;

public class Wilk extends Zwierze
{
    public Wilk(Swiat s)
    {
        swiat = s;
        setSila(9);
        setInicjatywa(5);
        setZnak("W");
        setNazwa("Wilk");
        super.powstanie();
    }

    @Override
    public final void rozmnazanie()
    {
        Point tmp = new Point(getPolozenie());
        Wilk dziecko = new Wilk(swiat);
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
           // String pow = "Powstalo nowe zwierze: " + getNazwa();
           // swiat.powiadomienia.add(pow);
        }
    }
}
