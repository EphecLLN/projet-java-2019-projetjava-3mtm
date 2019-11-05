/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Pion {
	public String couleur;
	public int tableauN[] = {0,1};
	public int tableauB[] = {0,-1};
	public int axex;
	public int axey;
	
	public Pion(int axex,int axey, String couleur) {
		this.axex = axex;
		this.axey = axey;
		this.couleur = couleur;

	}

	public static void main(String[] args) {

	}

}
