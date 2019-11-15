/**
 * 
 */
package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author joachim
 *
 */
class GoldTest {

	/**
	 * Test method for {@link modele.Gold#Gold(int, int, java.lang.String)}.
	 */
	@Test
	void testGold() {
		Gold gold = new Gold(0,0,"B");
		assertEquals(0,gold.axex);
		assertEquals(0,gold.axey);
		assertEquals(0,gold.couleur);
	}

}
