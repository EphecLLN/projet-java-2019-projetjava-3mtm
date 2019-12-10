package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Partie;

import modele.*;
import contolleur.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import modele.*;
import contolleur.*;

public class Echequier extends Vue implements Observer, MouseListener {

	int compteurClick = 1;

	public Echequier(Partie model, Controller control) {
		super(model, control);
		// TODO Auto-generated constructor stub
		this.fenetre();
		// new Thread(new ReadInput()).start();
		this.change();
	}

	JFrame f = new JFrame();
	Panneau pan = new Panneau();

	public void fenetre() {

		f.setTitle("SHOGI");
		f.setSize(750, 550);
		// f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		f.setContentPane(pan);
		f.setResizable(false);

		ImageIcon icone = new ImageIcon("download.jpg");
		JLabel image = new JLabel(icone);
		f.add(image);

		f.setContentPane(new Panneau());
		f.setVisible(true);

	}

	// private class ReadInput implements Runnable {

	int click;

	// @Override
	public void change() {
		// TODO Auto-generated method stub
		f.addMouseListener(new MouseAdapter() {
			@Override

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if( modele.Partie.getPlayer() %2 ==1) {

				super.mouseClicked(e);
				int x = e.getX();
				int y = e.getY();
				int a = ((x - 59) / 50);
				int b = ((y - 81) / 50);
				Graphics gr = f.getGraphics();
				if (compteurClick % 2 == 1) {
					model.setjouer(false);
					control.fixX(b);
					Color mycolor = new Color(0, 255, 0, 127);
					gr.setColor(mycolor);
					gr.fill3DRect(57 + (a * 50), 80 + (b * 50), 50, 50, true);
					control.fixY(a);
					++compteurClick;
				} else {

					control.fixX2(b);

					control.fixY2(a);
					System.out.println("   ***"+Partie.getMessage());

					if (modele.Partie.getMessErreur().equals(" ") == false) {
						gr.setColor(Color.red);
						gr.draw3DRect(57 + (a * 50), 80 + (b * 50), 50, 50, true);

					}

					--compteurClick;
					model.setjouer(true);
				}
			}else {
				System.out.println("error");
			}
			}
		});

	}

	// }

	int i = 1;

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (model.getjouer() == true) {

			this.fenetre();

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
