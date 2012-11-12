package eg.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import eg.game.Game;
import eg.game.fixtures.StaticGame;

public class StaticGameTest {

	@Test
	public void shouldReturnSameInstanceAfterTwoCalls() {

		Game game = StaticGame.getInstance();
		Game additionalGame = StaticGame.getInstance(); 
		
		assertEquals("The two games do not represent the same object", 
				game, additionalGame);
	}

}
