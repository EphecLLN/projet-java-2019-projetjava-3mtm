/**
 * 
 */
package p;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * @author joachim
 *
 */
public class Fenetre extends JFrame {
	
	
	public Fenetre() {
	    this.setTitle("Shogi");
	    this.setSize(800, 550);
	    this.setLocationRelativeTo(null);

	    Panneau pan = new Panneau(); 
	    this.setBackground(Color.white);
		pan.addMouseListener(new MouseClass(pan));
	    this.setContentPane(pan);	
	    
	    
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	   
	    this.setVisible(true);    
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
