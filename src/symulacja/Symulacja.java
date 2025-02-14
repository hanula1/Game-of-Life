package symulacja;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Symulacja implements KeyListener {
public Swiat s;
public boolean koniec = false;
    public Symulacja() throws FileNotFoundException {
        s = new Swiat(this);
        s.losujDrop();
//        zapis();
//        odczyt();
    }
    public void isListening()
    {
        s.plansza.frame.setFocusable(true);
        s.plansza.frame.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Wciśnięto strzałkę w górę");
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("Wciśnięto strzałkę w dół");
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            System.out.println("Wciśnięto strzałkę w lewo");
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            System.out.println("Wciśnięto strzałkę w prawo");
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void zapis() throws FileNotFoundException {
        PrintWriter zapis = new PrintWriter("test.txt");
//        for(int i=0; i<s.organizmy.size(); i++) {
//            zapis.println(s.organizmy.get(i).getSila()+'\n');
//            zapis.println(s.organizmy.get(i).getZnak()+'\n');
//            zapis.println(s.organizmy.get(i).getNazwa()+'\n');
//            zapis.println(s.organizmy.get(i).getInicjatywa()+'\n');
//            zapis.println(s.organizmy.get(i).getPolozenie().x+'\n');
//            zapis.println(s.organizmy.get(i).getPolozenie().y+'\n');
//            zapis.println(s.organizmy.get(i).getPoprzedniePolozenie().x+'\n');
//            zapis.println(s.organizmy.get(i).getPoprzedniePolozenie().y+'\n');
//            zapis.println(s.organizmy.get(i).getWiek()+'\n');
//            zapis.println();
//        }
        zapis.close();
    }

    public void odczyt() throws FileNotFoundException {
        Scanner plik = new Scanner(new File("test.txt"));
        String text = plik.nextLine();
        System.out.println(text);
    }
}
