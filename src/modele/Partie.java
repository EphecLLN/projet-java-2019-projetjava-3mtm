/**
 * 
 */
package modele;


import java.util.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


/**
 * @author Tekadam Tresor
 *
 */
public class Partie {
	 int x,y,x2,y2;
	Plateau tab = new Plateau();
	public void Initialiser() {

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
			String pseudo1,pseudo2,dateJeux,vainqeur;
			int sauv[]; 
			System.out.println("Veuillez entrer ici le pseudo du joueur1");
			Scanner j1 = new Scanner(System.in);
			 String joueur1 = j1.nextLine();
			 
			 System.out.println("veuillez entrer ici le pesudo du joueur2");
			 Scanner j2 = new Scanner(System.in);
			 String joueur2 = j2.nextLine();
			Date dat = new Date();
			DateFormat dateFormat = new SimpleDateFormat("dd/mm/yy  HH:MM:SS");
			String dateActuelle = dateFormat.format(dat) ;
			
		}else if( choix ==2) {
			System.out.println("pas dispo pour le moment !");
			
		}
		
		
	}
	
	public void move() {
		
		System.out.println(" De");
		System.out.println("X :");
		Scanner sc = new Scanner(System.in);
		 x = sc.nextInt();
		 
		while((x<0)||(x>9)) {
		System.out.println("X doit etre entre 0 et 9");
		x = sc.nextInt();
		};
		
		System.out.println("Y :"); 
		 y = sc.nextInt();
		
		while((y<0)||(y>8)){
		System.out.println("Y doit etre entre 0 et 9");
		y = sc.nextInt();
		}
		System.out.println(" A");
		System.out.println("X :");
		 x2 = sc.nextInt();
		while((x2<0)||(x2>8)) {
			System.out.println("X doit etre entre 0 et 9");
			x2 = sc.nextInt();
		}
			System.out.println("Y :"); 
		 y2 = sc.nextInt();
		while((y2<0)||(y2>8)) {
			System.out.println("Y doit etre entre 0 et 9");
			 y2 = sc.nextInt();
		}
		
	}
	
	public void jouer() {
		Plateau tab = new Plateau();
		Pion pawn = new Pion();
		Rois king = new Rois();
		Silver argent = new Silver();
		Gold or = new Gold();
		Lance spear = new Lance();
		Fou bishop = new Fou();
		Tour rook = new Tour();
		Cavalier knight = new Cavalier();
		do {
			move();
			switch(tab.tableau[x][y]) {
			case 'P' :
				pawn.pion(x, y, x2, y2);
				break;
			case 'R' :
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
			case 'T' : 
				rook.tour(x, y, x2, y2);
				break;
			case 'C' :
				knight.cavalier(x, y, x2, y2);
				break;
			case 'r' :
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
			case 't' : 
				rook.tour(x, y, x2, y2);
				break;
			case 'p' :
				pawn.pion(x, y, x2, y2);
				break;
			case 'c' :
				knight.cavalier(x, y, x2, y2);
				break;
			case 0 :
				System.out.println("Aucune piece n'a ete choisit !");
			}
			
			
			
		}while(x !=9);
		
		
	}
	
	
	public static void  main (String [] args) {
		
		Partie part = new Partie();
		Plateau tab = new Plateau();
		tab.afficher();
		part.jouer();
		
		
		
		}
	
}
