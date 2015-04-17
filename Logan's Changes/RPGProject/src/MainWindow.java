import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
//This is the main window for the game
public class MainWindow extends JFrame implements ActionListener{
      //All the different things in this GUI
	
      private JPanel mainPanel;
      private JPanel invPanel;
      private JPanel buttonsPanel;
      private JPanel playerPanel;
      private JPanel panel;
      private Player player;
      private JTextArea Screen;
      private JLabel info;
      private JLabel roomNumber;
      private JLabel level;
  	  public static int roomCount = 0;
  	  private JTextField input;
  	  private JButton enter;
  	  private static boolean attack = false;
  	  
   //Sets up the window its going to be several panels
   public MainWindow(String n)throws IOException{
	   
	   player = new Player();
	 
	  //Initiate all the different buttons
	  Player.setName(n);
	  panel = new JPanel(new BorderLayout());
	  mainPanel = new JPanel();
	  invPanel = new JPanel(new GridLayout(3,3));
	  buttonsPanel = new JPanel();
	  playerPanel =  new JPanel(new GridLayout(1,3));
	  Screen = new JTextArea(25,50);
	  JScrollPane eventlog = new JScrollPane(Screen);
	  Screen.setEditable(false);
	  info = new JLabel("Name: "+Player.getName());
	  roomNumber = new JLabel("Room Number: "+ Room.getRoomCount());
	  level = new JLabel("Player Level: "+Player.getLevel());
	  input = new JTextField(30);
	  enter = new JButton("Enter");
	 
	  
	  
	  //Adds the components to the little panels
	  playerPanel.add(info);
	  playerPanel.add(roomNumber);
	  playerPanel.add(level);
	  mainPanel.add(eventlog);
	  buttonsPanel.add(input);
	  buttonsPanel.add(enter);
	  enter.addActionListener(this);
	  
	  
	  //Adds the little panels to the big panel
	  panel.add(playerPanel, BorderLayout.NORTH);
	  panel.add(mainPanel, BorderLayout.CENTER);
	  panel.add(invPanel, BorderLayout.EAST);
	  panel.add(buttonsPanel, BorderLayout.SOUTH);
	  add(panel);
	  
	  
      setTitle("Dungeoneer");
      setSize(600,500);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      Screen.append("You awake on a sandy beach, confused by your surroundings you begin to explore. "
      		+ "\nSoon enough you come across a mysterious temple that is covered in moss and vines."
      		+ "\nYou have no conception of safety so you enter the temple for no apparent reason. "
      		+ "\nOnce you enter the temple the door slams shut behind you in a very chiché manner, trapping you inside!"
      		+ "\n Armed with a wooden axe, a wooden bow, and a wooden wand you begin to explore..."
      		+ "\n");
      Screen.append(player.getRoom().look());
   }
   
   public String look(){ //makes it easier to code look statements
	   return player.getRoom().look();
   }

