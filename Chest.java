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
		int mod = rand.nextInt(3);
		
		//if you recieve and axe
		if(ran>0 && ran<=33){
			int value = 70;
			String name = "axe";
			int type = 1 + mod;
			int attack = 1;
			Weapon axe = new Weapon(value,name,type,attack);
			Inventory.addItem(axe);//adds axe to inventory not sure syntax not includes for others atm
		}
		
		//bow
		if(ran>33 && ran<=66){
			int value = 80;
			String name = "bow";
			int type = 2;
			int attack = 2 + mod;
			Weapon bow = new Weapon(value,name,type,attack);
			Inventory.addItem(bow);
		}
		
		//magic
		if(ran>66 && ran<=99){
			int value = 20;
			String name = "magic";
			int type = 3;
			int attack = 3 + mod;
			Weapon magic = new Weapon(value,name,type,attack);
			Inventory.addItem(magic);
		}
		
		//rare weapon
		if(ran==100){
			int value = 300;
			String name = "legendary pool noodle";
			int type = 4;
			int attack = 10 + mod;
			System.out.println("wow");
			Weapon pooNoo = new Weapon(value,name,type,attack);			
		}
		
		//determining if potion should be created------------------------------------
		int ranPot = rand.nextInt(100)+1;
		
		//if you recieve normal potion
		if(ranPot>0 && ranPot<=33){
			Potion normal = new Potion("normal");
		}
		
		//super potion
		if(ranPot>33 && ranPot<=66){
			Potion normal = new Potion("super");
		}
		
		//nothing
		if(ranPot>66 && ranPot<=99){
		}
		
		//super duper potion
		if(ranPot==100){
			Potion normal = new Potion("superDuper");
		}
		
		public String naming(String name){
			try{
				File file = new file(filename)
			}
			catch{
				
			}
			
		}
	}
}
