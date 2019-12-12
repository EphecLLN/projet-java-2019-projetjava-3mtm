package contolleur;
import modele.Partie;
import vue.Console;

public class Controller {

	private Partie model;
	private Console vueConsole = null;
	public Controller(Partie model)
	{
		this.model = model;

		}
	public boolean fixX(int x) {
		
		if(this.verif(x)==true) {
		model.setX(x);
		return true;
		}else {
		return false;
		}
		
		
	}
	public boolean fixX2(int x2) {
		if(this.verif(x2)==true) {
		model.setX2(x2);
		return true;
		}else {
		return false;
		}
	}
	public boolean fixY(int y) {
		if(this.verif(y)==true) {
		model.setY(y);
		
		return true;
	}else {
	return false;
	}
	}
	
	
	
	public boolean fixY2(int y2) {
		if(this.verif(y2)==true) {
		model.setY2(y2);
		return true;
		}else {
		return false;
		}
		
	}
	
	
	public boolean verif(int x) {
		if((x > 8) || (x <0)) {
		System.out.println("Le nombre entré doit etre entre 0 et 8 inclus !");
		model.setPlayer(-1);
		return false;
		}
		return true;
		
	}
}
