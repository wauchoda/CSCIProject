import java.util.ArrayList;
import java.util.Scanner;
public class Inventory {
   Scanner kb = new Scanner(System.in);
   private ArrayList<Item> list;
   private int counter;
   
   public Inventory(){
	   list = new ArrayList<Item>();
	   counter = 0; //counts num of items in 'list'
   }
   
   public ArrayList<Item> getList(){
	   return list;
   }
   
   public void addItem(Item a){
	   //if full, do not add
	   if (counter  == list.size()-1 ){
		   System.out.println("The bag is full!");
		   return;
	   }
	   else{
		   list.add(a);
		   counter ++;
	   }
   }
   
   public String toString() {
		String temp = "\n";
		for(int i = 0; i <list.size();i++)
			temp+= list.get(i).toString() +"\n";
		return temp;
   }
   
   public void removeItem(int index){
	   
	   if(counter != 0){
		   list.remove(index);
		   counter --;
	   }
   }

   public void clear() {
	   list.clear();
   }
}