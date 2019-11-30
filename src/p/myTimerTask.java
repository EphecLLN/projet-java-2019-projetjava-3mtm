/**
 * 
 */
package p;

import java.util.TimerTask;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;


/**
 * @author joachim
 *
 */
public class myTimerTask extends TimerTask{

	/**
	 * @param args
	 */
	Panneau panneau;
	String couleur;
	int check;
	int restart;
	public static int cmpt=60*10;
	public static int sec = 0;
	public static int cmptN=60*10;
	public static int secN = 0;
	public myTimerTask(Panneau panneau,String couleur,int check,int restart) {
		this.panneau=panneau;
		this.couleur=couleur;
		this.check=check;
		this.restart=restart;
	}
	
	
	@Override
    public void run() {
		
		if(restart==0) {
			cmpt=60*10;
			sec=0;
			cmptN=60*10;
			secN=0;
		
        Graphics g = panneau.getGraphics();
        Font font = new Font("Courier", Font.BOLD, 30);
	    g.setFont(font);
		if(check==0) {
			if(couleur=="N") {
				int minute=cmpt/60;
				String t = minute+"m"+sec + "s";
			    g.setColor(Color.lightGray);  
			    g.fillRect(550,150,100,50);
			    g.setColor(Color.black);
			    g.drawString(t, 550, 200);
			    cmpt--;
			    sec--;
			}else {
				int minute=cmptN/60;
				String t = minute+"m"+secN + "s";
			    g.setColor(Color.lightGray);  
			    g.fillRect(550,400,100,50);
			    g.setColor(Color.white);
			    g.drawString(t, 550, 450);
			    cmptN--;
			    secN--;
			}
		}else {
			if(couleur=="B") {
			    g.setColor(Color.white);  
			    g.fillRect(550,250,150,50);
			}else {
			    g.setColor(Color.white);  
			    g.fillRect(550,400,150,50);
			}
		}
		if(sec==-1) {
			sec=59;
		}else if(secN==-1) {
			secN=59;
		}
		restart++;
		}else {
			Graphics g = panneau.getGraphics();
	        Font font = new Font("Courier", Font.BOLD, 30);
		    g.setFont(font);
			if(check==0) {
				if(couleur=="N") {
					int minute=cmpt/60;
					String t = minute+"m"+sec + "s";
				    g.setColor(Color.lightGray);  
				    g.fillRect(550,150,100,50);
				    g.setColor(Color.black);
				    g.drawString(t, 550, 200);
				    cmpt--;
				    sec--;
				}else {
					int minute=cmptN/60;
					String t = minute+"m"+secN + "s";
				    g.setColor(Color.lightGray);  
				    g.fillRect(550,400,100,50);
				    g.setColor(Color.white);
				    g.drawString(t, 550, 450);
				    cmptN--;
				    secN--;
				}
			}else {
				if(couleur=="B") {
				    g.setColor(Color.white);  
				    g.fillRect(550,250,150,50);
				}else {
				    g.setColor(Color.white);  
				    g.fillRect(550,400,150,50);
				}
			}
			if(sec==-1) {
				sec=59;
			}else if(secN==-1) {
				secN=59;
			}
		}
		
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
