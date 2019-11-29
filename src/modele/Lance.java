package modele;

public class Lance {
	Plateau tab = new Plateau();
	
	public void  lance(int x,int y,int x2,int y2) {
		
		int [][] coord = new int [9][2]; 
		int [][] coord2 = new int [9][2]; 	
		for(int k=x+1; k<9;k++) {
			coord[k][0] = x +k;
			coord[k][1] = y;
			
		}
	
		for(int k=1; k<9;k++) {
			coord2[k][0] = x -k;
			coord2[k][1] = y;
			
		}
		if(tab.tableau[x2][y2] == 0) {
		for(int i=0; i<8;i++) {
		if(((x2 == coord[i][0])&&(y2 ==coord[i][1]))||((x2 == coord2[i][0])&&(y2 ==coord2[i][1]))){
					
				tab.tableau[x2][y2] = tab.tableau[x][y];
				tab.tableau[x][y] = 0;
				break;
				
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

