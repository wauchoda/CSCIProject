package CSCIProject; /**
 * Created by David on 2015-03-02.
 */
import java.util.ArrayList;
import java.util.Random;
public class Player {
    Random rand = new Random();
    //attributes
    public static int maxHealth = 10;
    public static int health = maxHealth;
    public static int attack;
    public static int defense;
    private int level;
    private int money;
    private String name;
    Inventory inventory;
    //location xpos and ypos
    private int xpos;
    private int ypos;

    public Player(){
        maxHealth += rand.nextInt(10);
        inventory = new Inventory();
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

    //get/set name
    public String getName() { return name;}

    public void setName(String s){name = s;}

    //when attack is pressed triggers the event
    public void event(int attack){
        if(room.getRoomBasic.getEncounter().getClass().getName().equals("Monster"){
            combat(attack);
        }
        if(room.getRoomBasic.getEncounter().getClass().getName().equals("Shop")){
            shop(attack);
        }
    }

    //combat (compares self values to monster class values and reduces accordingly)
    public void combat(int attack) {
        int tempa, tempt,tempc;
        Monster m= room.getRoomBasic.getEncounter();

            tempa = m.getAttack();
            tempt = m.getType();
            tempc =compareCombat(attack, tempa);
        //winning combination
        if(tempc == 0){
            health =- tempa/2;
            m.setHealth(m.getHealth()-2*attack);
        }
        //tie combination
        if(tempc == 1){
            health =- tempa/2;
            m.setHealth(m.getHealth()-attack/2);
        }
        //lose combination
        if(tempc == 0){
            health =- tempa;
            m.setHealth(m.getHealth()-attack/2);
        }

    }
    //fights the shopkeeper
    public void shop(int attack){
        int tempa, tempt,tempc;
        shopKeeper m = room.getRoomBasic.getEncounter().getShopKeeper();

        tempa = m.getAttack();
        tempt = m.getType();
        tempc =compareCombat(attack, tempa);
        //winning combination
        if(tempc == 0){
            health =- tempa/2;
            m.setHealth(m.getHealth()-2*attack);
        }
        //tie combination
        if(tempc == 1){
            health =- tempa/2;
            m.setHealth(m.getHealth() - attack / 2);
        }
        //lose combination
        if(tempc == 0){
            health =- tempa;
            m.setHealth(m.getHealth()-attack/2);
        }
    }

    public int compareCombat(int p, int m){
        //win
        if(p == 0 & m== 1)
            return 0;
        if(p == 1 & m ==2)
            return 0;
        if(p == 2 & m == 0)
            return 0;
        //lose
        if(p == 1 & m== 0)
            return 2;
        if(p == 2 & m ==1)
            return 2;
        if(p == 0 & m == 2)
            return 2;
        //tie
        if(p == 0 & m== 0)
            return 1;
        if(p == 1 & m ==1)
            return 1;
        if(p == 2 & m == 2)
            return 1;
    }
    //returns the arraylist from inventory that has items in it
    public ArrayList<Item> getInventory(){
        return inventory.getList();
    }
    public void move(){
        room = room.generateRoom();

    }
    //increments money based on value and removes the item from inventory
    public void sellItem(int i){
        if(inventory.getList().get(i) != null & room.getEncounter().getClass().getName().equals("Shop")) {
            money += 0.75 * (inventory.getList().get(i).getValue());
            inventory.getList().removeItem(i);
        }
    }

    public void moveItem(){
        if(room.getChest.getInventory().getList().get(i) != null) {
            temp item = room.getChest.getInventory().getList().get(i);
            room.getChest.getInventory().getList().remove(i);
            if(inventory.getList().size() < 9)
                inventory.addItem(item);
        }
    }
    public void removeItem(int i){
        if(inventory.getList().get(i) != null)
            inventory.getList().remove(i);
    }
    /**
    public void useItem(int i){
        inventory.get(i).
    }*/





}
