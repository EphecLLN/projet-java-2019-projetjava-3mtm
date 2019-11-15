/**
 * 
 */
package modele;


/**
 * @author Fantuzzi Sébastien
 *
 */
public class Partie {
	
	public String pseudo1, pseudo2, dateJeux, vainqeur;
	public String sauv[] = new String[3]; 
	
	/**
	 * Méthode qui initialise les variables sur base des paramètres qu'elle reçoit
	 * @param les pseudo des 2 joueurs et la date de la partie
	 */
	public void Identifiant(String joueur1, String joueur2, String datePartie) {
		
		Partie part = new Partie();
		part.pseudo1 = joueur1;
		part.pseudo2 = joueur2;
		part.dateJeux = datePartie;
		sauv[0] = joueur1;
	    sauv[1] = joueur2;
		sauv[2] = datePartie;
	}
	
	/**
	 * Préparation de la future interface console
	 */
	public static void  main (String [] args) {
		
		System.out.println("******************Bienvenue dans cette partie de shogi************* ");
		System.out.println("voulez vous?");
		System.out.println("1:commencer une nouvelles partie");
		System.out.println("2:charger une partie existante");
		int choix = 1;
		if( choix == 1) {
			System.out.println("pas dispo pour le moment !");
		}
		else if( choix ==2) {
			System.out.println("pas dispo pour le moment !");
		}
		
		
		Partie part = new Partie();
		part.Identifiant("joueur1", "joueur2", "10/10/19");
		System.out.println(part.sauv[0]);
		System.out.println(part.sauv[1]);
		System.out.println(part.sauv[2]);
	}
}
