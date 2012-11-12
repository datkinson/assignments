package eg.game.fixtures;

import eg.game.Game; 
import fit.ColumnFixture;

public class GameTurnFixture extends ColumnFixture {

	private int roll; 
	
	private Game theGame;
	
	public String player() {
	   theGame = StaticGame.getInstance(); 
	   return theGame.takeTurn(getRoll());
	}
	
	public boolean gameHasStarted() {
	  theGame = StaticGame.getInstance();
	   return theGame.gameHasStarted(); 
	}

	public int getRoll() {
		return roll;
	}

	public void setRoll(int roll) {
		this.roll = roll;
	}
	
	
}
