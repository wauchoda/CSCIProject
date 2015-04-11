public class Potion extends Item
{
   int maxHealth = 15;
   int health = 10;
   
   public Potion(){
   }
   
   public void UsePotion(int index, String t){
	   
	   //removes item from inventory
	   Inventory.removeItem(index);
	   
	   //restores health / increases health
	   if (t.equals("normal")){
		   checkHealth(5);
		   Player.health += 5;//syntax?
	   }
	   if (t.equals("super")){
		   checkHealth(10);
		   Player.maxHealth += 1;
		   Player.health += 10;//syntax?
	   }
	   if (t.equals("superDuper")){
		   checkHealth(15);
		   Player.maxHealth += 10;
		   Player.health += 15;//syntax?
	   }
   }
   
   //checks to make sure you dont heal past max health
   public void checkHealth(int restoring){
	   int restorable = maxHealth - health;
	   
	   if(restoring>restorable)
	   {
	      System.out.println("restoring " + restorable +" hp");
	      health += restorable;
	   }
	   
	   else  //potion wont overheal
	   {
	      System.out.println("restoring "+ restoring+ " hp");
	      health += restoring;
	   }
   }
}
   