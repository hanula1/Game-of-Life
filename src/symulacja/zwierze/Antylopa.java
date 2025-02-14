package symulacja.zwierze;

import symulacja.Swiat;
import symulacja.Zwierze;
import java.awt.*;
import java.util.Random;

public class Antylopa extends Zwierze {

    public Antylopa(Swiat s) {
        swiat = s;
        setSila(4);
        setInicjatywa(4);
        setZnak("A");
        setNazwa("Antylopa");
        super.powstanie();
    }

    @Override
    public final void akcja() {
        boolean moved = false;
        Point tmp = new Point(getPolozenie());
        czysc();

        while (!moved) {
            int liczba = (int) (Math.random() * 4);
            switch (liczba) {
                case 0: {
                    if (tmp.x + 2 < N) {
                        setPolozenie(tmp.x + 2, tmp.y);
                        moved = true;
                    }
                    break;
                }
                case 1: {
                    if (tmp.x - 2 >= 0) {
                        setPolozenie(tmp.x - 2, tmp.y);
                        moved = true;
                    }
                    break;
                }
                case 2: {
                    if (tmp.y - 2 >= 0) {
                        setPolozenie(tmp.x, tmp.y - 2);
                        moved = true;
                    }
                    break;
                }
                case 3: {
                    if (tmp.y + 2 < N) {
                        setPolozenie(tmp.x, tmp.y + 2);
                        moved = true;
                    }
                    break;
                }
            }
        }
        setPoprzedniePolozenie(tmp);
        rysowanie();
        setWiek(getWiek() + 1);
        kolizja();
    }
    @Override
    public final void rozmnazanie()
    {
        Point tmp = new Point(getPolozenie());
        Antylopa dziecko = new Antylopa(swiat);
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