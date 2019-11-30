/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Eveque {

	/**
	 * @param args
	 */
	public int tableauN[][][] = {{{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8}},
			{{1,-1},{2,-2},{3,-3},{4,-4},{5,-5},{6,-6},{7,-7},{8,-8}},
			{{-1,1},{-2,2},{-3,3},{-4,4},{-5,5},{-6,6},{-7,7},{-8,8}},
			{{-1,-1},{-2,-2},{-3,-3},{-4,-4},{-5,-5},{-6,-6},{-7,-7},{-8,-8}}};
public int tableauB[][][] = {{{1,1},{2,2},{3,3},{4,4},{5,5},{6,6},{7,7},{8,8}},
		{{1,-1},{2,-2},{3,-3},{4,-4},{5,-5},{6,-6},{7,-7},{8,-8}},
		{{-1,1},{-2,2},{-3,3},{-4,4},{-5,5},{-6,6},{-7,7},{-8,8}},
		{{-1,-1},{-2,-2},{-3,-3},{-4,-4},{-5,-5},{-6,-6},{-7,-7},{-8,-8}}};
public int axex;
public int axey;
public String couleur;
public Eveque(int axex,int axey, String couleur) {
this.axex = axex;
this.axey = axey;
this.couleur = couleur;

}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
