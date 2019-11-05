/**
 * 
 */
package p;

import java.awt.Point;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.awt.Image;
import javax.swing.JPanel;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import javax.imageio.ImageIO;

/**
 * @author joachim
 *
 */
public class MouseClass implements MouseListener{
	
	Panneau panneau ;
	int checkC;
	int checkL;
	int c ;
	String coul ;
	int checkCRoi[]= new int[10];
	int checkLRoi[] = new int[10];
	String piece = "";
	int cRoi[][]=new int[0][8];
		public MouseClass(Panneau panneau){
			this.panneau = panneau;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(piece == "") {
			System.out.println(piece);
			if(x<50 || y<50 || x>500 || y>500) {
				System.out.println("ce n est pas une case...");
			}else {
	        System.out.println("les coordonnées sont : "+x + " " + y);
	        int col = ((x-50)/50)+1;
			int ligne = ((y-50)/50)+1;
				System.out.println("cln n* " +  col + " ligne n* "  + ligne);
				Graphics graph = panneau.getGraphics();
			    graph.setColor(Color.red);
				for(int i = 0 ; i<panneau.caseDuTableau.length;i++) {
					if(panneau.caseDuTableau[i].type == "pion") {
						Pion o = (Pion) panneau.caseDuTableau[i].obj;
						if(o.axex == col && o.axey == ligne) {
							System.out.println("pion cln " + col + " ligne " + ligne);
								if(o.couleur=="N") {
									if(col+o.tableauN[0]<10 &&col+o.tableauN[0]>0 && ligne+o.tableauN[1]<10 && ligne+o.tableauN[1]>0) {
										graph.drawRect((col+o.tableauN[0])*50, (ligne+o.tableauN[1])*50, 50, 50);
										checkC = (col+o.tableauN[0])*50 ;
										checkL = (ligne+o.tableauN[1])*50;
										c = panneau.caseDuTableau[i].compteur;
										coul = o.couleur;
										piece = "pion";
									}else {
										//transfo derniere ligne
									}
								}else{
									if(col+o.tableauB[0]<10 &&col+o.tableauB[0]>0 && ligne+o.tableauB[1]<10 && ligne+o.tableauB[1]>0) {
										checkC = (col+o.tableauB[0])*50 ;
										checkL = (ligne+o.tableauB[1])*50;
										graph.drawRect((col+o.tableauB[0])*50, (ligne+o.tableauB[1])*50, 50, 50);
										c = panneau.caseDuTableau[i].compteur;
										coul = o.couleur;
										piece = "pion";
									}else {
										//transfo derniere ligne
									}
								}
						}
					}else if(panneau.caseDuTableau[i].type == "roi") {
						Roi o = (Roi) panneau.caseDuTableau[i].obj;
						if(o.axex == col && o.axey == ligne) {
							System.out.println("roi cln " + col + " ligne " + ligne);
							int cmpt = 0;
							piece= "roi";
							c = panneau.caseDuTableau[i].compteur;
							coul = o.couleur;
								for(int j = 0;j<o.tableau.length;j++) {
									if(col+o.tableau[j][0]<10 && col+o.tableau[j][0]>0 && ligne+o.tableau[j][1]<10 && ligne+o.tableau[j][1]>0) {
										int nextC = col+o.tableau[j][0];
										int nextL = ligne+o.tableau[j][1];
										int caseA = ((nextL)-1)*9-1+nextC;
								    	if(trouvePieceCouleur(panneau.caseDuTableau[caseA]) != coul ) {
										graph.drawRect((col+o.tableau[j][0])*50,(ligne+o.tableau[j][1])*50, 50, 50);
											checkCRoi[cmpt] = (col+o.tableau[j][0])*50 ;
											checkLRoi[cmpt] = (ligne+o.tableau[j][1])*50;
											cmpt++;
								    	}
									}
								}
						}
					}else if(panneau.caseDuTableau[i].type == "gold") {
						Gold o = (Gold) panneau.caseDuTableau[i].obj;
						if(o.axex == col && o.axey == ligne) {
							System.out.println("gold cln " + col + " ligne " + ligne);
							piece= "gold";
							int cmpt = 0;
							if(o.couleur=="N") {
								for(int j = 0;j<o.tableauN.length;j++) {
									if(col+o.tableauN[j][0]<10 && col+o.tableauN[j][0]>0 && ligne+o.tableauN[j][1]<10 && ligne+o.tableauN[j][1]>0) {
										int nextC = col+o.tableauN[j][0];//a completer
										int nextL = ligne+o.tableauN[j][1];
										int caseA = ((nextL)-1)*9-1+nextC;
								    	if(trouvePieceCouleur(panneau.caseDuTableau[caseA]) != coul ) {
											graph.drawRect((col+o.tableauN[j][0])*50,(ligne+o.tableauN[j][1])*50, 50, 50);
											checkCRoi[cmpt] = (col+o.tableauN[j][0])*50 ;
											checkLRoi[cmpt] = (ligne+o.tableauN[j][1])*50;
											c = panneau.caseDuTableau[i].compteur;
											coul = o.couleur;
											cmpt++;
								    	}
									}else {
										//transfo
									}
								}
							}else {
								for(int j = 0;j<o.tableauB.length;j++) {
									if(col+o.tableauB[j][0]<10 && col+o.tableauB[j][0]>0 && ligne+o.tableauB[j][1]<10 && ligne+o.tableauB[j][1]>0) {
										int nextC = col+o.tableauB[j][0];
										int nextL = ligne+o.tableauB[j][1];
										System.out.println(nextC);
										int caseA = ((nextL)-1)*9-1+nextC;
								    	System.out.println(caseA);
								    	if(trouvePieceCouleur(panneau.caseDuTableau[caseA]) != coul ) {
												graph.drawRect((col+o.tableauB[j][0])*50,(ligne+o.tableauB[j][1])*50, 50, 50);
												checkCRoi[cmpt] = (col+o.tableauB[j][0])*50 ;
												checkLRoi[cmpt] = (ligne+o.tableauB[j][1])*50;
												c = panneau.caseDuTableau[i].compteur;
												coul = o.couleur;
												cmpt++;
										}
									}else {
										//transfo
									}
								}
							}
						}
					}
					
					
					
					
					
				}
			}
		}else if(piece == "roi"){
			Point p = e.getPoint();
			int xm = p.x/50;
			int ym = p.y/50;
			Roi roi = (Roi)panneau.caseDuTableau[c].obj;
			int roiAvantX = roi.axex;
			int roiAvantY = roi.axey;
			Graphics graphi = panneau.getGraphics();
			graphi.setColor(Color.black);
			for(int i = 0;i<checkCRoi.length;i++) {
				if(checkLRoi[i]!=0) {
					graphi.clearRect(checkCRoi[i], checkLRoi[i], 51, 51);
					int somme = (checkLRoi[i] + checkCRoi[i]-50)/50;
			    	if(somme % 2 != 0) {
				    	graphi.drawRect(checkCRoi[i] ,checkLRoi[i] , 51,51);
			    	}else {
				    	graphi.fillRect(checkCRoi[i],checkLRoi[i], 51,51);
			    	}
			    	if(xm == checkCRoi[i]/50 && ym == checkLRoi[i]/50){
			    		
				    		checkC = checkCRoi[i];
					    	checkL = checkLRoi[i];
					    	System.out.println(c);
					    	panneau.caseDuTableau[c] = new Case(c,roiAvantX , roiAvantY, null, "vide");
					    	int caseA = ((checkL/50)-1)*9-1+checkC/50;
					    	System.out.println(caseA);
					    	if(coul=="N") {
					    	panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Roi(checkC/50,(checkL/50) , "N") , "roi");
					    	}else {
						    panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Roi(checkC/50,(checkL/50) , "B") , "roi");
					    	}
			    	}
			    	
				}
			}
			remiseEnForme(panneau,c,graphi,checkC,checkL);
			if(checkC!=0 && checkL!=0){
			try {
			      Image img = ImageIO.read(new File("roi.jpg"));
			      graphi.drawImage(img, (checkC), (checkL),50,50,panneau);
			   } catch (IOException error) {
			      error.printStackTrace();
			   }
			graphi.clearRect(roiAvantX*50, roiAvantY*50, 51, 51);
				if((roiAvantX+roiAvantY-1) %2 == 0) {
					graphi.fillRect(roiAvantX*50,roiAvantY*50, 51,51);
				}
			}
			checkCRoi= new int[10];
			checkLRoi= new int[10];
			checkC = 0;
			checkL = 0;
			piece = "";
		}else if(piece=="pion"){
			piece = "";
				Point p = e.getPoint();
				int xm = p.x/50;
				int ym = p.y/50;
				Graphics graphi = panneau.getGraphics();
				graphi.clearRect(checkC, checkL, 51, 51);
		    	graphi.setColor(Color.black);	
		    	int som = (checkL + checkC)/50;
		    	remiseEnFormePion(panneau,graphi,checkC,checkL, coul , c);
				if(xm != checkC/50 || ym != checkL/50){
			    	checkC = 0;
			    	checkL = 0;
			    }else {
					if(coul=="N"){
						graphi.clearRect(checkC, checkL-50, 51, 51);
				    	int somme = (checkL + checkC-50)/50;
				    	if(somme % 2 == 0) {
					    	graphi.drawRect(checkC,checkL-50 , 51,51);
				    	}else {
					    	graphi.fillRect(checkC,checkL-50 , 51,51);
				    	}
				    	panneau.caseDuTableau[c] = new Case(c,checkC/50 , (checkL/50)-1 , null, "vide");
				    	panneau.caseDuTableau[c+9] = new Case(c+9 ,checkC/50 , (checkL/50) , new Pion(checkC/50,(checkL/50) , "N"), "pion");
						try {
						      Image img = ImageIO.read(new File("pion.png"));
						      graphi.drawImage(img, (checkC)-25, (checkL)-20,100,100,panneau);
						   } catch (IOException error) {
						      error.printStackTrace();
						   }
						checkC = 0;
				    	checkL = 0;
					}else {
						graphi.clearRect(checkC, checkL+50, 51, 51);
				    	int somme = (checkL + checkC+50)/50;
					    	if(somme % 2 == 0) {
						    	graphi.drawRect(checkC,checkL+50 , 51,51);
					    	}else {
						    	graphi.fillRect(checkC,checkL+50 , 51,51);
					    	}
				    	panneau.caseDuTableau[c] = new Case(c,checkC/50 , (checkL/50)+1 , null,"vide");
				    	panneau.caseDuTableau[c-9] = new Case(c-9 ,checkC/50 , (checkL/50) , new Pion(checkC/50,(checkL/50) , "B"), "pion");
						try {
						      Image img = ImageIO.read(new File("pion.png"));
						      graphi.drawImage(img, (checkC)-25, (checkL)-20,100,100,panneau);
						   } catch (IOException error) {
						      error.printStackTrace();
						   }
						checkC = 0;
				    	checkL = 0;
					}
				}
			}else if(piece=="gold") {
				Point p = e.getPoint();
				int xm = p.x/50;
				int ym = p.y/50;
				Gold gold = (Gold)panneau.caseDuTableau[c].obj;
				int goldAvantX = gold.axex;
				int goldAvantY =gold.axey;
				Graphics graphi = panneau.getGraphics();
				graphi.setColor(Color.black);
				for(int i = 0;i<checkCRoi.length;i++) {
					if(checkLRoi[i]!=0) {
						graphi.clearRect(checkCRoi[i], checkLRoi[i], 51, 51);
						int somme = (checkLRoi[i] + checkCRoi[i]-50)/50;
				    	if(somme % 2 != 0) {
					    	graphi.drawRect(checkCRoi[i] ,checkLRoi[i] , 51,51);
				    	}else {
					    	graphi.fillRect(checkCRoi[i],checkLRoi[i], 51,51);
				    	}
				    	if(xm == checkCRoi[i]/50 && ym == checkLRoi[i]/50){
						    	checkC = checkCRoi[i];
						    	checkL = checkLRoi[i];
						    	panneau.caseDuTableau[c] = new Case(c,checkC/50 , (checkL/50)-1 , null,"vide");
						    	int caseA = ((checkL/50)-1)*9-1+checkC/50;
						    	System.out.println(caseA);
						    	if(coul=="N") {
						    	panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , "N"),"gold" );
						    	}else {
							    panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , "B"),"gold" );
						    	}
					    	
				    	}
					}
				}
				remiseEnForme(panneau,c,graphi,checkC,checkL);
				if(checkC!=0 && checkL!=0) {
					try {
					      Image img = ImageIO.read(new File("th.jpg"));
					      graphi.drawImage(img, (checkC), (checkL),50,50,panneau);
					   } catch (IOException error) {
					      error.printStackTrace();
					   }
					graphi.clearRect(goldAvantX*50, goldAvantY*50, 51, 51);
					if((goldAvantX+goldAvantY-1) %2 == 0) {
						graphi.fillRect(goldAvantX*50,goldAvantY*50, 51,51);
					}
				}
				checkCRoi= new int[10];
				checkLRoi= new int[10];
				checkC = 0;
				checkL = 0;
				piece = "";
			}
		}
	
        
        
		    
	
	
	
	public void remiseEnFormePion(Panneau pan ,Graphics g , int checkCol, int checkLigne,String  couleur, int compteur) {
		int som = (checkLigne + checkCol)/50;
		if(couleur=="N") {
	    	if(pan.caseDuTableau[compteur+9].obj == null) {
		    	if(som % 2 == 0) {
			    	g.drawRect(checkCol,checkLigne,51,51);
		    	}else {
			    	g.fillRect(checkCol,checkLigne,51,51);
		    	}
	    	}else {
	    		if(som % 2 == 0) {
			    	g.drawRect(checkCol,checkLigne,51,51);
			    	try {
					      Image img = ImageIO.read(new File("pion.png"));
					      g.drawImage(img, (checkCol)-25, (checkLigne)-20,100,100,pan);
					   } catch (IOException error) {
					      error.printStackTrace();
					   }
		    	}else {
			    	g.fillRect(checkCol,checkLigne,51,51);
			    	try {
					      Image img = ImageIO.read(new File("pion.png"));
					      g.drawImage(img, (checkCol)-25, (checkLigne)-20,100,100,pan);
					   } catch (IOException error) {
					      error.printStackTrace();
					   }
		    	}
	    	}
    	}else if(couleur == "B") {
    		if(pan.caseDuTableau[compteur-9].obj == null) {
		    	if(som % 2 == 0) {
			    	g.drawRect(checkCol,checkLigne,51,51);
		    	}else {
			    	g.fillRect(checkCol,checkLigne,51,51);
		    	}
	    	}else {
	    		if(som % 2 == 0) {
			    	g.drawRect(checkCol,checkLigne,51,51);
			    	try {
					      Image img = ImageIO.read(new File("pion.png"));
					      g.drawImage(img, (checkCol)-25, (checkLigne)-20,100,100,pan);
					   } catch (IOException error) {
					      error.printStackTrace();
					   }
		    	}else {
			    	g.fillRect(checkCol,checkLigne,51,51);
			    	try {
					      Image img = ImageIO.read(new File("pion.png"));
					      g.drawImage(img, (checkCol)-25, (checkLigne)-20,100,100,pan);
					   } catch (IOException error) {
					      error.printStackTrace();
					   }
		    	}
	    	}
    	}
	}

	
	public void remiseEnForme(Panneau pan,int c, Graphics dess,int col,int ligne) {
		int n=0;
		for(int i= 0;i<8;i++) {
			switch(i) {
			case 0:
				n = c+1;
				break;
			case 1:
				n = c-1;
				break;
			case 2:
				n= c+8;
				break;
			case 3:
				n= c+9;
				break;
			case 4:
				n= c+10;
				break;
			case 5:
				n= c-8;
				break;
			case 6:
				n= c-9;
				break;
			case 7:
				n= c-10;
				break;
			default:
				System.out.println("erreur");
				break;
			}
			if(n>=0 && n<=81) {
				System.out.println(n);
				if(panneau.caseDuTableau[n].x!=col && panneau.caseDuTableau[n].y!=ligne &&panneau.caseDuTableau[n].type != "vide") {
				remiseEnFormePremier(pan,dess,n);
				}
			}
		}
	}
	
	public void remiseEnFormePremier(Panneau pan, Graphics dess,int nombre) {
		if(panneau.caseDuTableau[nombre].type == "pion") {
			Pion p = (Pion)panneau.caseDuTableau[nombre].obj;
			try {
			      Image img = ImageIO.read(new File("pion.png"));
			      dess.drawImage(img, (p.axex*50), (p.axey*50),50,50,pan);
			   } catch (IOException error) {
			      error.printStackTrace();
			   }
    	}else if(panneau.caseDuTableau[nombre].type == "roi") {
    		Roi r = (Roi)panneau.caseDuTableau[nombre].obj;
    		try {
			      Image img = ImageIO.read(new File("roi.jpg"));
			      dess.drawImage(img, (r.axex*50), (r.axey*50),50,50,pan);
			   } catch (IOException error) {
			      error.printStackTrace();
			   }
    	}else if(panneau.caseDuTableau[nombre].type == "gold"){
    		Gold g = (Gold)panneau.caseDuTableau[nombre].obj;
    		try {
			      Image img = ImageIO.read(new File("th.jpg"));
			      dess.drawImage(img, (g.axex*50), (g.axey*50),50,50,pan);
			   } catch (IOException error) {
			      error.printStackTrace();
			   }
    	}
	}
	
	
	public String trouvePieceCouleur(Case c) {
		if(c.type == "pion") {
			Pion p = (Pion) c.obj;
			return p.couleur;
		}else if(c.type == "roi") {
			Roi r = (Roi) c.obj;
			return r.couleur;
		}else if(c.type == "gold") {
			Gold g = (Gold) c.obj;
			return g.couleur;
		}else {
			return "vide";
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	

}
