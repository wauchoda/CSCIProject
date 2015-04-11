import java.util.Random;


//The room class simply generates a room from the list of types
public class Room {

	private encounter e;
	private Random rand = new Random();
	
	//uses random values and the constructor to make a random room
	public Room (){
		
		int i = rand(4)+1;
		
		if(i == 1){
			e = "shop";
			
		}
		
		else{
			e = "basic";
		}
		
	}
	
	public String getEcounter(){
		return e;
	}
	

}
