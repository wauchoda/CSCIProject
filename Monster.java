import java.util.*;
import java.io.*;

public class Monster extends Encounter{
	
	private String name;
	private static Random rand = new Random();
	private int maxHealth;
	private int health;
	private int attack;
	private int defense;
	private int level;
	private int type;
	int type0[] = {0,0,0,1,2}; //these arrays are used to weight the random attack.
	int type1[] = {0,1,1,1,2};
	int type2[] = {0,1,2,2,2};
	
	public Monster()throws IOException{
		type = rand.nextInt(3);
		File monsterFile = new File("Monsters.txt");
		Scanner monsterReader = new Scanner(monsterFile);
		for(int i = 0; i < type; i++){ // reads through the file to the right line.
			monsterReader.nextLine();
		}
		name = monsterReader.next();
		maxHealth = Integer.parseInt(monsterReader.next());
		attack = Integer.parseInt(monsterReader.next());
		defense = Integer.parseInt(monsterReader.next());
		level = 1;
		health = maxHealth;
		setStatus("healthy");
		setActive(true);
		monsterReader.close();
		
	}
	
	public String getName(){
		return name;
	}
	public void setName(String n){
		name = n;
	}
	
	public int getAttack(){
		int t = 0;
		if(attack == 0){
			t = type0[rand.nextInt(5)];
		}
		if(attack == 1){
			t = type1[rand.nextInt(5)];
		}
		if(attack == 2){
			t = type2[rand.nextInt(5)];
		}
		return t;
	}
	
	public int getHealth() {
		return health;
	}
	public void setHealth(int h) {
		health = h;
	}
	
	public int getDefense() {
		return defense;
	}
	public void setDefense(int d) {
		defense = d;
	}
	
	public int getType(){
		return type;
	}
	
	public int getLevel(){
		return level;
	}
	public void setLevel(int l) {
		level = l;
	}

	public void damageMob(int d) {
		health -= d;
		if(health< maxHealth){
			if(health <= 0){
				killMonster();
			}
			else{
				setStatus("wounded");
			}
		}
	}
	
	public void healMob(int h) {
		if(getActive()){
			health += h;
			if(health >= maxHealth){
				setStatus("Healthy");
			}
			else if(getStatus() != "wounded"){
				setStatus("wounded");
			}
		}
	}

	public void killMonster(){
		setStatus("dead");
		setActive(false);
		setHealth(0);
	}
	
	public String toString(){
		String result;
		if(isVowel(getStatus().charAt(0))){
			result = "an " + getStatus() + " " + name + 
					"\nHealth: " + health + 
					"\nLevel: " + level + 
					"\nDefense: " + defense;
		}
		else{
			result = "a " + getStatus() + " " + name + 
					"\nHealth: " + health + 
					"\nLevel: " + level + 
					"\nDefense: " + defense;
		}
		return result;
	}

}
