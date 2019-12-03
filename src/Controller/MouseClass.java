/**
 * 
 */
package Controller;
import p.*;
import Vue.*;
import java.awt.Point;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import java.util.TimerTask;
import java.util.Observable;
import java.util.Timer;

import javax.imageio.ImageIO;



/**
 * @author joachim
 *
 */
public class MouseClass extends Observable implements MouseListener{
	
	
	 public int compteurClick=0;
	 public Timer timer = new Timer(true);
	 public TimerTask timerTask;
	 public int compteurN=0;
	 public int compteurB=0;
	 public static int lastChange[] = new int[2];
	
	Panneau panneau ;
	int checkC;
	int checkL;
	int c ;
	String coul ;
	int checkCRoi[]= new int[50];
	int checkLRoi[] = new int[50];
	String piece = "";
	
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
				//System.out.println("ce n est pas une case...");
			}else {
	        //System.out.println("les coordonnées sont : "+x + " " + y);
	        int col = ((x-50)/50)+1;
			int ligne = ((y-50)/50)+1;
				//System.out.println("cln n* " +  col + " ligne n* "  + ligne);
				Graphics graph = panneau.getGraphics();
			    graph.setColor(Color.red);
				for(int i = 0 ; i<panneau.caseDuTableau.length;i++) {
					if(panneau.caseDuTableau[i].type == "pion") {
						Pion o = (Pion) panneau.caseDuTableau[i].obj;
						affichagePossibilite(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"pion",0);
					}else if(panneau.caseDuTableau[i].type == "roi") {
						Roi o = (Roi) panneau.caseDuTableau[i].obj;
						affichagePossibilite(col,ligne,o.axex,o.axey ,o.tableau,o.tableau,graph,i,o.couleur,"roi",0);
					}else if(panneau.caseDuTableau[i].type == "gold") {
						Gold o = (Gold) panneau.caseDuTableau[i].obj;
						affichagePossibilite(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"gold",0);
					}else if(panneau.caseDuTableau[i].type == "silver") {
						Silver o = (Silver) panneau.caseDuTableau[i].obj;
						affichagePossibilite(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"silver",0);
					}else if(panneau.caseDuTableau[i].type == "cavalier") {
						Cavalier o = (Cavalier) panneau.caseDuTableau[i].obj;
						affichagePossibilite(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"cavalier",0);
					}else if(panneau.caseDuTableau[i].type == "lance") {
						Lance o = (Lance) panneau.caseDuTableau[i].obj;
						affichagePossibiliteTE(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"lance",0);
					}else if(panneau.caseDuTableau[i].type == "tour") {
						Tour o = (Tour) panneau.caseDuTableau[i].obj;
						affichagePossibiliteTE(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"tour",0);
					}else if(panneau.caseDuTableau[i].type == "eveque") {
						Eveque o = (Eveque) panneau.caseDuTableau[i].obj;
						affichagePossibiliteTE(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"eveque",0);
					}else if(panneau.caseDuTableau[i].type == "dragon") {
						Dragon o = (Dragon) panneau.caseDuTableau[i].obj;
						affichagePossibiliteTE(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"dragon",0);
						affichagePossibilite(col,ligne,o.axex,o.axey ,o.tableau,o.tableau,graph,i,o.couleur,"dragon",trouveDernierBlock(checkCRoi));
					}else if(panneau.caseDuTableau[i].type == "cheval") {
						Cheval o = (Cheval) panneau.caseDuTableau[i].obj;
						affichagePossibiliteTE(col,ligne,o.axex,o.axey ,o.tableauN,o.tableauB,graph,i,o.couleur,"cheval",0);
						affichagePossibilite(col,ligne,o.axex,o.axey ,o.tableau,o.tableau,graph,i,o.couleur,"cheval",trouveDernierBlock(checkCRoi));
					}
					
					
					
					
					
				}
			}
		}else if(piece == "roi"){
			Roi roi = (Roi)panneau.caseDuTableau[c].obj;
			Deplacement( e,roi.axex,roi.axey,"roi");
		}else if(piece=="pion"){
			Pion pion = (Pion)panneau.caseDuTableau[c].obj;
			Deplacement( e,pion.axex,pion.axey,"pion");
			}else if(piece=="gold") {
				Gold gold = (Gold)panneau.caseDuTableau[c].obj;
				Deplacement( e,gold.axex,gold.axey,"gold");
			}else if(piece=="silver") {
				Silver silver = (Silver)panneau.caseDuTableau[c].obj;
				Deplacement( e,silver.axex,silver.axey,"silver");
			}else if(piece=="cavalier") {
				Cavalier cavalier = (Cavalier)panneau.caseDuTableau[c].obj;
				Deplacement( e,cavalier.axex,cavalier.axey,"cavalier");
			}else if(piece=="lance") {
				Lance lance = (Lance)panneau.caseDuTableau[c].obj;
				Deplacement( e,lance.axex,lance.axey,"lance");
			}else if(piece=="tour") {
				Tour tour = (Tour)panneau.caseDuTableau[c].obj;
				Deplacement( e,tour.axex,tour.axey,"tour");
			}else if(piece=="eveque") {
				Eveque eveque = (Eveque)panneau.caseDuTableau[c].obj;
				Deplacement( e,eveque.axex,eveque.axey,"eveque");
			}else if(piece=="dragon") {
				Dragon dragon = (Dragon)panneau.caseDuTableau[c].obj;
				Deplacement( e,dragon.axex,dragon.axey,"dragon");
			}else if(piece=="cheval") {
				Cheval cheval = (Cheval)panneau.caseDuTableau[c].obj;
				Deplacement( e,cheval.axex,cheval.axey,"cheval");
			}
		}

	
	public void remiseEnFormePremier(Panneau pan, Graphics dess,int nombre) {
		if(panneau.finDePartie=="") {
		if(nombre>=0 && nombre<81) {
			if(panneau.caseDuTableau[nombre].type == "pion") {
				Pion p = (Pion)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("pion",p.axex*50,p.axey*50,dess,pan,p.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "roi") {
	    		Roi r = (Roi)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("roi",r.axex*50,r.axey*50,dess,pan,r.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "gold"){
	    		Gold g = (Gold)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("gold",g.axex*50,g.axey*50,dess,pan,g.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "silver"){
	    		Silver s = (Silver)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("silver",s.axex*50,s.axey*50,dess,pan,s.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "cavalier"){
	    		Cavalier c = (Cavalier)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("cavalier",c.axex*50,c.axey*50,dess,pan,c.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "lance"){
	    		Lance l = (Lance)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("lance",l.axex*50,l.axey*50,dess,pan,l.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "tour"){
	    		Tour t = (Tour)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("tour",t.axex*50,t.axey*50,dess,pan,t.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "eveque"){
	    		Eveque e = (Eveque)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("eveque",e.axex*50,e.axey*50,dess,pan,e.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "dragon"){
	    		Dragon e = (Dragon)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("dragon",e.axex*50,e.axey*50,dess,pan,e.couleur);
	    	}else if(panneau.caseDuTableau[nombre].type == "cheval"){
	    		Cheval e = (Cheval)panneau.caseDuTableau[nombre].obj;
	    		dessinConditon("cheval",e.axex*50,e.axey*50,dess,pan,e.couleur);
	    	}
		}
		}
	}
	public void finPartie(int c,Panneau pan,Graphics g) {
		if(pan.caseDuTableau[c].type == "roi") {
    		Roi r = (Roi) pan.caseDuTableau[c].obj;
    		Font font = new Font("Courier", Font.BOLD, 15);
		    g.setFont(font);
		    g.drawString("fin de partie",500,480);
    		if(r.couleur == "B") {
    		System.out.println("fin de partie les Noirs gagnent");
    		panneau.finDePartie="N";
    		}else{
	    	System.out.println("fin de partie les Blancs gagnent ");
	    	panneau.finDePartie="B";
    		}
    	}else if(pan.caseDuTableau[c].type == "pion") {
    		Pion p =  (Pion)pan.caseDuTableau[c].obj;
    		if(p.couleur=="B") {
    		dessinConditon("pion",500 ,50 + compteurB,g,pan,p.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("pion",600,50 + compteurN,g,pan,p.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "gold") {
    		Gold gold =  (Gold)pan.caseDuTableau[c].obj;
    		if(gold.couleur=="B") {
    		dessinConditon("gold",500,50 + compteurB,g,pan,gold.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("gold",600,50 + compteurN,g,pan,gold.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "silver") {
    		Silver silver =  (Silver)pan.caseDuTableau[c].obj;
    		if(silver.couleur=="B") {
    		dessinConditon("silver",500,50 + compteurB,g,pan,silver.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("silver",600,50 + compteurN,g,pan,silver.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "cavalier") {
    		Cavalier cavalier =  (Cavalier)pan.caseDuTableau[c].obj;
    		if(cavalier.couleur=="B") {
    		dessinConditon("cavalier",500,50 + compteurB,g,pan,cavalier.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("cavalier",600,50 + compteurN,g,pan,cavalier.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "lance") {
    		Lance lance =  (Lance)pan.caseDuTableau[c].obj;
    		if(lance.couleur=="B") {
    		dessinConditon("lance",500,50 + compteurB,g,pan,lance.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("lance",600 ,50 + compteurN,g,pan,lance.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "tour") {
    		Tour tour =  (Tour)pan.caseDuTableau[c].obj;
    		if(tour.couleur=="B") {
    		dessinConditon("tour",500,50 + compteurB,g,pan,tour.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("tour",600,50 + compteurN,g,pan,tour.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "eveque") {
    		Eveque eveque =  (Eveque)pan.caseDuTableau[c].obj;
    		if(eveque.couleur=="B") {
    		dessinConditon("eveque",500 ,50 + compteurB,g,pan,eveque.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("eveque",600,50 + compteurN,g,pan,eveque.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "dragon") {
    		Dragon dragon =  (Dragon)pan.caseDuTableau[c].obj;
    		if(dragon.couleur=="B") {
    		dessinConditon("dragon",500 ,50 + compteurB,g,pan,dragon.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("dragon",600,50 + compteurN,g,pan,dragon.couleur);
        	compteurN+=50;
    		}
    	}else if(pan.caseDuTableau[c].type == "cheval") {
    		Cheval cheval =  (Cheval)pan.caseDuTableau[c].obj;
    		if(cheval.couleur=="B") {
    		dessinConditon("cheval",500 ,50 + compteurB,g,pan,cheval.couleur);
            compteurB+=50;
    		}else {
        	dessinConditon("cheval",600,50 + compteurN,g,pan,cheval.couleur);
        	compteurN+=50;
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
		}else if(c.type == "silver") {
			Silver g = (Silver) c.obj;
			return g.couleur;
		}else if(c.type == "cavalier") {
			Cavalier g = (Cavalier) c.obj;
			return g.couleur;
		}else if(c.type == "lance") {
			Lance g = (Lance) c.obj;
			return g.couleur;
		}else if(c.type == "tour") {
			Tour g = (Tour) c.obj;
			return g.couleur;
		}else if(c.type == "eveque") {
			Eveque g = (Eveque) c.obj;
			return g.couleur;
		}else if(c.type == "dragon") {
			Dragon g = (Dragon) c.obj;
			return g.couleur;
		}else if(c.type == "cheval") {
			Cheval g = (Cheval) c.obj;
			return g.couleur;
		}else   {
			return "vide";
		}
	}
	
	
	public void dessinConditon(String titre, int col,int ligne,Graphics graph,Panneau pan,String couleur) {
		if(couleur=="B") {
			String s= titre+".png";
			try {
			      Image img = ImageIO.read(new File(s));
			      graph.drawImage(img, (col), (ligne),50,50,pan);
			   } catch (IOException error) {
			      error.printStackTrace();
			   }
		}else {
			String s= titre+"N.png";
			try {
			      Image img = ImageIO.read(new File(s));
			      graph.drawImage(img, (col), (ligne),50,50,pan);
			   } catch (IOException error) {
			      error.printStackTrace();
			   }
		}
	}
	
	
	public void affichagePossibilite(int col,int ligne,int axeX,int axeY,int tableauN[][],int tableauB[][],Graphics graph,int i,String couleur,String p,int start) {
		if(panneau.finDePartie=="") {
		if(axeX== col && axeY == ligne) {
			//System.out.println(p+" cln " + col + " ligne " + ligne);
			if(couleur=="N") {
				if(panneau.alternance==1) {
					piece= p;
					int cmpt = 0 + start;
						for(int j = 0;j<tableauN.length;j++) {
							if(col+tableauN[j][0]<10 && col+tableauN[j][0]>0 && ligne+tableauN[j][1]<10 && ligne+tableauN[j][1]>0) {
								int nextC = col+tableauN[j][0];
								int nextL = ligne+tableauN[j][1];
								int caseA = ((nextL)-1)*9-1+nextC;
						    	if(trouvePieceCouleur(panneau.caseDuTableau[caseA]) != "N" ) {
									graph.drawRect((col+tableauN[j][0])*50,(ligne+tableauN[j][1])*50, 50, 50);
									checkCRoi[cmpt] = (col+tableauN[j][0])*50 ;
									checkLRoi[cmpt] = (ligne+tableauN[j][1])*50;
									c = panneau.caseDuTableau[i].compteur;
									coul = couleur;
									cmpt++;
						    	}
							}
						}
				}
			}else {
				if(panneau.alternance==0) {
					piece= p;
					int cmpt = 0 + start;
					for(int j = 0;j<tableauB.length;j++) {
						if(col+tableauB[j][0]<10 && col+tableauB[j][0]>0 && ligne+tableauB[j][1]<10 && ligne+tableauB[j][1]>0) {
							int nextC = col+tableauB[j][0];
							int nextL = ligne+tableauB[j][1];
							int caseA = ((nextL)-1)*9-1+nextC;
					    	if(trouvePieceCouleur(panneau.caseDuTableau[caseA]) != "B" ) {
								graph.drawRect((col+tableauB[j][0])*50,(ligne+tableauB[j][1])*50, 50, 50);
								checkCRoi[cmpt] = (col+tableauB[j][0])*50 ;
								checkLRoi[cmpt] = (ligne+tableauB[j][1])*50;
								c = panneau.caseDuTableau[i].compteur;
								coul = couleur;
								cmpt++;
					    	}
						}
					}
			}
			}
			testPossibilite();
		}
		}
	}
	public void affichagePossibiliteTE(int col,int ligne,int axeX,int axeY,int tableauN[][][],int tableauB[][][],Graphics graph,int i,String couleur,String p,int start) {
		if(panneau.finDePartie=="") {
		if(axeX == col && axeY == ligne) {
		//System.out.println(p+" cln " + col + " ligne " + ligne);
		if(couleur=="N") {
			if(panneau.alternance==1) {
				piece= p;
				int cmpt = 0+start;
				for(int j = 0;j<tableauN.length;j++) {
				  for(int k = 0;k<tableauN[j].length;k++) {
					if(col+tableauN[j][k][0]<10 && col+tableauN[j][k][0]>0 && ligne+tableauN[j][k][1]<10 && ligne+tableauN[j][k][1]>0) {
						int nextC = col+tableauN[j][k][0];
						int nextL = ligne+tableauN[j][k][1];
						int caseA = ((nextL)-1)*9-1+nextC;
				    	if(trouvePieceCouleur(panneau.caseDuTableau[caseA]) != "N" ) {
							graph.drawRect(nextC*50,nextL*50, 50, 50);
							checkCRoi[cmpt] = nextC*50;
							checkLRoi[cmpt] = nextL*50;
							c = panneau.caseDuTableau[i].compteur;
							coul = couleur;
							cmpt++;
							if(panneau.caseDuTableau[caseA].type!="vide") {
								break;
							}
						}else {
							break;
						}
				    	
					}
				  }
				}
			}
		}else {
			if(panneau.alternance==0) {
				piece= p;
				int cmpt = 0;
				for(int j = 0;j<tableauB.length;j++) {
					for(int k = 0;k<tableauB[j].length;k++) {
						if(col+tableauB[j][k][0]<10 && col+tableauB[j][k][0]>0 && ligne+tableauB[j][k][1]<10 && ligne+tableauB[j][k][1]>0) {
							int nextC = col+tableauB[j][k][0];
							int nextL = ligne+tableauB[j][k][1];
							int caseA = ((nextL)-1)*9-1+nextC;
					    	if(trouvePieceCouleur(panneau.caseDuTableau[caseA]) != "B" ) {
									graph.drawRect((col+tableauB[j][k][0])*50,(ligne+tableauB[j][k][1])*50, 50, 50);
									checkCRoi[cmpt] = nextC*50 ;
									checkLRoi[cmpt] = nextL*50;
									c = panneau.caseDuTableau[i].compteur;
									coul = couleur;
									cmpt++;
									if(panneau.caseDuTableau[caseA].type!="vide") {
										break;
									}
							}else {
								break;
							}
						}
					}
				}
			}
		}
		testPossibilite();
	}
		}
	}
	public void testPossibilite() {
		if(checkCRoi[0]== 0 &&checkLRoi[0]==0) {
			piece="";
		}
	}
	
	
	
	public void Deplacement(MouseEvent e,int axeX,int axeY,String p) {
		String nouvType=p;
		if(panneau.finDePartie=="") {
		if(checkCRoi[0]==0&&checkLRoi[0]==0) {
			piece = "";
		}else {
			Point po = e.getPoint();
			int xm = po.x/50;
			int ym = po.y/50;
			int goldAvantX = axeX;
			int goldAvantY = axeY;
			Graphics graphi = panneau.getGraphics();
			graphi.setColor(Color.black);
			for(int i = 0;i<checkCRoi.length;i++) {
				if(checkCRoi[i]!=0) {
					graphi.clearRect(checkCRoi[i], checkLRoi[i], 51, 51);
					int somme = (checkLRoi[i] + checkCRoi[i]-50)/50;
			    	if(somme % 2 != 0) {
				    	graphi.drawRect(checkCRoi[i] ,checkLRoi[i] , 51,51);
				    	int caseA = ((checkLRoi[i]/50)-1)*9-1+checkCRoi[i]/50;
				    	remiseEnFormePremier(panneau, graphi,caseA);
			    	}else {
				    	graphi.fillRect(checkCRoi[i],checkLRoi[i], 51,51);
				    	int caseA = ((checkLRoi[i]/50)-1)*9-1+checkCRoi[i]/50;
				    	remiseEnFormePremier(panneau, graphi,caseA);
			    	}
			    	if(xm == checkCRoi[i]/50 && ym == checkLRoi[i]/50){
						    	checkC = checkCRoi[i];
						    	checkL = checkLRoi[i];
						    	panneau.caseDuTableau[c] = new Case(c,checkC/50 , (checkL/50)-1 , null,"vide");
						    	lastChange[0] = checkC/50;
						    	lastChange[1] = checkL/50;
						    	int caseA = ((checkL/50)-1)*9-1+checkC/50;
						    	finPartie(caseA,panneau,graphi);
						    	if(coul=="N") {
						    		panneau.alternance=0;
						    		if(ym<=8) {
						    		ajoutDansTableau(p,caseA,checkC,checkL,"N");
						    		}else {
						    			nouvType=ajoutDansTableauPromotion(p,caseA,checkC,checkL,"N");
						    		}
						    		TimeManager(panneau,"N",panneau.restart);
						    		panneau.restart=1;
						        	compteurClick=0;
						    		TimeManager(panneau,"B",panneau.restart);
						    		compteurClick=1;
						    		/*
						    		setChanged();
						    	    notifyObservers();*/
						    	}else {
						    		panneau.alternance=1;
						    		if(ym>=2) {
						    		ajoutDansTableau(p,caseA,checkC,checkL,"B");
						    		}else {
						    			nouvType=ajoutDansTableauPromotion(p,caseA,checkC,checkL,"B");
						    		}
						    		if(compteurClick==1) {
						    		TimeManager(panneau,"B",panneau.restart);
						    		}
						    		
						        	compteurClick=0;
						        	TimeManager(panneau,"N",panneau.restart);
						        	compteurClick=1;
						        	panneau.restart=1;
						        	/*
						        	setChanged();
						            notifyObservers();*/
						   }
			    	}
				}
			}
			if(checkC!=0 && checkL!=0) {
				dessinConditon(nouvType,checkC,checkL,graphi,panneau,coul);
				graphi.clearRect(goldAvantX*50, goldAvantY*50, 51, 51);
				if((goldAvantX+goldAvantY-1) %2 == 0) {
					graphi.fillRect(goldAvantX*50,goldAvantY*50, 51,51);
				}else {
					graphi.drawRect(goldAvantX*50,goldAvantY*50, 51,51);
				}
			}
			if(panneau.finDePartie!="") {
				if(panneau.finDePartie=="N") {
					graphi.setColor(Color.white);
					graphi.fillRect(50, 50, 1000, 1000);
					graphi.setColor(Color.black);
					graphi.drawString("Les Noirs gagnent", 250, 250);
					TimeManager(panneau,"N",panneau.restart);
					compteurClick=0;
					panneau.restart=0;
					setChanged();
		    	    notifyObservers();
				}else {
					graphi.setColor(Color.white);
					graphi.fillRect(50, 50, 1000, 1000);
					graphi.setColor(Color.black);
					graphi.drawString("Les Blancs gagnent", 250, 250);
					TimeManager(panneau,"B",panneau.restart);
					compteurClick=0;
					panneau.restart=0;
					setChanged();
		    	    notifyObservers();
				}
			}
			//Client cli = panneau.c;
			//cli.line="test";
			setChanged();
    	    notifyObservers();
			checkCRoi= new int[50];
			checkLRoi= new int[50];
			checkC = 0;
			checkL = 0;
			piece = "";
			}
		}
	}
	public void ajoutDansTableau(String p,int caseA,int checkC,int checkL,String couleur) {
		if(p=="pion") {
	    panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Pion(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="gold") {
		panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="roi") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Roi(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="silver") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Silver(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="lance") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Lance(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="eveque") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Eveque(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="tour") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Tour(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="cavalier") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Cavalier(checkC/50,(checkL/50) , couleur),p );
		}else if(p=="dragon") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Dragon(checkC/50,(checkL/50) , couleur),"dragon" );
		}else if(p=="cheval") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Cheval(checkC/50,(checkL/50) , couleur),"cheval" );
		}
	}
	
	public String ajoutDansTableauPromotion(String p,int caseA,int checkC,int checkL,String couleur) {
		if(p=="pion") {
	    panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , couleur),"gold" );
		return "gold";
		}else if(p=="gold") {
		panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , couleur),"gold" );
		return "gold";
		}else if(p=="roi") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Roi(checkC/50,(checkL/50) , couleur),p );
			return "roi";
		}else if(p=="silver") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , couleur),"gold" );
			return "gold";
		}else if(p=="lance") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , couleur),"gold" );
			return "gold";
		}else if(p=="eveque") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Cheval(checkC/50,(checkL/50) , couleur),"cheval" );
			return "cheval";
		}else if(p=="tour") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Dragon(checkC/50,(checkL/50) , couleur),"dragon" );
			return "dragon";
		}else if(p=="cavalier") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Gold(checkC/50,(checkL/50) , couleur),"gold" );
			return "gold";
		}else if(p=="dragon") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Dragon(checkC/50,(checkL/50) , couleur),"dragon" );
			return "dragon";
		}else if(p=="cheval") {
			panneau.caseDuTableau[caseA] = new Case(caseA ,checkC/50 , (checkL/50) , new Cheval(checkC/50,(checkL/50) , couleur),"cheval" );
			return "cheval";
		}
		return "";
	}
	
	public int trouveDernierBlock(int l[]) {
		int intTrouve=0;
		for(int i=0;i<l.length;i++) {
			if(l[i]==0) {
				intTrouve=i;
				break;
			}
		}
		return intTrouve;
	}
	public void  TimeManager(Panneau panneau,String couleur,int c) {
		if(compteurClick==0) {
			timerTask = new myTimerTask(panneau,couleur,compteurClick,c);
			timer=new Timer(true);
            timer.schedule(timerTask, 0, 1000);
    	}else {
    		timer.cancel();
    	}
	}

	public void mousePressed(MouseEvent e) {
		
		
	}

	
	public void mouseReleased(MouseEvent e) {
		
		
	}

	
	public void mouseEntered(MouseEvent e) {
		
		
	}


	public void mouseExited(MouseEvent e) {
	
		
	}

	
	
	
	

}
