package eg.game.tests;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

import eg.game.Game;
import eg.game.GameException;
import eg.game.Player;

public class GameTest {

	private Game game; 
	
	@Before 
	public void setup() { 
	   game = new Game(); 	
	}
	
	@Test
	public void shouldHaveZeroPlayersAndNotStartWhenInitialised() {
		Player player = new Player("Ada Lovelace");
		
		assertFalse("Should be false", game.playerIsPlaying(player)); 
		assertEquals("Should be zero", 0, game.getNumberOfPlayers());
		assertFalse("Game should not have started", game.gameHasStarted());
	}
	
	@Test
	public void shouldSeeIncreaseInPlayerNumbersWhenNewPlayersAddedBeforeGameStarted() 
	throws GameException { 
		game.addPlayer("Alan Turing");
		assertEquals("Should be 1", 1, game.getNumberOfPlayers());
		
		game.addPlayer("Ada Countess of Lovelace");
		assertEquals("Should be 2", 2, game.getNumberOfPlayers());
		
		game.addPlayer("Charles Babbage"); 
		assertEquals("Should be 3", 3, game.getNumberOfPlayers());
		
		game.addPlayer("Grace Hopper"); 
		assertEquals("Should be 4", 4, game.getNumberOfPlayers());
		
	}
	
	@Test(expected=GameException.class)
	public void shouldNotAllowPersonToJoinGameWhenTheGameHasStarted() throws GameException { 
		game.addPlayer("Alan Turing"); 
		game.takeTurn(1); 
		game.addPlayer("Ada Countess of Lovelace");
	}
	
	@Test 
	public void shouldRemovePlayersWhenPlayersAreInGame() throws GameException { 
		Player player = game.addPlayer("Ada"); 
		Player player2 = game.addPlayer("Babbage"); 
		
		game.removePlayer(player);
		game.removePlayer(player2); 
	}
	
	@Test(expected=GameException.class)
	public void shouldNotAllowPersonToLeaveGameWhenGameHasStarted() throws GameException { 
       Player player = game.addPlayer("Ada"); 
       game.takeTurn(2); 
       game.removePlayer(player); 
	}
	
	@Test 
	public void shouldManageCorrectTurnForPlayers() throws GameException { 
	   game.addPlayer("Ada");
	   game.addPlayer("Babbage");
	   
	   assertEquals("Incorrect name", "Ada", game.takeTurn(2)); 
	   assertEquals("Incorrect name", "Babbage", game.takeTurn(5)); 
	   assertEquals("Incorrect name", "Ada", game.takeTurn(3)); 
	}
	
	@Test 
	public void shouldShowGameHasStartedAfterFirstTurn() throws GameException { 
		game.addPlayer("Ada"); 
		game.takeTurn(1); 
		assertTrue("Game should have started", game.gameHasStarted());
	}
	
	@Test 
	public void shouldReturnPlayerInGame() throws GameException { 
		Player ada = game.addPlayer("Ada"); 
		Player babbage = game.addPlayer("Babbage"); 
		
		assertEquals("Incorrect person", ada, game.getPlayerNamed("Ada"));
		assertEquals("Incorrect person", babbage, game.getPlayerNamed("Babbage"));
	}
	
	@Test 
	public void shouldNotFindPersonWhoIsNotInTheGame() throws GameException { 
		assertNull("No person should be found", game.getPlayerNamed("Ada")); 
		game.addPlayer("Babbage"); 
		assertNull("No person should be found", game.getPlayerNamed("Ada")); 
	}
	
	@Test 
	public void shouldConfirmPlayerIsInGame() throws GameException { 
		Player ada = game.addPlayer("Ada"); 
		assertTrue("Player should be playing", game.playerIsPlaying(ada));
	}

	@Test 
	public void shouldConfirmPlayerIsNotInGame() throws GameException { 
		game.addPlayer("Ada"); 
		Player babbage = new Player("Babbage");
		assertFalse("Player should not be playing", game.playerIsPlaying(babbage));
	}
	
}
