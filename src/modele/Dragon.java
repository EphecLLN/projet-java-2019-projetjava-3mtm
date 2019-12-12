package modele;

public class Dragon {

	
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
				if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
					
					
					Partie.setMessErreur("vous avez deja une piece a cette position !");
					--Partie.player;
					break;

				} else {
					//new Plateau();
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {

						Plateau.tableau[x2][y2] = Plateau.tableau[x][y];
						Plateau.tableau[x][y] = 0;
						break;

					}
				}
			}
		}
	}

	public void Dragon(int x, int y, int x2, int y2) {
		//Plateau tab = new Plateau();
		Partie part = new Partie();
		int[][] coord = { { x, y + 1 }, { x - 1, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, { x + 1, y + 1 },
				{ x - 1, y - 1 }, { x + 1, y - 1 } };

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
				//new Plateau();
				/*
				 * Si cest au joueur 1 de jouer,
				 */
				if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
					Partie.setMessErreur("vous avez deja une piece a cette position !");
					--Partie.player;
					break;
				} else if (Plateau.tableau[x2][y2] ==  Plateau.piece2[i]) {
					Plateau.setTableau(x, y, x2, y2);
					break;
				}

			} else {
				/*
				 * Si cest au joueur 2 de jouer
				 */
				if (Partie.player % 2 == 0) {
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					} else if (Plateau.tableau[x2][y2] ==Plateau.piece2[i]) {
						Plateau.setTableau(x, y, x2, y2);
						break;

					}
				}
			}

		}
	}
	}
}
