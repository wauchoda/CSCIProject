import java.util.*;

public class Monster extends Encounter{
	
	private String name;
	private static Random rand = new Random();
	public static int maxHealth;
	public static int health = maxHealth;
	public static int attack;
	public static int defense;
	private static int level;
	private int type;
	
	public Monster(){
		type = rand.nextInt(3);
		if(type == 0){
			name = "Orc";
			maxHealth = 150;
			level = 3;
		}
		if(type == 1){
			name = "Rogue";
			maxHealth = 100;
			level = 2;
		}
		if(type == 2){
			name = "Wolf";
			maxHealth = 50;
			level = 1;
		}
		setStatus("alive");
		setActive(true);
		
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String n){
		name = n;
	}
	
	public int getAttack(){
		return rand.nextInt(3);
	}
	
	public void killMonster(){
		setStatus("dead");
		setActive(false);
	}
	
	public int getHealth() {
		return health;
	}
	
	public int getType(){
		return type;
	}
	
	public int getLevel(){
		return level;
	}

}
