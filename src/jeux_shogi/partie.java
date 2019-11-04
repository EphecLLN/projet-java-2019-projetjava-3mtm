/**
 * 
 */
package jeux_shogi;

/**
 * @author Tresor
 *
 */
import java.util.Scanner;
public class partie {

public static void main(String[] args) {
		
		System.out.println("*************BIENVENUE DANS CE JEUX DE SHOGI**************");
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
			System.out.println("veuillez patienter!");
			
			
		}else if( choix ==2) {
			System.out.println("pas dispo pour le moment !");
			
		}
		
		
		
		
	}

}
