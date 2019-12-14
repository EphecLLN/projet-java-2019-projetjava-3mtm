package vue;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;
import modele.Partie;
import modele.Plateau;
import contolleur.Controller;

public class Console extends Vue implements Observer {

	protected Scanner sc;
	Plateau pat = new Plateau();

	public Console(Partie model, Controller control) {
		super(model, control);

		sc = new Scanner(System.in);
		this.afficher(modele.Plateau.tableau);
		new Thread(new ReadInput()).start();
	}

	public void afficher(char[][] tab) {
		for (int i = 0; i < 9; i++) {
			System.out.print("   " + i);
		}
		System.out.println();
		System.out.println();
		System.out.println(" -------------------------------------");
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {

				System.out.print(" | " + tab[i][j]);
			}

			System.out.print(" | ");
			System.out.println(" " + i);
			System.out.println(" -------------------------------------");
		}

		System.out.println();

	}

	/*
	 * La methode update mettra notre tableau a jour apres chaque deplacement
	 * 
	 */
	
	@Override
	public void update(Observable o, Object arg) {
		if (Partie.getMessErreur() != "***Partie Termin�e !****") {

			if (model.getjouer() == true) {
				
				model.jouer();

				this.afficher(Plateau.tableau);

				System.out.println(Partie.getMessErreur());
				new Thread(new ReadInput()).start();
				
			}
		}else {
			this.afficher(Plateau.tableau);

			System.out.println(Partie.getMessErreur());
			new Thread(new ReadInput()).start();
			System.out.println("forhgeirezoj");
			
		}

	}

	private class ReadInput implements Runnable {

		/*
		 * x , y, x2 ,y2 sont des intergers entre 0 et 8 x et yelle represente les
		 * coordonnées de la piece que nous voulons deplacer x2 et y2 represente les
		 * coordonnées de la casse de destination
		 */
		public void run() {

			model.setjouer(false);
			try {
				do {
					System.out.println("Deplacer De :");
					System.out.print("Y :");
					int x = sc.nextInt();
					control.fixX(x);
				} while (control.verif(model.getX()) == false);

				do {
					System.out.print("X :");
					int y = sc.nextInt();
					control.fixY(y);
					System.out.println();
				} while (control.verif(model.getY()) == false);

				do {
					System.out.println("Deplacer A :");
					System.out.print("Y :");
					int x2 = sc.nextInt();
					control.fixX2(x2);
				} while (control.verif(model.getX2()) == false);

				do {
					System.out.print("X :");
					int y2 = sc.nextInt();
					control.fixY2(y2);
					System.out.println();
				} while (control.verif(model.getY2()) == false);

				model.setjouer(true);
			} catch (Exception e) {
				System.out.println("tableau a jour");
			}

		}

	}

}