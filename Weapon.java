public class Weapon extends Item
{
   private int attack;
   private String type;
   
   public Weapon(int a){
	   a = attack;
   }
	   //get set methods
	   public int getAttack()
	   {
	      return attack;
	   }
	   
	   public void setAttack(int n)
	   {
	      attack = n;
	   }
	   
	   public String getType()
	   {
	      return type;
	   }
	   
	   public void setType(String n)
	   {
	      type = n;
	   }
	   
	   /* extrea feature
	   public int getDefense() {
          return defense;
	   }
		
	   public void setDefense(int defense) {
		   this.defense = defense;
	   }*/
}