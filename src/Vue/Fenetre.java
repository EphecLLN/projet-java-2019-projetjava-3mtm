/**
 * 
 */
package Vue;

import java.awt.Color;
import javax.swing.JFrame;

import Controller.MouseClass;
import model.Plateau;
import p.*;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;


/**
 * @author joachim
 *
 */
public  class Fenetre extends GUI implements Observer {
	
	//private static final long serialVersionUID=1L;
	  public JButton bouton = new JButton("Restart");
	  public static MouseClass m;
	public static Panneau pan;
	//public Plateau p;
	  
	public Fenetre() {
		super(m, pan);
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
	    m.addObserver(this);
	    pan.add(bouton);
		pan.addMouseListener(m);
		//this.pan.addObserver(this);
	    this.setContentPane(pan);	
	    
	    
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	   
	    this.setVisible(true);    
	}
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		System.out.println("test");
	}
	
	
	/*
	@Override
	public void update(Observable o, Object arg) {
		System.out.println("wtf");
	}*/

}
