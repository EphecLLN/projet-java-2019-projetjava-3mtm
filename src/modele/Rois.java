package modele;

public class Rois {

	

	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */
	public void rois(int x, int y, int x2, int y2) {
  	  

		//Plateau tab = new Plateau();
  	 

		Partie part = new Partie();
		int def = Partie.player;

		/*
		 * coord est un tableau qui contient tout les deplacement possible du roi
		 */

		int[][] coord = { { x, y + 1 }, { x - 1, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, { x + 1, y + 1 },
				{ x - 1, y - 1 }, { x + 1, y - 1 } };
		/*
		 * verifie Si la casse de destination est vide sinon on verfie si la piece a
		 * cette casse est un piece alliee dans ce cas un message d'erreur est renvoye
		 * au cas contraire cette piece est bouffé
		 */
		if (Plateau.tableau[x2][y2] == 0) {

			for (int i = 0; i < 8; i++) {
				if ((x2 == coord[i][0]) && (y2 == coord[i][1])) {
					/*
					 * on parcoure le tableau des movement possible et on verifie ci les coordonne
					 * de destination appartiennent a ce tableau si oui on fait le deplacement si
					 * non un message d'erreur est renvoyé
					 */
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
				if (Partie.player % 2 == 1) {
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} else if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Plateau.setTableau(x, y, x2, y2);
						break;
					}

				} else {
					/*
					 * Si cest au joueur 2 de jouer
					 */
					if (Partie.player % 2 == 0) {
						if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
							Partie.setMessErreur("vous avez deja une piece a cette position !");
							--Partie.player;
							break;
						} else if (Plateau.tableau[x2][y2] ==Plateau.piece[i]) {
							Plateau.setTableau(x, y, x2, y2);
							break;

						}
					}
				}
				
			}
		}
		
		if (def == Partie.player && (Plateau.tableau[x][y] == 'R' || Plateau.tableau[x][y] == 'r')) {
			--Partie.player;
		}

	}
}
