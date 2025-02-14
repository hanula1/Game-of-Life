package symulacja;

import symulacja.zwierze.Zolw;

import java.awt.Point;
public abstract class Zwierze extends Organizm {
    public void akcja() {
        boolean moved = false;
        Point tmp = new Point(this.getPolozenie());
        czysc();

        while (!moved) {
            int liczba = (int) (Math.random() * 4);
            switch (liczba) {
                case 0: {
                    if (tmp.x + 1 < N) {
                        this.setPolozenie(tmp.x + 1, tmp.y);
                        moved = true;
                    }
                    break;
                }
                case 1: {
                    if (tmp.x - 1 >= 0) {
                        this.setPolozenie(tmp.x - 1, tmp.y);
                        moved = true;
                    }
                    break;
                }
                case 2: {
                    if (tmp.y - 1 >= 0) {
                        this.setPolozenie(tmp.x, tmp.y - 1);
                        moved = true;
                    }
                    break;
                }
                case 3: {
                    if (tmp.y + 1 < M) {
                        this.setPolozenie(tmp.x, tmp.y + 1);
                        moved = true;
                    }
                    break;
                }
            }
        }
        this.setPoprzedniePolozenie(tmp);
        this.rysowanie();
        this.setWiek(this.getWiek() + 1);
        this.kolizja();
    }

    public void rozmnazanie() {
        //rozmnazanie
    }

    @Override
    public void kolizja() {
        Point tmp = new Point(getPolozenie());

        int t = 0;
        for (int i = 0; i < swiat.organizmy.size(); i++)
            if (swiat.organizmy.get(i) == this)
                t = i;
        for (int i = 0; i < swiat.organizmy.size(); i++) {

            if (swiat.organizmy.get(i) == this)
                continue;
            if (swiat.organizmy.get(i).getPolozenie().equals(tmp)) {
                if (getZnak() == swiat.organizmy.get(i).getZnak()) {
                    rozmnazanie();
                    break;
                }
                else if (swiat.organizmy.get(i) instanceof Zolw) {
                    if (getSila() < 5) {
                        Point tmp_point = new Point(getPolozenie());
                        setPolozenie(new Point(getPoprzedniePolozenie()));
                        setPoprzedniePolozenie(new Point(tmp_point));
                        swiat.plansza.pola[tmp_point.x][tmp_point.y].setText(getZnak());
                        swiat.plansza.pola[swiat.organizmy.get(i).getPolozenie().x][swiat.organizmy.get(i).getPolozenie().y].setText(swiat.organizmy.get(i).getZnak());
                        break;
                    }
                    else {
                        String pow = '\n'+"Zginelo zwierze: Zolw";
                        swiat.powiadomienia.add(pow);
                        //wyswietl
                        swiat.organizmy.remove(i);
                        break;
                    }
                }
                else if (swiat.organizmy.get(i) instanceof Zwierze) {
                    if (swiat.organizmy.get(i).getSila() > getSila()) {
                        String pow = '\n'+"Zwierze " + getNazwa() + " zostalo zabite przez " + swiat.organizmy.get(i).getNazwa();
                        swiat.powiadomienia.add(pow);
                        swiat.plansza.pola[getPolozenie().x][getPolozenie().y].setText(swiat.organizmy.get(i).getZnak());
                        swiat.organizmy.remove(t); // this
                        break;
                    }
                    else {
                        String pow = '\n'+"Zwierze " + swiat.organizmy.get(i).getNazwa() + " zostalo zabite przez " + getNazwa();
                        swiat.powiadomienia.add(pow);
                        swiat.plansza.pola[getPolozenie().x][getPolozenie().y].setText(getZnak());
                        swiat.organizmy.remove(i); // przeciwnik
                        break;
                    }
                }
            }
        }
    }
}