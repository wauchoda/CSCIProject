
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

}
