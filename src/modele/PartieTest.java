
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Tresor
 *
 */
class PartieTest {

	@Test
	void test() {
		Partie part = new Partie();
		part.Identifiant("joueur1", "joueur2", "10/10");
		assertEquals(3, part.sauv.length);
	}

}
