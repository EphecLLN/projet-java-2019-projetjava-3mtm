/**
 * 
 */
package modele;

/**
 * @author tresor
 *
 */
public class Gold {
	

	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */
	public void gold(int x, int y, int x2, int y2) {
		/*
		 * coord est un tableau qui contient tout les deplacement possible du Gold
		 */
		int[][] coord = { { x, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, { x + 1, y + 1 }, { x + 1, y - 1 } };
		int[][] coord2 = { { x, y + 1 }, { x - 1, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, { x - 1, y - 1 } };
		if (Plateau.tableau[x2][y2] == 0) {
			for (int i = 0; i < 8; i++) {
				/*
				 * on parcoure le tableau des movements possible et on verifie ci les
				 * coordonnees de destination appartiennent a ce tableau si oui on fait le
				 * deplacement si non un message d'erreur est renvoyé
				 */

				if (((x2 == coord[i][0]) && (y2 == coord[i][1])) || ((x2 == coord2[i][0]) && (y2 == coord2[i][1]))) {

					Plateau.setTableau(x, y, x2, y2);
					break;

				} else {
					if (i == 7) {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
					}
				}
			}

		} else {
			for (int i = 0; i < 8; i++) {
				/*
				 * Si cest au joueur 1 de jouer
				 */
				if (Partie.player % 2 == 1) {

					//new Plateau();
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} else {
						new Plateau();
						if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
							Partie.setMessage(" ");
							Plateau.setTableau(x, y, x2, y2);

						}
					}

				} else {

					//new Plateau();
					/*
					 * Si cest au joueur 2 de jouer
					 */
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} else {
						new Plateau();
						if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
							Partie.setMessage(" ");
							Plateau.setTableau(x, y, x2, y2);

						}
					}
				}
			}
		}
		

	}

}
