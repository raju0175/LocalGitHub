/**
 * 
 */
package test.com.cb.number.guess.game;

import static org.junit.Assert.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

import org.junit.Before;
import org.junit.Test;

import com.cb.number.guess.game.GameMain;

/**
 * @author Srinivasa
 *
 */
public class GameMainTest {

	/**
	 * @throws java.lang.Exception
	 */

	private GameMain game;

	private int startRange;
	private int endRange;
	private String response;

	@Before
	public void setUp() throws Exception {
		game = new GameMain();
		startRange = 0;
		endRange = 100;
		response = "higher";
	}

	/**
	 * Test method for
	 * {@link com.cb.number.guess.game.GameMain#main(java.lang.String[])}.
	 */
	@Test
	public void testCalculateNumber() {
		assertEquals(50,
				game.calculateNextNumber(response, 0, startRange, endRange));
		response = "lower";
		startRange = 25;
		endRange = 50;
		assertEquals(37,
				game.calculateNextNumber(response, 50, startRange, endRange));
	}

	@Test
	public void testValidateUserResponse() {
		assertEquals(false, game.validateUserResponse("Hello"));
		assertEquals(true, game.validateUserResponse("yes"));
		assertEquals(true, game.validateUserResponse("higher"));
		assertEquals(true, game.validateUserResponse("lower"));
		assertEquals(true, game.validateUserResponse("end"));
	}

}
