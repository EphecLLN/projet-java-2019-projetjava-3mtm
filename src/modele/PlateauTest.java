/**
 * 
 */
package modele;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Tresor
 *
 */
class PlateauTest {

	/**
	 * Test method for {@link modele.Plateau#table()}.
	 * teste si chaque pièce est a la bonne position
	 */
	@Test
	void testTable() {
		Plateau tab =new Plateau();
		char pawn ='R';
			assertEquals(pawn, tab.tableau[0][4]);
		
		pawn = 'L';
		assertEquals(pawn, tab.tableau[0][0]);
		
		
	pawn = 'F';
	assertEquals(pawn, tab.tableau[1][1]);

	
	pawn = 'C';
	assertEquals(pawn, tab.tableau[0][7]);
	assertEquals(pawn, tab.tableau[0][1]);
	
	pawn = 'S';
	assertEquals(pawn, tab.tableau[0][2]);
	assertEquals(pawn, tab.tableau[0][8]);
	
	pawn ='G';
	assertEquals(pawn,tab.tableau[0][3]);
	assertEquals(pawn,tab.tableau[0][5]);
	
	pawn = 'T';
	assertEquals(pawn,tab.tableau[1][7]);
	
	pawn ='r';
	assertEquals(pawn,tab.tableau[8][4]);
	
	pawn ='g';
	assertEquals(pawn,tab.tableau[8][3]);
	assertEquals(pawn,tab.tableau[8][5]);
	
	pawn ='c';
	assertEquals(pawn,tab.tableau[8][1]);
	assertEquals(pawn,tab.tableau[8][7]);
	
	pawn ='f';
	assertEquals(pawn,tab.tableau[7][1]);
	}

}
