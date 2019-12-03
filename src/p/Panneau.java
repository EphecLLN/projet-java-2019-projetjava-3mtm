package p;
import java.awt.Font;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import Controller.MouseClass;
import model.Plateau;

import java.awt.Image;

import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;

public class Panneau extends JPanel implements Observer{
	int compteurPion = 0;
	public int alternance=0;
	public String finDePartie="";
	public int restart=1;
	//public Server s;
	//public Client c;

	  
	int tableauDepartRoi[][] ={//case de depart des rois
		{9,5},{1,5}
	};
	int tableauDepartGold[][] ={//case de depart des golds
			{9,6},{9,4},{1,4},{1,6}
		};
	int tableauDepartSilver[][] ={//case de depart des silvers
			{9,7},{9,3},{1,3},{1,7}
		};
	int tableauDepartCavalier[][] ={//case de depart des cavaliers
			{9,8},{9,2},{1,2},{1,8}
		};
	int tableauDepartLance[][] ={//case de depart des lances
			{9,9},{9,1},{1,1},{1,9}
		};
	int tableauDepartTour[][] ={//case de depart des lances
			{8,7},{2,3}
		};
	int tableauDepartEveque[][] ={//case de depart des lances
			{2,7},{8,3}
		};
	int tableauDepart[][] = {//case de depart des pions
		    {3 , 1},
		    {3 , 2},
		    {3 , 3},
		    {3 , 4},
		    {3 , 5},
		    {3 , 6},
		    {3 , 7},
		    {3 , 8},
		    {3 , 9},
		    {7 , 1},
		    {7 , 2},
		    {7 , 3},
		    {7 , 4},
		    {7 , 5},
		    {7 , 6},
		    {7 , 7},
		    {7 , 8},
		    {7 , 9}
	};
	public static Case caseDuTableau[] = new Case[81];//tableau contenant toutes les cases
	  public void paintComponent(Graphics g){
		  //s= new Server(6666);
		  //c= new Client("127.0.0.1",6666);
		  Font font = new Font("Courier", Font.BOLD, 30);
		    g.setFont(font);
		    g.setColor(Color.black);    
		    g.drawString("Shogi", 50, 40);
		    init(g);
	  }
	  
	//dessine l image
	  public void dessin(String image,int col,int ligne,Graphics dess) {
				  try {
				      Image img = ImageIO.read(new File(image));
				      dess.drawImage(img, ((col)*50), ((ligne)*50),50,50, this);
				    } catch (IOException e) {
				      e.printStackTrace();
				    }
		  }
	  
	
	  
