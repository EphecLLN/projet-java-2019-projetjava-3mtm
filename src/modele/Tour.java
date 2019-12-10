package modele;

public class Tour {

	
	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */

	public void bouffer(int x, int y, int x2, int y2) {
		//Plateau tab = new Plateau();
		Partie part = new Partie();

		if (Plateau.tableau[x2][y2] == 0) {
			Plateau.tableau[x2][y2] = Plateau.tableau[x][y];
			Plateau.tableau[x][y] = 0;

		} else {
			for (int i = 0; i < 8; i++) {
				if (Plateau.tableau[x2][y2] == new Plateau().piece[i]) {
					
					
					Partie.setMessErreur("vous avez deja une piece a cette position !");
					--Partie.player;
					break;

				} else {
					new Plateau();
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {

						Plateau.tableau[x2][y2] = Plateau.tableau[x][y];
						Plateau.tableau[x][y] = 0;
						break;

					}
				}
			}
		}
	}

	public void tour(int x, int y, int x2, int y2) {
		Plateau tab = new Plateau();
		Partie part = new Partie();

		if ((x2 > x) && (y2 == y)) {

			outerloop: for (int i = x; i < x2 + 1; i++) {
				if (x2 == i) {
					for (int j = x + 1; j < x2 + 1; j++) {
						
						if ((Plateau.tableau[j][0] != 0) && (Plateau.tableau[j][0] != Plateau.tableau[x2][y2])) {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break;
						} else if (i == x2) {
							this.bouffer(x, y, x2, y2);
							break;

						}
					}
				}

			}
		} else if ((x2 < x) && (y2 == y)) {
			outerloop: for (int i = x; i >= x2; i--) {
				
				if (x2 == i) {
					for (int j = x - 1; j >= x2; j--) {
					
						if ((Plateau.tableau[j][0] != 0) && (Plateau.tableau[j][0] != Plateau.tableau[x2][y2])) {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break;
						} else if (i == x2) {

							this.bouffer(x, y, x2, y2);
							break;

						}
					}
				}
			}

		} else if ((x2 == x) && (y2 > y)) {

			outerloop: for (int i = y; i < y2 + 1; i++) {
				if (y2 == i) {
					for (int j = y + 1; j < y2 + 1; j++) {

						if ((Plateau.tableau[j][0] != 0) && (Plateau.tableau[j][0] != Plateau.tableau[x2][y2])) {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break;
						} else if (i == y2) {

							this.bouffer(x, y, x2, y2);
							break;

						}
					}
				}

			}

		} else if ((x2 == x) && (y2 < y)) {
			outerloop: for (int i = x; i >= x2; i--) {
				if (x2 == i) {
					for (int j = x; j >= x2; j--) {

						if ((Plateau.tableau[j][0] != 0) && (Plateau.tableau[j][0] != Plateau.tableau[x2][y2])) {

							--Partie.player;
							break;
						} else if (i == x2) {

							this.bouffer(x, y, x2, y2);
							break;

						}
					}
				}

			}

		}

		
	}
}
