package symulacja;

import symulacja.rosliny.*;
import symulacja.zwierze.*;
import symulacja.Plansza;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import static symulacja.Organizm.M;
import static symulacja.Organizm.N;

public class Swiat {

    public ArrayList<Organizm> organizmy;
    public ArrayList<String> powiadomienia;

    public Symulacja symulacja;

    public Plansza plansza;

    public Swiat(Symulacja s)
    {
        symulacja = s;
        organizmy = new ArrayList<Organizm>();
        powiadomienia = new ArrayList<String>();
        plansza = new Plansza(this);
    }
    public void losujDrop() {
        for (int i = 0; i < N; i++) {
            int liczba = (int) (Math.random() * 10);
            switch (liczba) {
                case 0:
                    organizmy.add(new Antylopa(this));
                    break;
                case 1:
                    organizmy.add(new Lis(this));
                    break;
                case 2:
                    organizmy.add(new Owca(this));
                    break;
                case 3:
                    organizmy.add(new Wilk(this));
                    break;
                case 4:
                    organizmy.add(new Zolw(this));
                    break;
                case 5:
                    organizmy.add(new BarszczSosnowskiego(this));
                    break;
                case 6:
                    organizmy.add(new Guarana(this));
                    break;
                case 7:
                    organizmy.add(new Mlecz(this));
                    break;
                case 8:
                    organizmy.add(new Trawa(this));
                    break;
                case 9:
                    organizmy.add(new WilczeJagody(this));
                    break;
            }
        }
        organizmy.add(new Czlowiek(this));
        rysujPowiadomienia();
        rysujSwiat();
    }

    public boolean pustePole(int x, int y)
    {
        if(x<0 || y<0 || x>=N || y>=M)
            return false;

        for (int i = 0; i < organizmy.size(); i++) {
            if (organizmy.get(i).getPolozenie().x == x && organizmy.get(i).getPolozenie().y == y)
                return false;
        }
        return true;
    }

    public void rysujPowiadomienia()
    {

//        JPanel p = new JPanel();
//        for(int i=0; i<powiadomienia.size(); i++)
//        {
//            JLabel l = new JLabel(powiadomienia.get(i));
//            //l.setBounds(40*N, 40*M + i, 500, 10);
//            p.add(l);
//            //plansza.frame.add(l);
//        }
        System.out.println(powiadomienia);
//        p.setBounds(40*N, 40*M, 500,10);
//        plansza.frame.add(p);
          powiadomienia.clear();
//        SwingUtilities.updateComponentTreeUI(plansza);
    }

    public void wykonajTure()
    {
        sortuj();
        for(int i=0; i<organizmy.size(); i++)
        {
            if(organizmy.get(i).getWiek()==0)
                organizmy.get(i).setWiek(1);
            else
                organizmy.get(i).akcja();
        }

        rysujPowiadomienia();
        rysujSwiat();
    }

    public void rysujSwiat()
    {

        for(int i=0; i<organizmy.size(); i++)
        {
            Point punkt = organizmy.get(i).getPolozenie();
            Point poprzedni = organizmy.get(i).getPoprzedniePolozenie();
            String znak = organizmy.get(i).getZnak();
            plansza.pola[punkt.x][punkt.y].setText(znak);
            plansza.pola[poprzedni.x][poprzedni.y].setText("");
            //plansza.table.setValueAt(znak, punkt.x, punkt.y);
            //plansza.table.setValueAt("",poprzedni.x,poprzedni.y);
        }
        SwingUtilities.updateComponentTreeUI(plansza);
    }

    public void sortuj()
    {
        Comparator<Organizm> comperator = new Comparator<Organizm>() {
            @Override
            public int compare(Organizm o1, Organizm o2) {
                int i = (o2.getInicjatywa() - o1.getInicjatywa());
                if (i != 0)
                    return i;

                return (o2.getWiek() - o1.getWiek());
            }
        };
        Collections.sort(organizmy,comperator);
        //System.out.println(organizmy);
    }
}
