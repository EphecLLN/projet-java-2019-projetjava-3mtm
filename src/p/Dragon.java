/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Dragon {

	/**
	 * @param args
	 */
	public int tableau[][] = {{0,1},{0,-1},{1,1},{1,0},{1,-1},{-1,0},{-1,-1},{-1,1}};
	public int tableauN[][][] = {{{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{0,8}},
								{{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7},{0,-8}},
								{{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0}},
								{{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0},{-8,0}}};
	public int tableauB[][][] = {{{0,2},{0,3},{0,4},{0,5},{0,6},{0,7},{0,8}},
								{{0,-2},{0,-3},{0,-4},{0,-5},{0,-6},{0,-7},{0,-8}},
								{{2,0},{3,0},{4,0},{5,0},{6,0},{7,0},{8,0}},
								{{-2,0},{-3,0},{-4,0},{-5,0},{-6,0},{-7,0},{-8,0}}};
	public int axex;
	public int axey;
	public String couleur;
	public Dragon(int axex,int axey, String couleur) {
		this.axex = axex;
		this.axey = axey;
		this.couleur = couleur;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
