/**
 * 
 */
package modele;

/**
 * @author Tekadam Tresor Ruphin
 *
 */
public class Plateau {

	private int tabLength =9;
	private int tabWidth =9;
	public char [][] tableau;
	public char [] piece = {'L','C','S','G','R','F','T','P'};
	public char [] piece2 = {'l','c','s','g','r','f','t','p'};
	
	
	
	/**
	 * cette methode va disposer les pieces dans les cases
	 * met chaque element de notre table piece et piece2 dans une case
	 */
	public Plateau() {
		tableau =  new char [tabLength][tabWidth];
		for(int i=2;i<9;i+=4) {
			for(int j=0;j<9;j++) {
				if(i ==2) {
		tableau[i][j] = piece[7];
			}else {
				tableau[i][j] = piece2[7];
			}
			}
		}
		
		for(int i =0; i<9;i+=8) {
			int k=9;
		for(int j=0;j<9;j++) {
			if( i ==0) {
				k --;
				if(j <5) {
					tableau[i][j] =piece[j];
				}else if((j>=5)&&(j<8)){
					tableau[i][j] = piece[k];
				}else {
					tableau[i][j] = piece[2];
						}
				}else {
					k --;
					if(j <5) {
						tableau[i][j] =piece2[j];
					}else if((j>=5)&&(j<8)){
						tableau[i][j] = piece2[k];
					}else {
						tableau[i][j] = piece2[2];
				}
		}
		
		}
		}
	
		tableau[1][1] = piece[5];
		tableau[1][7] = piece[6];

		tableau[7][1] = piece2[5];
		tableau[7][7] = piece2[6];
		
		
		}	
				
		
	//Pour la mise en forme de notre tableau	
		public void afficher() {
			for(int i=0;i<9;i++){
				System.out.print("   "+i);
				}
			System.out.println();
			System.out.println();
			System.out.println(" -------------------------------------");
			for(int i = 0;i<tabLength;i++) {
				for(int j=0;j <tabWidth;j++) {
					
					System.out.print(" | "+ tableau[i][j]);
				}
				
				System.out.print(" | ");
				System.out.println(" "+ i);
				System.out.println(" -------------------------------------");
			}
		
		
	System.out.println();

		}
		

	}