   //All the responses and stuff
   public void actionPerformed(ActionEvent e){
	   String n;
	   if(e.getSource() == enter){
		   n = input.getText().toLowerCase();
		   //it was complaining about ioexceptions so I threw this in
		   try {
			   //main control
			   //generating next room
			   
			   if(attack){
				   if(Character.isDigit(n.charAt(0))){ //this looks for the number that the player chooses after entering a raw attack command.
					   player.combat(n.charAt(0));
					   Screen.append("\n"+ player.getRoom().getMonster().toString());
					   attack = false;
					   input.setText("");
					   return;
				   } 
				   else{
					   Screen.append("That is not a number. You can reenter attack and the enter a number (0-2) to choose the type of attack.");
					   attack = false;
					   input.setText("");
					   return;
				   }
			   }
			   if(n.equals("next") || n.equals("n")) { //next room command
				   if(player.getRoom().getEncounter().equals("Monster")){ //check if there is a monster in the room
					   if(player.getRoom().getMonster().getStatus().equals("dead")){ // Move to next Room if monster is dead
						   player.move();
						   roomNumber.setText("Room Number: " + Room.getRoomCount());
						   Screen.append(look());
						   attack = false;
						   input.setText("");
						   return;
					   }
					   else{														//-------------------------------------------------
						   Screen.append("\n You need to kill the monster first!"); // if there is a monster alive in the room he stops 
						   attack = false;											// you from going to the next room
						   input.setText("");										//-------------------------------------------------
						   return;
					   }
				   } 
				   else{ 	// if there is no monster in the room, move to the next room
					   player.move();
					   roomNumber.setText("Room Number: " + Room.getRoomCount());
					   Screen.append(look());
					   attack = false;
					   input.setText("");
					   return;
				   }
			   }
			   //attacking
			   if (n.startsWith("attack") || n.startsWith("a")) { //attack commands
				   if (player.getRoom().getEncounter().equals("Monster")){	//checks if there are monsters in the room.
					   if(Character.isDigit(n.charAt((n.length()-1)))){		//quick combat code, player can enter "attack #",
						   player.combat(n.charAt(n.length()-1));			//to attack quickly using the type #.
						   if(!player.getRoom().getMonster().getActive()){
							   Screen.append("\nYou have slain the enemy!");
						   }
						   Screen.append("\n"+ player.getRoom().getMonster().toString());
						   attack = false;
						   input.setText("");
						   return;
					   }
					   else{
						   Screen.append("\n Which attack do you want to use? " //raw attack code, can enter "attack" or "a" and the program
						   		+ "Enter '0' for melee, '1' for ranged, '2' for magic"); //will look for the next input
						   Screen.append("\nYou are fighting a " + player.getRoom().getMonster().look());	
						   attack = true;
						   input.setText("");
						   return;
					   }
				   }
				   else{
					   Screen.append("\n There are no Monsters here."); //no monsters, combat does not happen
					   input.setText("");
					   return;
				   }
			   }
			   //get inventory
			   if (n.equals("inventory") || n.equals("i")){	//inventory code, player can check their inventory
				   String temp = ("Equipped: \n" + player.getEquipped().toString());
				   temp += ("\nInventory: \n" + player.getInventory().toString());
				   Screen.append("\n" + temp);
				   input.setText("");
				   return;
			   }
			   //loot chests
			   if(n.equals("loot")){
				   if(player.getRoom().hasChest()){
					   Screen.append(player.getRoom().getChest().getInventory()+"");
					   try{
						   
						   for(int i = 0; i< player.getRoom().getChest().getInventory().getSize(); i++){
							   player.moveItem(i);
						   }
						   Screen.append("Items added.");

					   }
					   catch(IndexOutOfBoundsException index){
						   Screen.append("That item doesn't exist.");
					   }
				   }
			   }
			   
			   //selling an item THIS DOES NOT WORK YET, It will probably just freeze
			   if (n.equals("sell") | n.equals("s")) {
				   if (player.getRoom().getEncounter().equals("Shop")){
					   Screen.append(player.getInventory().toString() +"\n What is the index of item you wish to sell?");
					   boolean sold = false;
					   while(sold == false) {
						   try {
							   if (e.getSource() == enter) {
								   n = input.getText().toLowerCase();
								   player.sellItem(Integer.parseInt(n));
								   sold = true;
							   }
						   }
						   catch (NumberFormatException parse) {
							   Screen.append("\n That's not a number!");
						   }
						   catch (IndexOutOfBoundsException index){
							   Screen.append("\n That item doesn't exist.");
						   }
					   }
				   }
				   else
					   Screen.append("\n You're not in a shop.");
			   }
			   
			   if(n.equals("help")){ // player can enter "help" to get a list of commands
				   Screen.append("\nList of commands:"
				   		+ "\nAttack or a -- attacks the enemy, you can also add 0-2 to quickly attack."
				   		+ "\nNext or n -- moves to the next room."
				   		+ "\nSell or s -- sell items to a shop keeeper. **NOT FUNCTIONAL**"
				   		+ "\nInventory or i -- looks into your inventory."
				   		+ "\nLook or l -- looks around the room."
				   		+ "\nLoot -- loots chests.");
				   input.setText("");
				   return;
			   }
			   if(n.equals("look") || n.equals("l")){
				   Screen.append(look());
				   input.setText("");
				   return;
			   }
			   //if the input does not match a command
			   else{ //This line takes advantage of the "return;" line at the end of all if conditions. Runs if none of the if()s returns.
				   Screen.append("\n I don't understand that. \n ");
			   }
		   }

		   catch(IOException io){
			   System.out.println("");
		   }
		   input.setText("");   //makes sure the text box is clear when the player is done with it.
		   Screen.setCaretPosition(Screen.getDocument().getLength());
	   }
   }
}