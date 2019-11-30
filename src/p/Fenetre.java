/**
 * 
 */
package p;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


/**
 * @author joachim
 *
 */
public  class Fenetre extends JFrame /*implements Observer*/ {
	
	//private static final long serialVersionUID=1L;
	  public JButton bouton = new JButton("Restart");
	  public MouseClass m;
	public Panneau pan;
	  
	public Fenetre() {
	    this.setTitle("Shogi");
	    this.setSize(800, 700);
	    this.setLocationRelativeTo(null);
	    
	    
	   pan = new Panneau(); 
	    m=new MouseClass(pan);
	    
	    this.setBackground(Color.white);
	    bouton.addActionListener(new ActionListener(){
	        public void actionPerformed(ActionEvent event){
	        	pan.init(pan.getGraphics());
	        	m.compteurB=0;
	        	m.compteurN=0;
	        	m.compteurClick=1;
	        	m.TimeManager(pan,"N",0);
	        	m.TimeManager(pan,"B",0);
	        }
	      });
	    pan.add(bouton);
		pan.addMouseListener(m);
		//this.pan.addObserver(this);
	    this.setContentPane(pan);	
	    
	    
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	   
	    this.setVisible(true);    
	}
	
	
	/*
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("wtf");
	}*/

}
