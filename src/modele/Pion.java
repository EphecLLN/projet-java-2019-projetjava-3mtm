package modele;

public class Pion {
Plateau tab = new Plateau();

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
}
	}