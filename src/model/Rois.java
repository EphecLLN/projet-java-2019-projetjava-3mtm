package model;

import java.util.Observable;

public class Rois extends Observable{
	
	Plateau tab = new Plateau();
	
public void  rois(int x,int y,int x2,int y2) {
	
	int [][] coord = {{x,y+1},{x-1,y+1},{x,y-1},{x+1,y},{x-1,y},{x+1,y+1},
			{x-1,y-1},{x+1,y-1}};
	if(tab.tableau[x2][y2] == 0) {
	for(int i=0; i<8;i++) {
	if((x2 == coord[i][0])&&(y2 ==coord[i][1])){
				
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
				System.out.println("pas encore implementé");
				
			}	
	
}
}
	tab.afficher();
	setChanged();
    notifyObservers();
	
}
}
