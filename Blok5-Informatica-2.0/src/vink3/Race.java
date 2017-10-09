package vink3;

/**
 * Race class
 * Class Race maakt gebruik van de class Paard
 * 
 * @author Martijn van der Bruggen
 * @version alpha - aanroep van cruciale methodes ontbreekt
 * (c) 2009 Hogeschool van Arnhem en Nijmegen
 * 
 * Note: deze code is bewust niet op alle punten generiek
 * dit om nog onbekende constructies te vermijden.
 *
 * Updates
 * 2010: verduidelijking van opdrachten in de code MvdB
 * 2011: verbetering leesbaarheid code MvdB
 * 2012: verbetering layout code en aanpassing commentaar MvdB
 * 2013: commentaar aangepast aan nieuwe opdracht MvdB
 * 
 *************************************************
 * Afvinkopdracht: werken met methodes en objecten
 *************************************************
 * Opdrachten zitten verwerkt in de code
 * 1) Declaratie constante
 * 2) Declaratie van Paard (niet instantiering)
 * 3) Declareer een button
 * 4) Zet breedte en hoogte van het frame
 * 5) Teken een finish streep
 * 6) Creatie van 4 paarden
 * 7) Pauzeer
 * 8) Teken 4 paarden
 * 9) Plaats tekst op de button
 * 10) Start de race, methode aanroep
 *
 *
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Race extends JFrame implements ActionListener {


    private static final int lengte = 250;
    private BufferedImage image;
    private Paard h1;
    private Paard h2;
    private Paard h3;
    private Paard h4;
    private Paard h5;
    JButton button = new JButton();
    private JPanel panel;

    /** Applicatie - main functie voor runnen applicatie */
    public static void main(String[] args) {
        Race frame = new Race();
        frame.setSize(500,500);
        frame.createGUI();
        frame.setVisible(true);
    }

    /** Loop de race
     */
    private void startRace(Graphics g) {
        panel.setBackground(Color.white);
        /** Tekenen van de finish streep */
        g.setColor(Color.RED);
        g.fillRect(lengte+10, 0, 3, panel.getHeight());
        h1 = new Paard("Paard1", Color.BLACK);
        h2 = new Paard("Paard2", Color.BLUE);
        h3 = new Paard("Paard3", Color.CYAN);
        h4 = new Paard("Paard4", Color.GRAY);
        h5 = new Paard("Paard5", Color.GRAY);
        /** Loop tot een paard over de finish is*/
        while (h1.getAfstand() < lengte
                && h2.getAfstand() < lengte
                && h3.getAfstand() < lengte
                && h4.getAfstand() < lengte
                && h5.getAfstand() < lengte) {
            h1.run();
            h2.run();
            h3.run();
            h4.run();
            h5.run();
            pauzeer(1000);
            g.clearRect(0,0,500,500);
            panel.setBackground(Color.white);
            g.setColor(Color.RED);
            g.fillRect(lengte+10, 0, 3, panel.getHeight());
            tekenPaard(g, h1);
            tekenPaard(g, h2);
            tekenPaard(g, h3);
            tekenPaard(g, h4);
            tekenPaard(g, h5);

            /** Kijk welk paard gewonnen heeft
             */
            if (h1.getAfstand() > lengte) {
                JOptionPane.showMessageDialog(null, h1.getNaam() + " gewonnen!");
            }
            if (h2.getAfstand() > lengte) {
                JOptionPane.showMessageDialog(null, h2.getNaam() + " gewonnen!");
            }
            if (h3.getAfstand() > lengte) {
                JOptionPane.showMessageDialog(null, h3.getNaam() + " gewonnen!");
            }
            if (h4.getAfstand() > lengte) {
                JOptionPane.showMessageDialog(null, h4.getNaam() + " gewonnen!");
            }
            if (h5.getAfstand() > lengte) {
                JOptionPane.showMessageDialog(null, h5.getNaam() + " gewonnen!");
            }

        }
    }

    /** Creatie van de GUI*/
    private void createGUI() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container window = getContentPane();
        window.setLayout(new FlowLayout());
        panel = new JPanel();
        panel.setPreferredSize(new Dimension(400, 400));
        panel.setBackground(Color.white);
        window.add(panel);
        button.setText("Run!");
        window.add(button);
        button.addActionListener(this);
    }

    /** Teken het paard */
    private void tekenPaard(Graphics g, Paard h) {
       try {
            image = ImageIO.read(new File("/home/mark/IdeaProjects/Paard&Race/horse-512.png"));
       } catch (IOException ex) {
           System.out.println("Afbeelding niet gevonden..");
        }
        g.drawImage(image, h.getAfstand()-20, 20*h.getPaardNummer(),30,30,null );
    }

    /** Actie indien de button geklikt is*/
    public void actionPerformed(ActionEvent event) {
        Graphics paper = panel.getGraphics();
        startRace (paper);
    }

    /** Pauzeer gedurende x millisecondes*/
    public void pauzeer(int msec) {
        try {
            Thread.sleep(msec);
        } catch (InterruptedException e) {
            System.out.println("Pauze interruptie");
        }
    }
    
    
}

