package symulacja;

import java.awt.*;

public abstract class Roslina extends Organizm {
    protected static int P = 5;

    @Override
    public void akcja() {
        this.kolizja();
        this.setWiek(this.getWiek() + 1);
    }

    @Override
    public void kolizja() {
        int t = 0;
        Point tmp = new Point(this.getPolozenie());

        for (int i = 0; i < swiat.organizmy.size(); i++)
            if (swiat.organizmy.get(i) == this)
                t = i;

        for (int i = 0; i < swiat.organizmy.size(); i++)
        {
            if (swiat.organizmy.get(i) == this)
                continue;

            if (swiat.organizmy.get(i).getPolozenie().equals(tmp))
            {
                if (swiat.organizmy.get(i) instanceof Zwierze)
                {
                    String pow = '\n'+"Roslina " + getNazwa() + " zostala zjedzona przez zwierze " + swiat.organizmy.get(i).getNazwa();
                    swiat.powiadomienia.add(pow);
                    swiat.plansza.pola[tmp.x][tmp.y].setText(getZnak());
                    swiat.organizmy.remove(t);
                    break;
                }
            }
        }

    }
}


