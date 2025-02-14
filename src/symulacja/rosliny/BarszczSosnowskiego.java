package symulacja.rosliny;

import symulacja.Roslina;
import symulacja.Swiat;

import java.awt.*;

public class BarszczSosnowskiego extends Roslina
{
    public BarszczSosnowskiego(Swiat s)
    {
        swiat = s;
        setSila(10);
        setZnak("b");
        setNazwa("Barszcz Sosnowskiego");
        super.powstanie();
    }

    @Override
    public final void akcja() {
        super.akcja();
        Point tmp = new Point(getPolozenie());

        for(int i=0; i<swiat.organizmy.size(); i++) {
            for (int j = -1; j <= 1; j++) {
                for (int k = -1; k <= 1; k++) {
                    if (j == 0 && k == 0)
                        continue;
                    Point tempo = new Point(tmp.x + j, tmp.y + k);
                    if (swiat.organizmy.get(i).getPolozenie().equals(tempo)) {
                        swiat.organizmy.remove(swiat.organizmy.get(i));
                        i--;
                    }
                }
            }
        }

        for (int i = -1; i <= 1; i++)
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0)
                    continue;

                for (int k = 0; k < swiat.organizmy.size(); k++) {
                    Point tempo = new Point(getPolozenie().x + i, getPolozenie().y + j);
                    if (swiat.organizmy.get(k).getPolozenie().equals(tempo)) {
                        String pow = '\n' + "Zwierze " + swiat.organizmy.get(i).getNazwa() + " zostala zabita przez " + getNazwa();
                        swiat.powiadomienia.add(pow);
                        swiat.organizmy.remove(k);
                        }
                    }
                int rozsianie = (int) (Math.random() * P);
                if (rozsianie == 1) {
                    BarszczSosnowskiego dziecko = new BarszczSosnowskiego(this.swiat);
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
