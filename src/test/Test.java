package test;

import modele.Partie;
import contolleur.Controller;
import vue.Console;
import vue.Echequier;

public class Test {
	/*
	 * création du constructeur =>Partie =>Controller =>Console =>echiquier
	 */
	public Test() {
		Partie model = new Partie();
		Controller controllConsole = new Controller(model);
		Console vueConsole = new Console(model, controllConsole);
		Echequier vueInterface = new Echequier(model, controllConsole);
	}

	static Thread t = new Thread() {
		public void run() {
			new Test();
		}
	};

	public static void main(String args[]) {

		t.start();
	}
}
