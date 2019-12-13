package modele;

public class Cheval {

	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */

	public void bouffer(int x, int y, int x2, int y2) {

		if (Plateau.tableau[x2][y2] == 0) {
			Partie.setMessage(" ");
			Plateau.setTableau(x, y, x2, y2);

		} else {
			if (Partie.player % 2 == 1) {
				for (int i = 0; i < 8; i++) {
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;

					} else {
						if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
							Plateau.setTableau(x, y, x2, y2);
							break;

						}
					}
				}
			} else {
				for (int i = 0; i < 8; i++) {
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;

					} else {
						if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
							Plateau.setTableau(x, y, x2, y2);
							break;

						}
					}
				}
			}
		}
	}

	public void cheval(int x, int y, int x2, int y2) {
		int[][] coord = { { x, y + 1 }, { x, y - 1 }, { x + 1, y }, { x - 1, y }, };
		int def = Partie.player;

		if (Plateau.tableau[x2][y2] == 0) {

			for (int i = 0; i < 8; i++) {
				if ((x2 == coord[i][0]) && (y2 == coord[i][1])) {
					/*
					 * on parcoure le tableau des movement possible et on verifie ci les coordonne
					 * de destination appartiennent a ce tableau si oui on fait le deplacement si
					 * non un message d'erreur est renvoyÃ©
					 */
					Plateau.setTableau(x, y, x2, y2);
					break;

				} else {

					if (i == 7) {
						Partie.setMessErreur("deplacement non autorisÃ©");
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
						} else if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
							Plateau.setTableau(x, y, x2, y2);
							break;

						}
					}
				}

			}
		}

		if (def == Partie.player && (Plateau.tableau[x][y] == 'F' || Plateau.tableau[x][y] == 'f')) {
			if ((x2 > x) && (y2 > y)) {
				outerloop: for (int i = x + 1, j = y + 1; i <= x2 && j <= y2; i++, j++) {
					System.out.println("test," + Plateau.tableau[i][j] + "fin");
					if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
						System.out.println(Plateau.tableau[i][y]);
						if (x2 == i && y2 == j) {
							bouffer(x, y, x2, y2);
						} else {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break;
						}
					}
				}
			} else if ((x2 > x) && (y2 < y)) {
				outerloop: for (int i = x + 1, j = y - 1; i <= x2 && j >= y2; i++, j--) {
					System.out.println("test," + Plateau.tableau[i][j] + "fin");
					if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
						System.out.println(Plateau.tableau[i][y]);
						if (x2 == i && y2 == j) {
							bouffer(x, y, x2, y2);
						} else {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break;
						}
					}
				}
			} else if ((x2 < x) && (y2 < y)) {
				outerloop: for (int i = x - 1, j = y - 1; i >= x2 && j >= y2; i--, j--) {
					System.out.println("test," + Plateau.tableau[i][j] + "fin");
					if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
						System.out.println(Plateau.tableau[i][y]);
						if (x2 == i && y2 == j) {
							bouffer(x, y, x2, y2);
						} else {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break;
						}
					}
				}
			} else if ((x2 < x) && (y2 > y)) {
				outerloop: for (int i = x - 1, j = y + 1; i >= x2 && j <= y2; i--, j++) {
					System.out.println("test," + Plateau.tableau[i][j] + "fin");
					if (testP(Plateau.tableau[i][j], i, j, x2, y2)) {
						System.out.println(Plateau.tableau[i][y]);
						if (x2 == i && y2 == j) {
							bouffer(x, y, x2, y2);
						} else {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break;
						}
					}
				}
			} else {

				Partie.setMessErreur("deplacement non autorisÃ©");
				--Partie.player;

			}
		}
		if (def == Partie.player && (Plateau.tableau[x][y] == 'F' || Plateau.tableau[x][y] == 'f')) {
			--Partie.player;
		}

	}

	public boolean testP(char c, int f, int fa, int a, int ya) {
		boolean b = false;
		for (int i = 0; i < Plateau.piece.length; i++) {
			if (Plateau.piece[i] == c) {
				b = true;
			}
		}
		for (int i = 0; i < Plateau.piece2.length; i++) {
			if (Plateau.piece2[i] == c) {
				b = true;
			}
		}
		if (f == a && fa == ya) {
			b = true;
		}
		return b;
	}
}
