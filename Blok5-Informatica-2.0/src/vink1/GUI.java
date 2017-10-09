package vink1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class GUI extends JFrame{


    int t = 0;

    Color[] kleurtjes = new Color[3];



    public GUI() {

        kleurtjes[0] = new Color(255,0,0);
        kleurtjes[1] = new Color(0,255,0);
        kleurtjes[2] = new Color(0,0,255);



	    setTitle("Titel");
	    setSize(400, 300);

	    fillThatShitUp(this);

	    setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args){

        Frame ding = new GUI();


    }

    public void fillThatShitUp(Frame ding){

        JTextField geval = new JTextField();

        geval.setText("prachtige elegante tekst");

        JButton knopje = new JButton("knoptekst");

        ding.add(BorderLayout.SOUTH,knopje);

        knopje.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e)
            {
                if (t < 2){
                    t += 1;
                }
                else {
                    t = 0;
                }
                geval.setBackground(kleurtjes[t]);

            }
        });




        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                if (t < 2){
                    t += 1;
                }
                else {
                    t = 0;
                }
                geval.setBackground(kleurtjes[t]);

                invalidate();
                validate();
                repaint();


            }
        };
        new Timer(10, taskPerformer).start();






        ding.add(BorderLayout.CENTER,geval);








    }


}
