package vink2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

	JPanel paneltje;
	private JTextField tekstvak1;
	private JTextField tekstvak2;

	public static void main(String[] args) {

		Main a = new Main();
		a.getContentPane().setLayout(new FlowLayout());
		a.frame();

	}

	public void frame() {
		setTitle("watermolecuul - Mark de Korte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1000,800);
		paneltje = new JPanel();
		paneltje.setPreferredSize(new Dimension(950,700));
		Container window = this.getContentPane();
		window.add(paneltje);
		tekstvak1 = new JTextField("X-coordinaat");
		tekstvak2 = new JTextField("Y-coordinaat");
		window.add(tekstvak1);
		window.add(tekstvak2);

		JButton knop = new JButton("Maak een nieuw molecuul");
		knop.addActionListener(this);
		window.add(knop);
		setVisible(true);
		setLocationRelativeTo(null);

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		int xPos = Integer.valueOf(tekstvak1.getText());
		int yPos = Integer.valueOf(tekstvak2.getText());
		Graphics g = paneltje.getGraphics();
		g.clearRect(0,0,getWidth(),getHeight());
		g.drawLine(xPos+35,yPos+35, xPos+150,yPos+25);
		g.drawLine(xPos+35,yPos+35, xPos+35,yPos+150);
		g.setColor(Color.BLUE);
		g.fillOval(xPos+125,yPos,50,50);
		g.fillOval(xPos+10,yPos+125,50,50);
		g.setColor(Color.RED);
		g.fillOval(xPos,yPos,70,70 );
		g.setColor(Color.BLACK);




	}
}
