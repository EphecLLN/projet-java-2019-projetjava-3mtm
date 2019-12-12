package modele;

public class Tour {

	
	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */
	
	public boolean bouffer(int x, int y, int x2, int y2) {
		//Plateau tab = new Plateau();
		Partie part = new Partie();
		int def= Partie.player;
		if (Plateau.tableau[x2][y2] == 0) {
			Plateau.setTableau(x, y, x2, y2);
		} else {
			for (int i = 0; i < 8; i++) {
				if (Plateau.tableau[x2][y2] == Plateau.piece[i]) {
					Partie.setMessErreur("vous avez deja une piece a cette position !");
					--Partie.player;
					break;

				} else {
					//new Plateau();
					if (Plateau.tableau[x2][y2] == Plateau.piece2[i]) {
						Plateau.setTableau(x, y, x2, y2);
						/*
						Plateau.tableau[x2][y2] = Plateau.tableau[x][y];
						Plateau.tableau[x][y] = 0;*/
						break;

					}
				}
			}
		}
		if(def==Partie.player) {
			return true;
		}else {
			return false;
		}
	}

	public void tour(int x, int y, int x2, int y2) {
		//Plateau tab = new Plateau();
		//Partie part = new Partie();
		int def= Partie.player;
		System.out.println(Plateau.tableau[x][y-1]);
		if ((x2 > x) && (y2 == y)) {//si le deplacement est vertical et vers le bas

			outerloop:  for (int i = x+1; i <= x2 ; i++) {
				 if(Plateau.tableau[i][y]!=' ') {
					 System.out.println(Plateau.tableau[i][y]);
					if (x2 == i) {
						bouffer(x, y, x2, y2);
						/*
						for (int j = x + 1; j < x2 + 1; j++) {
							System.out.println();
							
							if ((Plateau.tableau[j][0] != 0) && (Plateau.tableau[j][0] != Plateau.tableau[x2][y2])) {
								Partie.setMessErreur("deplacement non autorisÃ©");
								System.out.println(Plateau.tableau[j][0]);
								--Partie.player;
								break;
							}else if (i == x2) {
								this.bouffer(x, y, x2, y2);
								break;
	
							}
						}*/
					}else {
						Partie.setMessErreur("deplacement non autorisé");
						Partie.setMessErreur("tteesstt");
						--Partie.player;
						break;
					}
				 }
			}
		} else if ((x2 < x) && (y2 == y)) {
			outerloop: for (int i = x-1; i >= x2; i--) {
				 if(Plateau.tableau[i][y]!=' ') {
					 System.out.println(Plateau.tableau[i][y]);

				if (x2 == i) {
					bouffer(x, y, x2, y2);
					/*
					for (int j = x - 1; j >= x2; j--) {
					
						if ((Plateau.tableau[j][0] != 0) && (Plateau.tableau[j][0] != Plateau.tableau[x2][y2])) {
							System.out.println(Plateau.tableau[j][0]);

							Partie.setMessErreur("deplacement non autorisÃ©");
							--Partie.player;
							break;
						} else if (i == x2) {

							this.bouffer(x, y, x2, y2);
							break;

						}
					}*/
				}else {
					Partie.setMessErreur("deplacement non autorisé");
					Partie.setMessErreur("tteesstt");
					--Partie.player;
					break;
				}
				 }
			}

		} else if ((x2 == x) && (y2 > y)) {

			outerloop: for (int i = y+1; i <= y2 + 1; i++) {
				System.out.println(Plateau.tableau[x][i]);
				 if(Plateau.tableau[x][i]!=' ') {
					 
				if (y2 == i) {
					bouffer(x, y, x2, y2);
					/*
					for (int j = y + 1; j < y2 + 1; j++) {

						if ((Plateau.tableau[j][0] != 0) && (Plateau.tableau[j][0] != Plateau.tableau[x2][y2])) {
							Partie.setMessErreur("deplacement non autorisÃ©");
							--Partie.player;
							break;
						} else if (i == y2) {

							this.bouffer(x, y, x2, y2);
							break;

						}
					}*/
				}else {
					Partie.setMessErreur("deplacement non autorisé");
					Partie.setMessErreur("tteesstt");
					--Partie.player;
					break;
				}
				 }

			}

		} else if ((x2 == x) && (y2 < y)) {
			outerloop: for (int i = y-1; i >= y2; i--) {
				 if(Plateau.tableau[x][i]!=' ') {
					 System.out.println(Plateau.tableau[x][i]);
				if (y2 == i) {
					bouffer(x, y, x2, y2);
				
					/*
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
				*/

			}else {
				Partie.setMessErreur("deplacement non autorisé");
				Partie.setMessErreur("tteesstt");
				--Partie.player;
				break;
			}
			}
			}
		}
		/*
		if(Partie.player==def) {
			if(def%2==0) {
				if(x2>8) {
				Plateau.tableau[x2][y2]='d';
				}
			}else {
				if(x2<2) {
					Plateau.tableau[x2][y2]='D';
					}
			}
		}*/

		
	}
}
