package symulacja;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Czlowiek extends Zwierze {
    private KeyListener keyListener;
    public Czlowiek(Swiat s) {
        swiat = s;
        setSila(5);
        setInicjatywa(4);
        setZnak("@");
        setNazwa("Czlowiek");
        super.powstanie();
    }

//    @Override
//    public final void akcja() {
//        swiat.symulacja.isListening();
//    }

    @Override
    public final void kolizja() {
        if(swiat.plansza.umiejetnosc>0) {
            for (int i = -1; i <= 1; i++)
                for (int j = -1; j <= 1; j++) {
                    if (i == 0 && j == 0)
                        continue;
                    for (int k = 0; k < swiat.organizmy.size(); k++) {
                        Point tmp = new Point(getPolozenie().x + i, getPolozenie().y + j);
                        if (swiat.organizmy.get(k).getPolozenie().equals(tmp)) {
                            swiat.organizmy.get(k).akcja();

                        }
                    }
                }
        }
    }
}
