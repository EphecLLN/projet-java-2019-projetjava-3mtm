package modele;

public class Lance {
	
	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */

	public void bouffer(int x, int y, int x2, int y2) {

		//Plateau tab = new Plateau();

		


		if (Plateau.tableau[x2][y2] == 0) {
			Plateau.setTableau(x, y, x2, y2);
			/*Plateau.tableau[x2][y2] = Plateau.tableau[x][y];
			Plateau.tableau[x][y] = 0;*/

		} else {
			for (int i = 0; i < 8; i++) {
				if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
					Partie.setMessErreur("vous avez deja une piece a cette position !");
					--Partie.player;
					break;

				} else if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {

					Plateau.setTableau(x, y, x2, y2);
					
					break;

				}
			}
		}
	}

	public void lance(int x, int y, int x2, int y2) {

		
		



		if (Partie.player % 2 == 1) {
			for (int i = x + 1; i < x2 + 1; i++) {
				
				if ((Plateau.tableau[i][0] != 0)&&(Plateau.tableau[i][0] != Plateau.tableau[x2][y2])) {
					Partie.setMessErreur("deplacement non autorise !");
					--Partie.player;
					break;
				} else if (i == x2) {

					if ((y2 == 0) && (x2 > x)) {
						this.bouffer(x, y, x2, y2);
						break;
					} else {
						Partie.setMessErreur("deplacement non autorisé");
					}
				}

			}

		} else {

			for (int i = x - 1; i > x2 - 1; i++) {
				if (Plateau.tableau[i][0] != 0) {
					Partie.setMessErreur("deplacement non autorisé");
					--Partie.player;
					break;
				} else if (i == x2) {

					if ((y2 == 0) && (x2 < x)) {
						this.bouffer(x, y, x2, y2);
						
						break;
					} else {
						Partie.setMessErreur("deplacement non autorisé");
					}
				}

			}

		}
		

	}
}
