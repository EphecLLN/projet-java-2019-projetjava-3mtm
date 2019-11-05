/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Roi {
	public int tableau[][] = {{0,1},{0,-1},{1,1},{-1,1},{1,0},{1,-1},{-1,0},{-1,-1},{-1,1}};
	public int axex;
	public int axey;
	public String couleur;
	public Roi(int axex,int axey, String couleur) {
		this.axex = axex;
		this.axey = axey;
		this.couleur = couleur;

	}

	
	public static void main(String[] args) {

	}

}
