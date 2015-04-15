import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


//Gui for the Game Window
public class GameWindow extends JFrame implements ActionListener {

   private JButton confirm;
   private JTextField name;
   private JLabel entername;
   private JPanel panel1;
   public static int roomCount = 0;
   
   public GameWindow(){
      
      //frame one is for getting a players name;
      panel1 = new JPanel();
      confirm = new JButton("Confirm");
      entername = new JLabel("Enter Name: ");
      name = new JTextField(25);
      
      
      panel1.add(entername);
      panel1.add(name);
      panel1.add(confirm);
      confirm.addActionListener(this);
      
      
      add(panel1);
      
      setTitle("Dungeoneer");
      setSize(300,120);
      setLocationRelativeTo(null);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
      
      
      
   
   }
   
    
   









   //All the responces and stuff
   public void actionPerformed(ActionEvent e){
	   if(e.getSource() == confirm){
		   Player.setName(name.getText());
		   MainWindow window2 = new MainWindow(Player.getName());
		   dispose();
	   }


   }
   
   
   //main method
   public static void main(String[]args){
     
		
		GameWindow window = new GameWindow();
      
   
   }
   

   
   
}