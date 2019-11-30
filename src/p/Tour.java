/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Tour {
	public int tableauN[][][] = {{{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{0,8}},
								{{0,-1},{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7},{0,-8}},
								{{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0}},
								{{-1,0},{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0},{-8,0}}};
	public int tableauB[][][] = {{{0,1},{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{0,8}},
								{{0,-1},{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7},{0,-8}},
								{{1,0},{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0}},
								{{-1,0},{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0},{-8,0}}};
	public int axex;
	public int axey;
	public String couleur;
	public Tour(int axex,int axey, String couleur) {
		this.axex = axex;
		this.axey = axey;
		this.couleur = couleur;

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
