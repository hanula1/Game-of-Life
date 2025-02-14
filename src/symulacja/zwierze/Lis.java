package symulacja.zwierze;

import symulacja.Swiat;
import symulacja.Zwierze;

import java.awt.*;

public class Lis extends Zwierze {
    public Lis(Swiat s)
    {
        swiat = s;
        setSila(3);
        setInicjatywa(7);
        setZnak("L");
        setNazwa("Lis");
        super.powstanie();
    }

    @Override
    public final void akcja() {
        //nie przesunie się jak stoi tam silniejszy wróg
        super.akcja();
    }
    @Override
    public final void rozmnazanie()
    {
        Point tmp = new Point(getPolozenie());
        Lis dziecko = new Lis(swiat);
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
          //  String pow = "Powstalo nowe zwierze: " + getNazwa();
           // swiat.powiadomienia.add(pow);
        }
    }
}
