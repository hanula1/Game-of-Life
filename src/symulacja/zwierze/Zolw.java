package symulacja.zwierze;

import symulacja.Swiat;
import symulacja.Zwierze;

import java.awt.*;

public class Zolw extends Zwierze {
    public Zolw(Swiat s)
    {
        swiat = s;
        setSila(2);
        setInicjatywa(1);
        setZnak("Z");
        setNazwa("Zolw");
        super.powstanie();
    }

    @Override
    public final void akcja() {
        int liczba = (int) (Math.random() * 4);
        if(liczba==0) {
            super.akcja();
        }
    }

    @Override
    public final void rozmnazanie()
    {
        Point tmp = new Point(getPolozenie());
        Zolw dziecko = new Zolw(swiat);
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
          //  swiat.powiadomienia.add(pow);
        }
    }
}
