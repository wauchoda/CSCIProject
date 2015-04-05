import java.util.*;
public class RoomBasic extends Room{
	
	//what to do? what to do.
	private Random rand = new Random();
	private int chance;
	private Item loot;
	private Encounter event;
	
	public RoomBasic(){
		chance = rand.nextInt(10);
		if(chance > 5){
			event = new Trap();
		}
		else{
			event = new Monster();
		}
	}
	
	public Encounter getEncounter(){
		return event;
	}
	
	public Item getLoot(){
		return loot;
	}
	
	public void setEncounter(Encounter e){
		event = e;
	}
	
	public void setLoot(Item l){
		loot = l;
	}

}
