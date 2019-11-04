/**
 * 
 */
package jeux_shogi;

/**
 * @author Tresor
 *
 */
import java.util.Scanner;
public class Joueur {

	String nom, pseudo, date;

	public Joueur(String nom,String pseudo,String date) {
		
		this.nom = nom;
		this.pseudo = pseudo;
		this.date = date;
	}
	
	public static void main() {
		Scanner sc = new Scanner(System.in);
		String nomJoueur1 = sc.nextLine();
		String pseudoJoueur1 = sc.nextLine();
		String nomJoueur2 = sc.nextLine();
		String pseudoJoueur2 = sc.nextLine();
	 	String date = "xxxx-xx-xx";
	 	
	 	Joueur joueur1 = new Joueur(nomJoueur1,pseudoJoueur1,date);
	 	Joueur joueur2 = new Joueur(nomJoueur2,pseudoJoueur2,date);
	 	
		
		
	}
}
