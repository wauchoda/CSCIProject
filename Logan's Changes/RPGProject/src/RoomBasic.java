import java.util.*;
import java.io.*;

public class RoomBasic {
	
	//what to do? what to do.
	private Random rand = new Random();
	private int chance;
	private Item loot;
	private Trap trap;
	private Monster mob;
	
	public RoomBasic() throws IOException{
		chance = rand.nextInt(10);
		if(chance > 5){
			trap = new Trap();
		}
		else{
			mob = new Monster();
		}
		if(rand.nextInt(100) > 49){
			//spawn a chest
		}
	}
	
	public Trap getTrap(){
		return trap;
	}
	public void createTrap() {
		trap = new Trap();
	}
	public void setTrap(Trap t) {
		trap = t;
	}
	
	public Item getLoot(){
		return loot;
	}
	
	public Monster getMob() {
		return mob;
	}
	
	public void setLoot(Item l){
		loot = l;
	}
	
	public String look(){
		return "You see " + mob.toString() + trap.toString();
	}

}