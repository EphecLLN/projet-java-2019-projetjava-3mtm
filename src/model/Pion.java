package model;

import java.util.Observable;

public class Pion extends Observable{
Plateau tab = new Plateau();
public String couleur;
public int tableauN[][] = {{0,1}};
public int tableauB[][] = {{0,-1}};
public int axex;
public int axey;

	public Pion() {
		
	}

	public Pion(int axex,int axey, String couleur) {
		this.axex = axex;
		this.axey = axey;
		this.couleur = couleur;
	
	}

	public void pion(int x, int y,int x2, int y2) {
		
		if(tab.tableau[x2][y2] == 0) {
		if(((y2 == y)&&(x2 == x+1))||((y2 == y)&&(x2 == x-1))){
			tab.tableau[x2][y2] = tab.tableau[x][y];
			tab.tableau[x][y] = 0;
		}
		
	}else {
		for(int i =0; i<8;i++) {
			if( tab.tableau[x2][y2] == tab.piece[i]) {
				System.out.println("vous avez deja une piece a cette position !");
			}else if( tab.tableau[x2][y2] == tab.piece2[i]) {
				tab.tableau[x2][y2] = tab.tableau[x][y];
				tab.tableau[x][y] = 0;
				
			}	
	}
}
		tab.afficher();
		setChanged();
        notifyObservers();
}
	}