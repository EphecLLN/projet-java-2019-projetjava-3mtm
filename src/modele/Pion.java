package modele;

public class Pion {
	

	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */

	public void pion(int x, int y, int x2, int y2) {
		int def = Partie.player;
		if (Plateau.tableau[x2][y2] == 0) {
			if (((y2 == y) && (x2 == x + 1)) || ((y2 == y) && (x2 == x - 1))) {
				Partie.setMessage(" ");
				Plateau.setTableau(x, y, x2, y2);
			} else {
		Partie.setMessErreur("Deplacement non autorisé !");
				--Partie.player;
			}

		} else {
			for (int i = 0; i < Plateau.piece.length; i++) {
				if (Partie.player % 2 == 1) {
					
					if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
						Partie.setMessErreur("vous avez deja une piece a cette position !");
						--Partie.player;
						break;
					}
				} else {
					
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Partie.setMessErreur("Deplacement non autorisé !");
						--Partie.player;
						break;
					}
				}

			}
			if (((y2 == y) && (x2 == x + 1)) || ((y2 == y) && (x2 == x - 1))) {
				Partie.setMessage(" ");
				Plateau.setTableau(x, y, x2, y2);
			}
			if (Partie.player == def) {
				if (def % 2 == 1) {
					if (x2 > 7) {
						Plateau.tableau[x2][y2] = 'G';
					}
				} else {
					if (x2 < 1) {
						Plateau.tableau[x2][y2] = 'g';
					}
				}
			}
		}
		
	}
}