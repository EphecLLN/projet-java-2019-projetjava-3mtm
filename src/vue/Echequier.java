package vue;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.*;
import socket.Server;
import contolleur.Controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import modele.*;
import contolleur.*;

public class Echequier extends Vue implements Observer, MouseListener {

	int compteurClick = 1;

	public Echequier(Partie model, Controller control) {
		super(model, control);// => VUE
		// TODO Auto-generated constructor stub
		this.fenetre();// génération de la fenetre(GUI)
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

		ImageIcon icone = new ImageIcon("download.jpg");
		JLabel image = new JLabel(icone);
		f.add(image);// mise en place arriere plan donc avant le pan

		f.setContentPane(new Panneau());// panneau mis en fond
		f.setResizable(false);

		f.setVisible(true);

	}

	// private class ReadInput implements Runnable {

	int click;
	int checkMode = 0;

	// @Override
	public void change() {
		// TODO Auto-generated method stub
		f.addMouseListener(new MouseAdapter() {// mise en place du mouseListener sur la fenetre attention refait a
												// chaque change()
			@Override

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				int x = e.getX();
				int y = e.getY();
				if (y < 500 && y > 400 && x > 600 && x < 710) {
					System.out.println("bas");
					Plateau.tableau = new char[9][9];
					new Plateau();
					Partie.player = 11;
					checkMode = 1;
					try {
						Server s = new Server() ;
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						System.out.println("erreur bouton");
					}
					System.out.println("pass");
					/*try {
						Server.t.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}*/
					model.setjouer(true);
				} else if (y < 400 && y > 300 && x > 600 && x < 710) {
					System.out.println("haut");
					Plateau.tableau = new char[9][9];
					new Plateau();
					Partie.player = 11;
					checkMode = 0;
					model.setjouer(true);

				} else {
					if (checkMode == 0) {

						if (modele.Partie.getPlayer() % 2 == 1) {// si le player est impaire ==>

							// super.mouseClicked(e);

							int a = ((x - 59) / 50);// colonne
							int b = ((y - 81) / 50);// ligne
							Graphics gr = f.getGraphics();
							if (compteurClick % 2 == 1) {// si compteurClick est impaire
								//model.setjouer(false);// jouer mis a false
								model.setMessErreur("");
								if (control.fixX(b) == true && control.fixY(a) == true) {// X mis a b si b est ds le
																							// cadre
									// Y mis a a si a est ds le cadre//ne le fait pas si pas ds le cadre

									Color mycolor = new Color(0, 255, 0, 127);
									gr.setColor(mycolor);
									gr.fill3DRect(57 + (a * 50), 80 + (b * 50), 50, 50, true);// carré vert
									++compteurClick;// compteurClick mis a paire
								}
							} else {// si compteurclick est paire==> deuxieme click pour deplacement
								if (control.fixX2(b) == true && control.fixY2(a) == true) {

									System.out.println("   ***" + Partie.getMessage());

									if (modele.Partie.getMessErreur().equals(" ") == false) {
										gr.setColor(Color.red);
										gr.draw3DRect(57 + (a * 50), 80 + (b * 50), 50, 50, true);

									}

									--compteurClick;
									model.setjouer(true);

								}
							}

						} else {
							model.setMessErreur("");
							// super.mouseClicked(e);
							int a = ((x - 59) / 50);// colonne
							int b = ((y - 81) / 50);// ligne
							Graphics gr = f.getGraphics();
							if (compteurClick % 2 == 1) {// si compteurClick est impaire
								//model.setjouer(false);// jouer mis a false
								if (control.fixX(b) == true && control.fixY(a) == true) {// X mis a b si b est ds le
																							// cadre
									// Y mis a a si a est ds le cadre//ne le fait pas si pas ds le cadre
									Color mycolor = new Color(0, 255, 0, 127);
									gr.setColor(mycolor);
									gr.fill3DRect(57 + (a * 50), 80 + (b * 50), 50, 50, true);// carré vert
									++compteurClick;// compteurClick mis a paire
								}
							} else {// si compteurclick est paire==> deuxieme click pour deplacement
								if (control.fixX2(b) == true && control.fixY2(a) == true) {

									System.out.println("   ***" + Partie.getMessage());

									if (modele.Partie.getMessErreur().equals(" ") == false) {
										gr.setColor(Color.red);
										gr.draw3DRect(57 + (a * 50), 80 + (b * 50), 50, 50, true);

									}

									--compteurClick;
									model.setjouer(true);

								}
							}

						}
					} else {

					}
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
			// model.jouer();
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
