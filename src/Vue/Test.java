/**
 * 
 */
package Vue;

import model.Plateau;
	

public class Test {
	public Partie part;
	public static Plateau tab;
	
	public static void main(String[] args) {
		Thread c= new Thread() {
			public void run() {
		Partie part = new Partie();
		Plateau tab = new Plateau();
		//tab.addObserver(part);
		tab.afficher();
		part.jouer();
			}
		};
		Thread g= new Thread() {
			public void run() {
				Fenetre fenetre = new Fenetre();
			}
		};
		c.start();
		g.start();
	}

}
