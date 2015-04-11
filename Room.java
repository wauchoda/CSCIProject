package CSCIProject;
import java.util.Random;
//The room class simply generates a room from the list of types
public class Room {

	private static int roomCount = 0;
	private String e;
	private Random rand = new Random();
	
	//uses random values and the constructor to make a random room
	public Room (){
		roomCount++;
		int i = rand.nextInt(4)+1;
		
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
