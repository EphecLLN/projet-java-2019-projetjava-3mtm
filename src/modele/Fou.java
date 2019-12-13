package modele;

public class Fou {

	


	/**
	 * @param x  >=0 et <9
	 * @param y  >=0 et <9
	 * @param x2 >=0 et <9
	 * @param y2 >=0 et <9
	 */

	public void bouffer(int x, int y, int x2, int y2) {

		//Plateau tab = new Plateau();

		


		if (Plateau.tableau[x2][y2] == 0) {
			Partie.setMessage(" ");
			Plateau.setTableau(x, y, x2, y2);

		} else {
			if(Partie.player%2==1) {
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
			}else {
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

	public void fou(int x, int y, int x2, int y2) {
		//Plateau tab = new Plateau();
		int def=Partie.player;

		if ((x2 > x) && (y2 > y)) {
			outerloop:  for (int i = x+1, j =y+1; i <= x2 && j<=y2 ; i++,j++) {
				System.out.println("test,"+ Plateau.tableau[i][j]+"fin");
				 if(testP(Plateau.tableau[i][j],i,j,x2,y2)) {
					 System.out.println(Plateau.tableau[i][y]);
					if (x2 == i && y2==j) {
						bouffer(x, y, x2, y2);
					}else {
						Partie.setMessErreur("deplacement non autoris�");
						--Partie.player;
						break;
					}
				 }
			}
			/*
			outerloop: for (int i = x + 1, j = y + 1; i <= x2 || j <= y2 + 1; i++, j++) {
				
				if ((x2 == i) && (y2 == j)) {
					
					
					for (int a = x + 1, b = y + 1; a < x2 + 1 && b < y2 + 1; a++, b++) {
						if ((Plateau.tableau[a][b] != 0) && (Plateau.tableau[a][b] != Plateau.tableau[x2][y2])) {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break outerloop;
						}
					}
					this.bouffer(x, y, x2, y2);
					break;
				} else {
					if ((i == x2) || (j == y2)) {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
						break;
					}
				}
			}*/

		} else if ((x2 > x) && (y2 < y)) {
			outerloop:  for (int i = x+1, j =y-1; i <= x2 && j>=y2 ; i++,j--) {
				System.out.println("test,"+ Plateau.tableau[i][j]+"fin");
				 if(testP(Plateau.tableau[i][j],i,j,x2,y2)) {
					 System.out.println(Plateau.tableau[i][y]);
					if (x2 == i && y2==j) {
						bouffer(x, y, x2, y2);
					}else {
						Partie.setMessErreur("deplacement non autoris�");
						--Partie.player;
						break;
					}
				 }
			}
			/*
			outerloop: for (int i = x + 1, j = 1; i < x2 + 1 || j < y; i++, j++) {
				
				if ((x2 == i) && (y2 == y - j)) {
					
					for (int a = x + 1, b = 1; a <= x2 && b <= y; a++, b++) {
						if ((Plateau.tableau[a][y - b] != 0) && (Plateau.tableau[a][y - b] != Plateau.tableau[x2][y2])) {
							
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break outerloop;
						}
					}

					this.bouffer(x, y, x2, y2);
					break;
				} else {
					if ((i == x2) || (j == y)) {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
						break;
					}
				}
			}
*/
		} else if ((x2 < x) && (y2 < y)) {
			outerloop:  for (int i = x-1, j =y-1; i >= x2 && j>=y2 ; i--,j--) {
				System.out.println("test,"+ Plateau.tableau[i][j]+"fin");
				 if(testP(Plateau.tableau[i][j],i,j,x2,y2)) {
					 System.out.println(Plateau.tableau[i][y]);
					if (x2 == i && y2==j) {
						bouffer(x, y, x2, y2);
					}else {
						Partie.setMessErreur("deplacement non autoris�");
						--Partie.player;
						break;
					}
				 }
			}
			/*
			outerloop: for (int i = 1, j = 1; i < x || j < y; i++, j++) {

				if ((x2 == x - i) && (y2 == y - i)) {

					
					for (int a = 1, b = 1; (a >= x2) && (b >= y2); a++, b++) {
					
						if ((Plateau.tableau[x - a][y - b] != 0) && (Plateau.tableau[x - a][y - b] != Plateau.tableau[x2][y])) {
							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break outerloop;

						}
					}
					this.bouffer(x, y, x2, y2);
					break;
				} else {
					if ((i == x) || (j == x)) {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
						break;
					}
				}
			}
*/
		} else if ((x2 < x) && (y2 > y)) {
			outerloop:  for (int i = x-1, j =y+1; i >= x2 && j<=y2 ; i--,j++) {
				System.out.println("test,"+ Plateau.tableau[i][j]+"fin");
				 if(testP(Plateau.tableau[i][j],i,j,x2,y2)) {
					 System.out.println(Plateau.tableau[i][y]);
					if (x2 == i && y2==j) {
						bouffer(x, y, x2, y2);
					}else {
						Partie.setMessErreur("deplacement non autoris�");
						--Partie.player;
						break;
					}
				 }
			}
			/*
			outerloop: for (int i = 1, j = y + 1; i < x || j < y2 + 1; i++, j++) {
				if ((x2 == x - i) && (y2 == j)) {
					for (int a = 1, b = y + 1; a < x + 1 && b < y2 + 1; a++, b++) {
						
						if ((Plateau.tableau[x - a][b] != 0) && (Plateau.tableau[x - a][b] == Plateau.tableau[x2][y2])) {

							Partie.setMessErreur("deplacement non autorisé");
							--Partie.player;
							break outerloop;

						}
					}

					this.bouffer(x, y, x2, y2);
					break;
				} else {
					if ((i == x) || (j == y2)) {
						Partie.setMessErreur("deplacement non autorisé");
						--Partie.player;
						break;
					}
				}
			}
*/
		} else {

			Partie.setMessErreur("deplacement non autorisé");
			--Partie.player;

		}
		System.out.println(Plateau.tableau[x][y]);
		if(def==Partie.player&&(Plateau.tableau[x][y]=='F'||Plateau.tableau[x][y]=='f')) {
			--Partie.player;
			System.out.println("frgyethiej");
		}

		

	}
	public boolean testP(char c,int f,int fa,int a,int ya) {
		boolean b = false;
		for(int i = 0;i<Plateau.piece.length;i++) {
			if(Plateau.piece[i]==c) {
				b= true;
			}
		}
		for(int i = 0;i<Plateau.piece2.length;i++) {
			if(Plateau.piece2[i]==c) {
				b= true;
			}
		}
		if(f==a&&fa==ya) {
			b=true;
		}
		return b;
	}
}
