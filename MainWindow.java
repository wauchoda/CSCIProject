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
      private Player p = new Player();
      private JTextArea Screen;
      private JLabel info;
      private JLabel roomNumber;
      private JLabel level;
  	  public static int roomCount = 0;
  	  private JTextField input;
  	  private JButton enter;
      
      
      
   //Sets up the window its going to be several panels
   public MainWindow(String n){
	 
	  //Inniate all the different buttons
	  p.setName(n);
	  panel = new JPanel(new BorderLayout());
	  mainPanel = new JPanel();
	  invPanel = new JPanel(new GridLayout(3,3));
	  buttonsPanel = new JPanel();
	  playerPanel =  new JPanel(new GridLayout(1,3));
	  Screen = new JTextArea(20,20);
	  JScrollPane eventlog = new JScrollPane(Screen);
	  Screen.setEditable(false);
	  info = new JLabel("Name: "+Player.getName());
	  roomNumber = new JLabel("Room Number: "+roomCount);
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
   }

   //All the responses and stuff
   public void actionPerformed(ActionEvent e){
	   String n;
	   if(e.getSource() == enter){
		   n = input.getText();
		   Screen.append("\n");
		   Screen.append("I do not understand that command.");
		   input.setText("");
		   
	   }


   }









}