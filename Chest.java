import java.util.ArrayList;
import java.util.Random;

public class Chest{
	private ArrayList<Item> contents = new ArrayList<Item>(4);
	Inventory Inventory;
	
	//in each chest you'll (3 of 4 chance) find one weapon and (2 of 3) one potion
	public Chest(){
		Inventory = new Inventory();
		Random rand = new Random();
		int ran = rand.nextInt(133)+1;
		
		//if you recieve and axe
		if(ran>0 && ran<=33){
			int value = 70;
			String name = "axe";
			int type = 1;
			int attack = 1;
			int defense = 2;
			Item axe = new Item(value,name,type,attack,defense);
			Inventory.addItem(axe);//adds axe to inventory not sure syntax not includes for others atm
		}
		
		//bow
		if(ran>33 && ran<=66){
			int value = 80;
			String name = "bow";
			int type = 2;
			int attack = 2;
			int defense = 2;
			Item bow = new Item(value,name,type,attack,defense);
		}
		
		//magic
		if(ran>66 && ran<=99){
			int value = 20;
			String name = "magic";
			int type = 3;
			int attack = 3;
			int defense = 0;
			Item magic = new Item(value,name,type,attack,defense);
		}
		
		//rare weapon
		if(ran==100){
			int value = 300;
			String name = "legendary pool noodle";
			int type = 4;
			int attack = 10;
			int defense = 10;
			System.out.println("wow");
			Item pooNoo = new Item(value,name,type,attack,defense);
			
		}
		else{
			//nothing
		}
		
		//determining if potion should be created````````````````````````````
		int ranPot = rand.nextInt(100)+1;
		
		//if you recieve normal potion
		if(ranPot>0 && ranPot<=33){
		}
		
		//super potion
		if(ranPot>33 && ranPot<=66){
		}
		
		//nothing
		if(ranPot>66 && ranPot<=99){

		}
		
		//super duper potion
		if(ranPot==100){
			int value = 300;
		
		}
	}
}
