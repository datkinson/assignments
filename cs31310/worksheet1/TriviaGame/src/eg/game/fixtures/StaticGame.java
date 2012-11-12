package eg.game.fixtures;

import eg.game.Game;

public abstract class StaticGame {

	private static Game theGame;
	
    public static Game getInstance() {
    	if (theGame == null) { 
    		theGame = new Game();
    	}
		return theGame;
	}
}
