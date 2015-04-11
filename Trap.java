import java.util.*;
public class Trap extends Encounter{
	
	private int effect;
	private Random rand = new Random();
	private boolean active;
	private String status;
	
	public Trap(){
		effect = rand.nextInt(3);
		active = true;
		status = "armed";
	}
	
	public boolean getActive(){
		return active;
	}
	
	public int getEffect(){
		return effect;
	}
	
	public void triggerTrap(){
		active = false;
		status = "triggerd";
	}
	
	public void disarmTrap(){
		active = false;
		status = "disarmed";
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setEffect(int e) {
		effect = e;
	}
	
	public String toString() {
		String result;
		if(isVowel(status.charAt(0))){
			result = "an " + status + " trap";
		}
		else{
			result = "a " + status + " trap";
		}
		return result;
	} 

}