	  public void init(Graphics g) {
		  restart=0;
		  alternance=0;
		  finDePartie="";
		    g.setColor(Color.white);  
			g.fillRect(50, 50, 700, 600);
			g.setColor(Color.black);  
		    int compteur = 0;
		  for(int i = 0; i<9 ; i++) {//boucle cases horizontales
			  for(int j = 0 ; j<9 ; j++) {//boucle cases verticales
				  compteurPion = 0;
				  if(compteur%2 != 0 ) {//case blanches ou noires
					  g.fillRect((j+1)*50, (i+1)*50, 50, 50);//blanches
				  }else {
					  g.drawRect((j+1)*50, (i+1)*50, 50, 50);//noires
				  }
				  for(int k = 0 ; k < tableauDepart.length ; k++) {//boucle cases pions
					  if(i+1 == tableauDepart[k][0] && j+1 == tableauDepart[k][1] ){
						  if(i+1 == 3) {//si sur la 3eme ligne
						      Pion pt = new Pion((j+1) , (i+1) , "N");//pion noir
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1) , pt,"pion");
							  compteurPion=1;
							  dessin("pionN.png",j+1,i+1,g);
						  }else {
							  Pion pt = new Pion((j+1) , (i+1) , "B");//pion blanc
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1) , pt,"pion");
							  compteurPion=1;
							  dessin("pion.png",j+1,i+1,g);
						  }
					  }
				  }
				  for(int l = 0 ; l<tableauDepartRoi.length;l++) {//boucle cases rois
					  if(i+1 == tableauDepartRoi[l][0] && j+1 == tableauDepartRoi[l][1] ){
						  if(i+1 >5) {
							  Roi r = new Roi((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1) , r,"roi" );
							  compteurPion=1;
							  dessin("roi.png",j+1,i+1,g);
						  }else {
							  Roi r = new Roi((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1) , r,"roi" );
							  compteurPion=1;
							  dessin("roiN.png",j+1,i+1,g);
						  }
					  }
				  }
				  for(int m = 0 ; m<tableauDepartGold.length;m++) {//boucle cases golds
					  if(i+1 == tableauDepartGold[m][0] && j+1 == tableauDepartGold[m][1] ){
						  if(i+1 >5) {//si sur la derniere ligne
							  Gold gold = new Gold((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), gold,"gold");
							  compteurPion=1;
							  dessin("gold.png",j+1,i+1,g);
						  }else{
							  Gold gold = new Gold((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), gold,"gold");
							  compteurPion=1;
							  dessin("goldN.png",j+1,i+1,g);
						  }
				  }
				 
			  }
				  
				  for(int n = 0 ; n<tableauDepartSilver.length;n++) {//boucle cases golds
					  if(i+1 == tableauDepartSilver[n][0] && j+1 == tableauDepartSilver[n][1] ){
						  if(i+1 >5) {//si sur la derniere ligne
							  Silver silver = new Silver((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), silver,"silver");
							  compteurPion=1;
							  dessin("silver.png",j+1,i+1,g);
						  }else{
							  Silver silver = new Silver((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), silver,"silver");
							  compteurPion=1;
							  dessin("silverN.png",j+1,i+1,g);
						  }
				  }
				 
			  }
				  for(int n = 0 ; n<tableauDepartCavalier.length;n++) {//boucle cases golds
					  if(i+1 == tableauDepartCavalier[n][0] && j+1 == tableauDepartCavalier[n][1] ){
						  if(i+1 >5) {//si sur la derniere ligne
							  Cavalier cavalier = new Cavalier((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), cavalier,"cavalier");
							  compteurPion=1;
							  dessin("cavalier.png",j+1,i+1,g);
						  }else{
							  Cavalier cavalier = new Cavalier((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), cavalier,"cavalier");
							  compteurPion=1;
							  dessin("cavalierN.png",j+1,i+1,g);
						  }
				  }
				 
			  }
				  
				  for(int n = 0 ; n<tableauDepartLance.length;n++) {//boucle cases golds
					  if(i+1 == tableauDepartLance[n][0] && j+1 == tableauDepartLance[n][1] ){
						  if(i+1 >5) {//si sur la derniere ligne
							  Lance lance = new Lance((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), lance,"lance");
							  compteurPion=1;
							  dessin("lance.png",j+1,i+1,g);
						  }else{
							  Lance lance = new Lance((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), lance,"lance");
							  compteurPion=1;
							  dessin("lanceN.png",j+1,i+1,g);
						  }
				  }
				 
			  }
				  
				  for(int t = 0 ; t<tableauDepartTour.length;t++) {//boucle cases golds
					  if(i+1 == tableauDepartTour[t][0] && j+1 == tableauDepartTour[t][1] ){
						  if(i+1 >5) {//si sur la derniere ligne
							  Tour tour = new Tour((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), tour,"tour");
							  compteurPion=1;
							  dessin("tour.png",j+1,i+1,g);
						  }else{
							  Tour tour = new Tour((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), tour,"tour");
							  compteurPion=1;
							  dessin("tourN.png",j+1,i+1,g);
						  }
				  }
				 
			  }
				  
				  for(int e = 0 ; e<tableauDepartEveque.length;e++) {//boucle cases golds
					  if(i+1 == tableauDepartEveque[e][0] && j+1 == tableauDepartEveque[e][1] ){
						  if(i+1 >5) {//si sur la derniere ligne
							  Eveque eveque = new Eveque((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), eveque,"eveque");
							  compteurPion=1;
							  dessin("eveque.png",j+1,i+1,g);
						  }else{
							  Eveque eveque = new Eveque((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), eveque,"eveque");
							  compteurPion=1;
							  dessin("evequeN.png",j+1,i+1,g);
						  }
				  }
				 
			  }
					  if(compteurPion==0){//si la case est vide(sans "pion"=>piece)
					  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1),null,"vide");
				  }
				  compteur++;//compteur pour la case du tableau
			  }
			  }
	  }
	public static void main(String[] args) {
		
	}

	@Override
	public void update(Observable o, Object arg) {
		MouseClass m=new MouseClass(new Panneau());
		Plateau plat = new Plateau();
		for(int i =0;i<caseDuTableau.length;i++) {
			if(caseDuTableau[i]!=null) {
				if(m.trouvePieceCouleur(caseDuTableau[i])=="N") {
				String s =caseDuTableau[i].type.toUpperCase();
				if(s=="VIDE") {
					s=" ";
				}
				plat.tableau[caseDuTableau[i].y-1][caseDuTableau[i].x-1]=s.charAt(0);
				}else {
				String s =caseDuTableau[i].type.toLowerCase();
				if(s=="vide") {
					s=" ";
				}
				if(s=="pion") {
					System.out.println(caseDuTableau[i].y-1);
					System.out.println(caseDuTableau[i].x-1);
				}
				//plat.tableau[m.lastChange[1]][m.lastChange[0]]=' ';
				plat.tableau[caseDuTableau[i].y-1][caseDuTableau[i].x-1]=s.charAt(0);
				}
			}
		
	}
		//plat.tableau[m.lastChange[1]][m.lastChange[0]-1]=' ';
		System.out.println(m.lastChange[0]-1);
		//System.out.println(plat.tableau[6][2]);
		plat.afficher();

  }

}
