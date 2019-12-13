package modele;

public class Tour {

	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */

	public boolean bouffer(int x, int y, int x2, int y2) {
		Partie part = new Partie();
		int def = Partie.player;
		if (Plateau.tableau[x2][y2] == 0) {
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
		if (def == Partie.player) {
			return true;
		} else {
			return false;
		}
	}

	public void tour(int x, int y, int x2, int y2) {
		int def = Partie.player;
		System.out.println(Plateau.tableau[x][y - 1]);
		if ((x2 > x) && (y2 == y)) {// si le deplacement est vertical et vers le bas

			outerloop: for (int i = x + 1; i <= x2; i++) {
				System.out.println("test," + Plateau.tableau[x][i] + "fin");
				if (testP(Plateau.tableau[i][y], i, x2)) {
					System.out.println(Plateau.tableau[i][y]);
					if (x2 == i) {
						bouffer(x, y, x2, y2);
					} else {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
						break;
					}
				}
			}
		} else if ((x2 < x) && (y2 == y)) {
			outerloop: for (int i = x - 1; i >= x2; i--) {
				System.out.println("test," + Plateau.tableau[x][i] + "fin");
				if (testP(Plateau.tableau[i][y], i, x2)) {
					System.out.println(Plateau.tableau[i][y]);

					if (x2 == i) {
						bouffer(x, y, x2, y2);
					} else {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
						break;
					}
				}
			}

		} else if ((x2 == x) && (y2 > y)) {

			outerloop: for (int i = y + 1; i <= y2 + 1; i++) {
				System.out.println("test," + Plateau.tableau[x][i] + "fin");
				if (testP(Plateau.tableau[x][i], i, y2)) {

					if (y2 == i) {
						bouffer(x, y, x2, y2);
					} else {
						Partie.setMessErreur("deplacement non autorisé");
						System.out.println("test");
						--Partie.player;
						break;
					}
				}

			}

		} else if ((x2 == x) && (y2 < y)) {
			System.out.println(Plateau.tableau[x2][y2]);

			outerloop: for (int i = y - 1; i >= y2; i--) {
				System.out.println("test," + Plateau.tableau[x][i] + "fine");
				char t = (char) ' ';
				if (testP(Plateau.tableau[x][i], i, y2)) {
					System.out.println(Plateau.tableau[x][i]);
					if (y2 == i) {
						bouffer(x, y, x2, y2);
						break;
					} else {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
						break;
					}
				}
			}
		}
		System.out.println(Plateau.tableau[x][y]);
		if (def == Partie.player && (Plateau.tableau[x][y] == 'T' || Plateau.tableau[x][y] == 't')) {
			--Partie.player;
		}

		if (Partie.player == def) {
			if (def % 2 == 1) {
				if (x2 > 7) {
					Plateau.tableau[x2][y2] = 'D';
				}
			} else {
				if (x2 < 2) {
					Plateau.tableau[x2][y2] = 'd';
				}
			}
		}

	}

	public boolean testP(char c, int f, int a) {
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
		if (f == a) {
			b = true;
		}
		return b;
	}
}
