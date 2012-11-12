package eg.game.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import eg.game.Player;

public class PlayerTest {

	private Player playerOne; 
	
	private Player playerTwo; 
	
	@Before
	public void setup() { 
		playerOne = new Player("Alan Turing");
		playerTwo = new Player("Augusta Ada King");
	}
	
	@Test
	public void shouldHaveNameAfterInitialisation() {
		assertEquals("Incorrect name", "Alan Turing", playerOne.getName());
	}
	
	@Test 
	public void shouldIdentifyPlayersWithSameName() { 
		Player alternativePlayerOne = new Player("Alan Turing"); 
		assertTrue("Should be equal", playerOne.equals(alternativePlayerOne));
	}
	
	@Test 
	public void shouldIdentifyPlayersWithDifferentName() { 
		assertFalse("Should be false", playerOne.equals(playerTwo));
	}
	
	@Test 
	public void shouldOnlyTestEqualsForPlayerObjects() { 
		Object o = new Object(); 
		assertFalse("Should be false", playerOne.equals(o));
	}

}
