package CSCIProject; /**
 * Created by David on 2015-03-02.
 */
import java.util.ArrayList;
import java.util.Random;
public class Player {
    Random rand = new Random();
    //attributes
    public static int maxHealth = rand.getInt();
    public static int health = maxHealth;
    public static int attack;
    public static int defense;
    private int level;
    private int money;
    Inventory inventory;
    Room room;
    //location xpos and ypos
    private int xpos;
    private int ypos;

    public Player(){
        maxHealth += level;
        inventory = new Inventory();
        Room room = new Room();
    }


    //get/set health
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    //get/set attack
    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    //get/set defense
    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    //get/set level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //get/set money
    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    ///get/set xpos
    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    //get/set ypos
    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    //use item
    /**public void useItem(index i){
     *  inventory.get(i).getEffect();
    }*/
    //combat (compares self values to monster class values and reduces accordingly)
    public void combat(int attack) {
        if(room.getEncounter.equals("Monster"){
            room.get
        }
        if(room.getEncounter.equals("ShopKeeper")){
            room.get
        }

    }
    //returns the arraylist from inventory that has items in it
    public ArrayList<Item> getInventory(){
        return inventory.getList();
    }
    public void move(){
        room = room.generateRoom();

    }




}
