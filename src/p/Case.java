/**
 * 
 */
package p;

import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.event.MouseEvent;

/**
 * @author joachim
 *
 */
public class Case /*extends JPanel*/ {
	public int compteur;
	public int x;
	public int y;
	public Object obj;
	public String type;
	/*
		Pion pt ;
	Roi roi;
	Gold gold;*/
	
	public Case(int compteur,int axex , int axey ,Object obj, String type){
		this.compteur = compteur;
		this.x = axex;
		this.y = axey;
		this.obj = obj;
		this.type = type;
		/*
		this.pt = pt;
		this.roi = roi;
		this.gold = gold;
		*/
	}
	

}
