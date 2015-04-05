import java.util.*;

public class Monster extends Encounter{
	
	private int combatValues; //placeholder
	private String name;
	private Random rand = new Random();
	
	public Monster(){
		combatValues = 10; //placeholder
		name = "billy"; //placeholder
		setStatus("alive");
		setActive(true);
	}
	
	public int getCombatValues(){
		return combatValues;
	}
	
	public String getName(){
		return name;
	}
	
	public void setCombatValues(int n){
		combatValues = n;
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
		combatValues = 0; //placeholder
		
	}

}
