/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Cheval {

	/**
	 * @param args
	 */
	public int tableau[][] = {{0,1},{0,-1},{1,1},{1,0},{1,-1},{-1,0},{-1,-1},{-1,1}};
	public int tableauN[][][] = {{{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8}},
								{{2,-2},{3,-3},{4,-4},{5,-5},{6,-6},{7,-7},{8,-8}},
								{{-2,2},{-3,3},{-4,4},{-5,5},{-6,6},{-7,7},{-8,8}},
								{{-2,-2},{-3,-3},{-4,-4},{-5,-5},{-6,-6},{-7,-7},{-8,-8}}};
	public int tableauB[][][] = {{{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8}},
								{{2,-2},{3,-3},{4,-4},{5,-5},{6,-6},{7,-7},{8,-8}},
								{{-2,2},{-3,3},{-4,4},{-5,5},{-6,6},{-7,7},{-8,8}},
								{{-2,-2},{-3,-3},{-4,-4},{-5,-5},{-6,-6},{-7,-7},{-8,-8}}};
	public int axex;
	public int axey;
	public String couleur;
	public Cheval(int axex,int axey, String couleur) {
		this.axex = axex;
		this.axey = axey;
		this.couleur = couleur;

	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
