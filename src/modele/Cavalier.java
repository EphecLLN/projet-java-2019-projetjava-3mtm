package modele;

public class Cavalier {

	Plateau tab = new Plateau();

	public void cavalier(int x, int y,int x2, int y2) {
		int [][] coord = {{x+2,y-1},{x+2,y+1}};
		int [][] coord2 = {{x-2,y-1},{x-2,y+1}};
		if(tab.tableau[x2][y2] == 0) {
			for(int i=0; i<2;i++) {
				if(((x2 == coord[i][0])&&(y2 ==coord[i][1]))||((x2 == coord2[i][0])&&(y2 ==coord2[i][1]))){
			tab.tableau[x2][y2] = tab.tableau[x][y];
			tab.tableau[x][y] = 0;
				}
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
