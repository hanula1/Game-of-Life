package symulacja;
import javafx.scene.layout.Border;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static symulacja.Organizm.N;
import static symulacja.Organizm.M;
import symulacja.Swiat;

public class Plansza extends Component implements ActionListener {

    private int count = 0;
    private boolean moc = false;
    public int umiejetnosc=2;
    public JLabel label;
    public JLabel label2;
    public JFrame frame;
    public JButton buttonTura;
    public JPanel gamePanel;
    public JPanel buttonPanel;
    public JPanel notPanel;
    public JPanel panel;
    public JTable table;
    private Swiat swiat;

    public JButton buttonUmiejetnosc;

    public JLabel[][] pola = new JLabel[N][M];
    public Plansza(Swiat s)
    {
        swiat = s;
        frame = new JFrame();

       buttonTura = new JButton("Następna Tura");
       buttonTura.setBounds(0,0,10,5);
        buttonUmiejetnosc = new JButton("Umiejetnosc");
        buttonTura.addActionListener(this);

        label = new JLabel("Tura: 0");
        label.setVerticalAlignment(JLabel.CENTER);
        label.setHorizontalAlignment(JLabel.CENTER);
        //label2 = new JLabel("Umiejetnosc dostepna");
//        label2.setVerticalAlignment(JLabel.CENTER);
//        label2.setHorizontalAlignment(JLabel.CENTER);
        //label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 5, true));


        buttonPanel = new JPanel();
        //buttonPanel.setBackground(Color.red);
        buttonPanel.setBounds(40*N,0,500,100);
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        buttonPanel.setLayout(new GridLayout(0, 1));
        buttonPanel.add(buttonTura);
        buttonPanel.add(label);
        buttonPanel.add(buttonUmiejetnosc);
       // buttonPanel.add(label2);

        gamePanel = new JPanel();
//        table = new JTable(N,M);
////        for(int i=0; i<N; i++)
////            for(int j=0; j<M; j++)
////                table.setValueAt(i+", "+j,i,j);
//        table.setRowHeight(35);
//        table.setBounds(0,0,40*N, 40*M);
//        table.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
//        gamePanel.add(table);

        gamePanel.setLayout(new GridLayout(N,M));
        gamePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
       for(int i=0; i<N; i++)
       {
           for(int j=0; j<M; j++) {
               JLabel pole = new JLabel("", JLabel.CENTER);
               pole.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
               pole.setOpaque(true);
               pola[i][j] = pole;
               gamePanel.add(pole);
           }
       }

        //gamePanel.setBounds(0,0,40*N,40*M);

        notPanel = new JPanel();
        //notPanel.setBackground(Color.BLUE);
       // notPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK,3));
        notPanel.setBounds(40*N,101,500,40*M - 100);

        panel = new JPanel();
        panel.add(buttonPanel);
        panel.add(notPanel);
        //panel.setBounds(40*N+1,0,750-40*N,40*M+5);
        //panel.setLayout(new GridLayout(2,1));
        //panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));


        //frame.setLayout(null);
        //frame.setSize(750,750);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.add(buttonPanel);//, BorderLayout.PAGE_START);
       // frame.add(table);//, BorderLayout.LINE_START);
        //frame.add(notPanel);//, BorderLayout.LINE_END);
        frame.add(gamePanel);
        frame.add(panel);

        //frame.setLayout(new FlowLayout());

    frame.setLayout(new GridLayout(1,2));

        frame.setTitle("Symulacja Świata, Hanna Banasiak 193078");
        frame.setResizable(false);
        //frame.getContentPane().setBackground(Color.green);
        //frame.add(label);
        //frame.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        frame.setSize(40*N+300, 30*M-5);
        //frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonTura)
        {
            count++;
            label.setText("Tura: " + count);
            swiat.wykonajTure();
            if(umiejetnosc==0)
            {
                //label2.setText("Umiejetnosc dostepna");
            }
            else if(umiejetnosc<0) {
                //label2.setText("Umiejetnosc niedostepna "+umiejetnosc);
                umiejetnosc++;
            }
            else if (umiejetnosc>0)
            {
               // label2.setText("Umiejetnosc trwa -"+umiejetnosc);
                int t = 0;
                for(int i=0; i<swiat.organizmy.size(); i++)
                    if(swiat.organizmy.get(i) instanceof Czlowiek) {
                        t = i;
                        break;
                    }
                if(umiejetnosc==5)
                    umiejetnosc=-5;
                else
                    umiejetnosc++;
                swiat.organizmy.get(t).kolizja();
            }

        }
        else if(e.getSource() == buttonUmiejetnosc)
        {
            if (umiejetnosc == 0)
            {
               // label2.setText("Umiejetnosc trwa -"+umiejetnosc);
                umiejetnosc++;
            }

            //moc=true;
        }

    }

}
