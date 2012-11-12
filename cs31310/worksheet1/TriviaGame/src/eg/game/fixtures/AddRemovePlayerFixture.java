package eg.game.fixtures;

import eg.game.Game; 
import eg.game.GameException;
import eg.game.Player; 
import fit.ColumnFixture;

public class AddRemovePlayerFixture extends ColumnFixture {

	private String playerName; 
	
	private Game theGame; 
	
	public boolean addPlayer() { 
		theGame = StaticGame.getInstance(); 
		try { 
		   Player thePlayer = theGame.addPlayer(playerName); 
		   return theGame.playerIsPlaying(thePlayer);
		}
		catch(GameException ex) { 
			return false; 
		}
	}
	
	public int countPlayers() {
		return theGame.getNumberOfPlayers(); 
	}
	
	public boolean removePlayer() throws GameException {
		   theGame = StaticGame.getInstance();
		   Player thePlayer = theGame.getPlayerNamed(playerName);
		   theGame.removePlayer(thePlayer);
		   return playerWasRemoved(thePlayer);
	}
	
	public boolean removePlayerHideException() throws GameException {
		try { 
		   theGame = StaticGame.getInstance();
		   Player thePlayer = theGame.getPlayerNamed(playerName);
		   theGame.removePlayer(thePlayer);
		   return playerWasRemoved(thePlayer);
		}
		catch(GameException ex) { 
			return false; 
		}
	}
	
	private boolean playerWasRemoved(Player aPlayer) { 
		return !theGame.playerIsPlaying(aPlayer); 
	}
	
	public void setPlayerName(String name) { 
		this.playerName = name; 
	}
	
	public String getPlayerName() { 
		return this.playerName; 
	}
}
