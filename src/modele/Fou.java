package modele;

public class Fou {

Plateau tab = new Plateau();
	
	public void  fou(int x,int y,int x2,int y2) {
		int b =0,l =0,k = 9,z =k+1,m =0;
		int [][] coord = new int [17][2]; 
		
	for(int i=x+1;i<9;i++) {
		b++;
		coord[i][0] = i; 
		coord[i][1] = y +b;
		if(coord[i][1] == 8)
		break;
		}
	
	for( int i =1; i< x + 1;i++) {
			coord[i][0] = x - i;
			coord[i][1] = y - i;
		}
		
		for( int i =y+1; i < 9; i++) {
			l++;
			
			
			coord[k][0] = x-l;
			coord[k][1] = i;
			k++;
			if( l == x ) {
				break;
			}
			
		}
		
		for( int i =x+1; i<9; i++) {
			m++;
			coord[z][0] = i;
			coord[z][1] = y -m;
			z++;
			if(m == y) {
				break;
			}
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
		
	}
}
