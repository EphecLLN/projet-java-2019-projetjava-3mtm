/**
 * 
 */
package modele;

import java.util.Observable;

/**
 * @author Tekadam Tresor
 * @author Joachim Sanglier
 * @author Fantuzzi Sebastien
 *
 */
/**
 * @author Tresor
 *
 */
@SuppressWarnings("deprecation")
public class Partie extends Observable {
	/**
	 * x et Y sont des interger >= 0 et < 9; Elle represente les coordonnées des
	 * pieces que on veut deplacer x2 et Y2 sont des >=0 et <9 Elle represente les
	 * coordonneés de destination
	 *
	 */

	 int x , y, x2, y2;
	boolean jouer ;
	String joueur1;
	String joueur2; 
	public static  int player = 10;
	static String messErreur =" ";
	static String message = " ";
	



	public static String getMessage() {
		return message;
	}



	public static void setMessage(String message) {
		Partie.message = message;
	}



	public static String getMessErreur() {
		return messErreur;
	}



	public static void setMessErreur(String messErreur) {
		Partie.messErreur = messErreur;
	}



	/**
	 * player est un int qui peut etre soit paire ou impaire permet de passer le
	 * tour d'un joueur a lautre en fonction de ci elle est paire ou impaire
	 *
	 */
	
	

	
	public int getX() {
		return x;
	}
	
	

	public void setX(int x) {
		this.x = x;
		setChanged();
		notifyObservers();
	}

	public void setjouer(boolean bol) {
		this.jouer = bol ;
		setChanged();
		notifyObservers();
	}

	public int getY() {
		return y;
	}
	public boolean getjouer() {
		return jouer;
	}

	public void setY(int y) {
		this.y = y;
		setChanged();
		notifyObservers();
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
		setChanged();
		notifyObservers();
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
		setChanged();
		notifyObservers();
	}

	public String getJoueur1() {
		return joueur1;
		
	}

	public void setJoueur1(String joueur1) {
		this.joueur1 = joueur1;
		setChanged();
		notifyObservers();
	}

	public String getJoueur2() {
		return joueur2;
	}

	public void setJoueur2(String joueur2) {
		this.joueur2 = joueur2;
		setChanged();
		notifyObservers();
	}

	public static int getPlayer() {
		return player;
	}

	public  void setPlayer(int a) {
		Partie.player = player -a;
		setChanged();
		notifyObservers();
	}






		
      public void jouer() {


		
		Rois king = new Rois();
		Pion pawn = new Pion();
		Silver argent = new Silver();
		Gold or = new Gold();
		Lance spear = new Lance();
		Fou bishop = new Fou();
		
		Tour rook = new Tour();
		Cavalier knight = new Cavalier();
		
			
			player++;
			
			if (player % 2 == 1) {
				

				switch (Plateau.tableau[x][y]) {
				
				case 'P':
					pawn.pion(x, y, x2, y2);
					

					break;
				case 'R':
					king.rois(x, y, x2, y2);
					break;
				case 'S':
					argent.silver(x, y, x2, y2);
					break;
				case 'G':
					or.gold(x, y, x2, y2);
					break;

				case 'L':
					
					spear.lance(x, y, x2, y2);
					break;
				case 'F':
					bishop.fou(x, y, x2, y2);
					break;
				case 'T':
					rook.tour(x, y, x2, y2);
					break;
				case 'C':
					knight.cavalier(x, y, x2, y2);
					break;
				case 0:
					Partie.setMessErreur("Aucune piece n'a ete choisit !");//way of accessibf static variables
					--player;
					break;
				default:
					Partie.setMessErreur("la piece choisis ne vous appartiens pas veiuller reesayer !");
					
					--player;
				}
				outerloop: for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {

						if (Plateau.tableau[i][j] == 'r') {
							break outerloop;
						} else if ((i == 8) && (j == 8)) {
							x = 9;
							Partie.setMessErreur("***Partie Terminé !****");
							Partie.setMessage("Le Joueur 2 a gagner ");
							break outerloop;

						}
					}
				}

			} else {
				
				

				switch (Plateau.tableau[x][y]) {
				case 'r':
					king.rois(x, y, x2, y2);
					break;
				case 'g':
					or.gold(x, y, x2, y2);
					break;
				case 's':
					argent.silver(x, y, x2, y2);
					break;
				case 'l':
					spear.lance(x, y, x2, y2);
					break;
				case 'f':
					bishop.fou(x, y, x2, y2);
					break;
				case 't':
					rook.tour(x, y, x2, y2);
					break;
				case 'x':
					pawn.pion(x, y, x2, y2);
					break;
				case 'c':
					knight.cavalier(x, y, x2, y2);
					break;
				case 0:
					Partie.setMessErreur("Aucune piece n'a ete choisit !");
					break;
				default:
					Partie.setMessErreur("la piece choisis ne vous appartiens pas veiuller reesayer !");
					
					--player;
				}
				outerloop: for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						if (Plateau.tableau[i][j] == 'R') {
							break outerloop;
						} else {
							if ((i == 8) && (j == 8)) {
								x = 9;
								Partie.setMessErreur("***Partie Terminé !****");
								Partie.setMessage("Le Joueur 2 a gagner ");
									break outerloop;
							}
						}
					}
				}
			}
		
	}


}

