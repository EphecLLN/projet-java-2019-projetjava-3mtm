/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Gold {
	public int tableauN[][] = {{0,1},{0,-1},{1,1},{-1,1},{1,0},{-1,0}};
	public int tableauB[][] = {{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{1,-1}};
	public int axex;
	public int axey;
	public String couleur;
	public Gold(int axex,int axey, String couleur) {
		this.axex = axex;
		this.axey = axey;
		this.couleur = couleur;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
