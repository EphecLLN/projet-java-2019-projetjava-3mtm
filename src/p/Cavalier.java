/**
 * 
 */
package p;

/**
 * @author joachim
 *
 */
public class Cavalier {

	/**
	 * @param args
	 */
	public int tableauN[][] = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
	public int tableauB[][] = {{2,1},{2,-1},{-2,1},{-2,-1},{1,2},{-1,2},{1,-2},{-1,-2}};
	public int axex;
	public int axey;
	public String couleur;
	public Cavalier(int axex,int axey, String couleur) {
		this.axex = axex;//50->500
		this.axey = axey;
		this.couleur = couleur;//B ou N
	}
	//public int bouger(int axeX,int axeY,String coul) {
		
	//}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
