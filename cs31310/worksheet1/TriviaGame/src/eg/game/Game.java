package eg.game;

import java.util.ArrayList;

public class Game {

	private ArrayList<Player> players; 
	
	private int roll = 0;
	
	private int currentPlayerIndex = 0;
	
	public Game() {
	   players = new ArrayList<Player>();
	}
	
	public Player addPlayer(String aPlayerName) throws GameException { 
		if (gameHasStarted()) { 
	       throw new GameException("The game has already started");
		}
		
		Player aPlayer = new Player(aPlayerName); 
		players.add(aPlayer); 
		return aPlayer;
	}
	
	public void removePlayer(Player player) throws GameException { 
		if (gameHasStarted()) {
		   throw new GameException("The game has already started");
		}
		
        players.remove(player); 
	}
   
	public String takeTurn(int roll) { 
		this.roll = roll;
		Player currentPlayer = players.get(currentPlayerIndex);
		if (currentPlayerIndex+1 == players.size()) { 
			currentPlayerIndex = 0;
		} else { 
			currentPlayerIndex++; 
		}
		
		return currentPlayer.getName();
	}
	
	public boolean gameHasStarted(){ 
		return roll != 0;
	}
	
	public boolean playerIsPlaying(Player aPlayer) { 
		return players.contains(aPlayer);
	}
	
	public int getNumberOfPlayers() { 
		return players.size();
	}
	
	public Player getPlayerNamed(String name){ 
		for(Player player: players) {
	       if (player.getName().equals(name)) { 
			  return player;
		   }
		}
		return null; 
	}

}
