import java.util.ArrayList;
import java.util.Scanner;
public class Inventory //extends player
{
   Scanner kb = new Scanner(System.in);
   private int size;
   private ArrayList<Item> list;
   private int counter;
   
   public Inventory()
   {
	   list = new ArrayList<Item>(size);
	   counter = 0; //counts num of items in 'list'
   }
   
   public ArrayList<Item> getList(){
	   return list;
   }
   
   public void addItem(Item a)
   {
	   //if full, do not add
	   if (counter  == list.size()-1 )
		   System.out.println("The bag is full!");
		   
	   //if not full, add
	   if (counter < list.size()-1){
		   list.add(a);
		   counter ++;
		   System.out.println("added "+a.getName() +" to bag.");
	   }
	   else
		   System.out.println("great we have a logic error...");
   }
   
   public void removeItem(int index)
   {
	   //if bag empty, do not remove
	   if(counter == 0)
		   System.out.println("Bag is Empty!");
	   //if bag not empty, remove
	   if(counter != 0){
		   System.out.println("Do you want to remove/use " + list.get(index).getName() + "? (y/n)");
		   String response = kb.nextLine();
		   
		   if(response.equals("y")){
			   list.remove(index);
			   counter --;
		   }
		   
		   //easter egg
		   if(response.equals("dankMemes") && counter<list.size()-1){
			   //value,name,type,attack,description
			   Item.add(new item(69,"The Meme Machine",3));
		   }
		   
		   if(response.equals("n"))
			   System.out.println("Not removing/using item.");
		   
		   else
			   System.out.println("incorrect response.");
	   }
   }  
}  
