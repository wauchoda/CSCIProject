
public abstract class Encounter {
	
	private boolean active;
	private String status;
	
	public boolean getActive(){
		return active;
	}
	
	public String getStatus(){
		return status;
	}
	
	public void setStatus(String s){
		status = s;
	}
	
	public void setActive(boolean a) {
		active = a;
	}
	
	public boolean isVowel(char a) { //created this so that I can generate sentences that make sense.
		if(status.charAt(0) == 'a' 
				|| status.charAt(0) == 'e' 
				|| status.charAt(0) == 'i' 
				|| status.charAt(0) == 'o'
				|| status.charAt(0) == 'u'){
			return true;
		}
		else
			return false;
	}

}
