package eg.game;

public class Player {

	private String name; 
	
	public Player(String name) {
       this.name = name; 
	}
	
	public String getName() { 
		return name; 
	}
	
	public boolean equals(Object other){
		if (other != null && other instanceof Player) {
		   return ((Player)other).name.equals(this.name);
		}
		return false;
	}
}