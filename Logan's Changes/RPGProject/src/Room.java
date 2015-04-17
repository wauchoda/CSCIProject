import java.io.IOException;
import java.util.Random;
//The room class simply generates a room from the list of types
public class Room {

	private static int roomCount = 0;
	private String e;
	private Random rand = new Random();
	private Monster monster;
	private shopKeeper shopKeeper;
	private Trap trap;
	private Chest chest;

	//uses random values and the constructor to make a random room
	public Room ()throws IOException {
		setRoomCount(getRoomCount() + 1);
		int i = rand.nextInt(6)+1;
		
		if(i == 1){
			e = "Shop";
			shopKeeper = new shopKeeper();
		}
		
		else if(i ==2){
			e = "Trap";
			trap = new Trap();
		}
		else if(i==3){
			e ="Chest";
			chest = new Chest();
		}
		else {
			e = "Monster";
			monster = new Monster();
		}
	}
	
	public String getEncounter(){
		return e;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

	public shopKeeper getShopKeeper() {
		return shopKeeper;
	}

	public void setShopKeeper(shopKeeper shopKeeper) {
		this.shopKeeper = shopKeeper;
	}

	public Trap getTrap() {
		return trap;
	}

	public void setTrap(Trap trap) {
		this.trap = trap;
	}

	public Chest getChest() {
		return chest;
	}

	public void setChest(Chest chest) {
		this.chest = chest;
	}

	public static int getRoomCount() {
		return roomCount;
	}

	public static void setRoomCount(int roomCount) {
		Room.roomCount = roomCount;
	}
	
	public boolean hasTrap(){
		if(trap != null){
			return true;
		}
		else return false;
	}
	
	public boolean hasMonster(){
		if(monster != null){
			return true;
		}
		else return false;
	}
	
	public boolean hasChest(){
		if(chest != null){
			return true;
		}
		else return false;
	}
	
	public boolean hasShop() {
		if(shopKeeper != null){
			return true;
		}
		else return false;
	}
	
	public String look(){
		if(hasChest()){
			return "\nYou see a chest in this room.";
		}
		if(hasShop()){
			return "\nYou see a Shopkeeper in this room";
		}
		else if(hasMonster()){
			return "\nYou look around the room and see, " + monster.look() + ". Prepare for combat!";
		}
		else return "\nYou look around the room and see nothing dangerous.";
	}
}
