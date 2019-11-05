package p;
import java.awt.Font;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JPanel;


import java.awt.Image;

import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

// /*
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Panneau extends JPanel {
	int compteurPion = 0;
	
	  
	int tableauDepartRoi[][] ={//case de depart des rois
		{9,5},{1,5}
	};
	int tableauDepartGold[][] ={//case de depart des golds
			{8,6},{8,4},{2,4},{2,6}
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
	Case caseDuTableau[] = new Case[81];//tableau contenant toutes les cases
	  public void paintComponent(Graphics g){
		  try {//imagea droite du plateau
		      Image img = ImageIO.read(new File("shogiBG.jpg"));
		      g.drawImage(img, 500, 50, 250, 250, this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    } 
		  Font font = new Font("Courier", Font.BOLD, 30);
		    g.setFont(font);
		    g.setColor(Color.black);    
		    g.drawString("Shogi", 50, 40);
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
							  dessin("pion.png",j+1,i+1,g);
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
							  dessin("roi.jpg",j+1,i+1,g);
						  }else {
							  Roi r = new Roi((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1) , r,"roi" );
							  compteurPion=1;
							  dessin("roi.jpg",j+1,i+1,g);
						  }
					  }
				  }
				  for(int m = 0 ; m<tableauDepartGold.length;m++) {//boucle cases golds
					  if(i+1 == tableauDepartGold[m][0] && j+1 == tableauDepartGold[m][1] ){
						  if(i+1 >5) {//si sur la derniere ligne
							  Gold gold = new Gold((j+1) , (i+1) , "B");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), gold,"gold");
							  compteurPion=1;
							  dessin("th.jpg",j+1,i+1,g);
						  }else{
							  Gold gold = new Gold((j+1) , (i+1) , "N");
							  caseDuTableau[compteur] = new Case(compteur, (j+1) , (i+1), gold,"gold");
							  compteurPion=1;
							  dessin("th.jpg",j+1,i+1,g);
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
	  
	//dessine l image
	  public void dessin(String image,int col,int ligne,Graphics dess) {
		  try {
		      Image img = ImageIO.read(new File(image));
		      dess.drawImage(img, ((col)*50), ((ligne)*50),50,50, this);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		  }

	public static void main(String[] args) {
		
	}

}
