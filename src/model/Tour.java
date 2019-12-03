package model;

import java.util.Observable;

public class Tour extends Observable{
	
	
Plateau tab = new Plateau();
	
	public void  tour(int x,int y,int x2,int y2) {
		int k = 9,z =k+1,m =0;
		int [][] coord = new int [17][2]; 
		
	for(int i=x+1;i<9;i++) {
		
		coord[i][0] = i; 
		coord[i][1] = y;
		}
	
	for( int i =1; i< x + 1;i++) {
			coord[i][0] = x - i;
			coord[i][1] = y;
			}
		
		for( int i =y+1; i < 9; i++) {
			
			
			
			coord[k][0] = x;
			coord[k][1] = i;
			k++;
		}
		
		for( int i =1; i<y+1; i++) {
			
			coord[z][0] = x;
			coord[z][1] = y -i;
			z++;
		}
		
		
		
		if(tab.tableau[x2][y2] == 0) {
		for(int i=0; i<k+z;i++) {
		if((x2 == coord[i][0])&&(y2 ==coord[i][1])){
					
				tab.tableau[x2][y2] = tab.tableau[x][y];
				tab.tableau[x][y] = 0;
				break;
				
				}
			}
			
			
		}else {
			for(int i =0; i<k+z;i++) {
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
