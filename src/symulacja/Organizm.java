package symulacja;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public abstract class Organizm {
    private int sila;
    private String znak;
    private String nazwa = "";
    private int inicjatywa;
    private Point polozenie;
    private Point poprzednie_polozenie;
    private int wiek;
    public static int N = 20;
    public static int M = 20;

    public Swiat swiat;
    public Organizm() {
       Random rand = new Random();
        polozenie = new Point();
        //nazwa = new String("Cos");
       polozenie.x = rand.nextInt(N);
       polozenie.y = rand.nextInt(M);
       poprzednie_polozenie = new Point(0,0);
    }

    public void powstanie() {
        swiat.powiadomienia.add('\n'+"Powstal nowy organizm: "+this.getNazwa());
    }

    public void setSila(int n) {
        sila = n;
    }

    public int getSila() {
        return sila;
    }

    public String getZnak() {
        return znak;
    }

    public void setZnak(String c) {
        znak = c;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String str) {
        nazwa = str;
    }

    public void setInicjatywa(int n) {
        inicjatywa = n;
    }

    public int getInicjatywa() {
        return inicjatywa;
    }

    public Point getPolozenie() {
        return polozenie;
    }

    public void setPolozenie(int x, int y) {
        polozenie.x = x;
        polozenie.y = y;
    }

    public void setPolozenie(Point n) {
        polozenie.x = n.x;
        polozenie.y = n.y;
    }

    public Point getPoprzedniePolozenie() {
        return poprzednie_polozenie;
    }

    public void setPoprzedniePolozenie(int n, int m) {
        poprzednie_polozenie.x = n;
        poprzednie_polozenie.y = m;
    }

    public void setPoprzedniePolozenie(Point n) {
        poprzednie_polozenie.x = n.x;
        poprzednie_polozenie.y = n.y;
    }

    public int getWiek() {
        return wiek;
    }

    public void setWiek(int n) {
        wiek = n;
    }

    public void akcja() {
        // ?
    }

    public void kolizja() {
        // ?
    }

    public void rysowanie() {
        swiat.plansza.pola[polozenie.x][polozenie.y].setText(this.getZnak());
        SwingUtilities.updateComponentTreeUI(swiat.plansza);
    }

    public void czysc() {
        System.out.print("\033[" + (polozenie.y + 1) + ";" + ((polozenie.x * 2) + 1) + "H ");
    }

    @Override
    public String toString()
    {
        return this.getNazwa()+" Poz: "+getPolozenie().x+' '+getPolozenie().y+", Ini: "+getInicjatywa()+", Wiek: "+getWiek()+"\n";
    }
}
