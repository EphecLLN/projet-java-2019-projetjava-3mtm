/**
 * 
 */
package Vue;

import javax.swing.JFrame;

import Controller.MouseClass;
import p.Panneau;

/**
 * @author joachim
 *
 */
public class GUI extends JFrame {

	/**
	 * @param args
	 */
	MouseClass model;
	Panneau controller;
	
	public GUI(MouseClass model, Panneau controller) {
		this.model = model;
		this.controller = controller;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
