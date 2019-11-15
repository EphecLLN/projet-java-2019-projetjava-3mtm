
/**
 * 
 */
package vue_console;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



import java.util.Scanner;

/**
 * @author Tresor
 *
 */
public class Partie {
	String pseudo1,pseudo2,dateJeux,vainqeur;
	String sauv[]; 
	
	/*public Partie(String pseudo1,String pseudo2,String dateJeux,String gagnant) {
		this.pseudo1 = pseudo1;
		this.pseudo2 = pseudo2;
		this.dateJeux= dateJeux;
		this.vainqeur = gagnant;
		this.sauv = sauv;
	}*/

	
	
	public void Identifiant(String joueur1, String joueur2, String datePartie) {
		
		Partie part = new Partie();
		 this.pseudo1 = joueur1;
		 this.pseudo2 = joueur2;
		this.dateJeux = datePartie;
		sauv[0] = joueur1;
		sauv[1] = joueur2;
		sauv[2] = datePartie;
		
		
	}
	
	public static void  main (String [] args) {
		// TODO Auto-generated method stub
		
		
		
			System.out.println("******************Bienvenue dans cette partie de shogi************* ");
			System.out.println("voulez vous?");
			System.out.println("1:commencer une nouvelles partie");
			System.out.println("2:charger une partie existante");
			Scanner sc = new Scanner(System.in);
			int choix = sc.nextInt();
				while ((choix != 1)&&(choix != 2)) {
				System.out.println("veuillez entrer 1 pour commencer une nouvelle parties!");
				System.out.println("veuillez entrer 2 pour charger une partie existante !");
				choix = sc.nextInt();
				
			}
			
			if( choix == 1) {
			
				/*Partie id = new Partie();
				Deplacer mov =new Deplacer();
				Tableau tab = new Tableau();
				id.Identifiant();
				
				tab.afficher();
				mov.move();
				//mov.clearScreen();*/
				
			}else if( choix ==2) {
				System.out.println("pas dispo pour le moment !");
				
			}
			
			
	
		 
		 
	
	}
	
		
		
		}






