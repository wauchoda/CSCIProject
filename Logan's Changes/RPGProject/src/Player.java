/**
 * Created by David on 2015-03-02.
 */
import java.util.ArrayList;
import java.util.Random;
import java.io.IOException;
public class Player{
    Random rand = new Random();
    //attributes
    public static int maxHealth = 10;
    public static int health = maxHealth;
    public static int attack;
    public static int defense;
    public static int level;
    public static int money;
    public static String name;
    public static boolean dead;
    public Room room;
    private Inventory inventory;
    private Inventory equipped;

    public Player()throws IOException{
        maxHealth += rand.nextInt(10);
        inventory = new Inventory();
        room = new Room();
        equipped = new Inventory();
        //adding default items to inventory
        equipped.addItem(new Weapon(1,"Wooden Axe",1,1));
        equipped.addItem(new Weapon(1,"Wooden Bow",2,1));
        equipped.addItem(new Weapon(1,"Wooden Wand",3,1));
    }


    //get/set health
    public static int getHealth() {
        return health;
    }

    public static void setHealth(int h) {
        health = h;
    }
    
    public Inventory getEquipped() {
        return equipped;
    }

    public void setEquipped(Inventory equipped) {
        this.equipped = equipped;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    //get/set attack
    public static int getAttack() {
        return attack;
    }

    public static void setAttack(int a) {
        attack = a;
    }

    //get/set defense
    public static int getDefense() {
        return defense;
    }

    public static void setDefense(int d) {
        defense = d;
    }

    //get/set level
    public static int getLevel() {
        return level;
    }

    public static void setLevel(int l) {
        level = l;
    }

    //get/set money
    public static int getMoney() {
        return money;
    }

    public static void setMoney(int m) {
        money = m;
    }


    //get/set name
    public static String getName() { return name;}

    public static void setName(String s){name = s;}

    //when attack is pressed triggers the event
    public void event(int attack){
        if (room.getEncounter().equals("Monster")){
            combat(attack);
        }
        if (room.getEncounter().equals("Shop")){
            shop(attack);
        }
        if(health <= 0)
            dead = true;
    }

    //combat (compares self values to monster class values and reduces accordingly)
    public void combat(int attack) {
        int tempa, tempt,tempc;
        Monster m= room.getMonster();

            tempa = m.getAttack();
            tempt = m.getType();
            tempc =compareCombat(attack, tempt);
        //winning combination
        if(tempc == 0){
            health =- tempa/2;
            m.damageMob(2 * attack);
        }
        //tie combination
        if(tempc == 1){
            health =- tempa/2;
            m.damageMob(attack / 2);
        }
        //lose combination
        if(tempc == 2){
            health =- tempa;
            m.damageMob(attack/2);
        }

    }
    //fights the shopkeeper
    public void shop(int attack){
        int tempa, tempt,tempc;
        shopKeeper m = room.getShopKeeper();

        tempa = m.getAttack();
        tempt = m.getType();
        tempc =compareCombat(attack, tempt);
        //winning combination
        if(tempc == 0){
            health =- tempa/2;
            m.damageMob(2*attack);
        }
        //tie combination
        if(tempc == 1){
            health =- tempa/2;
            m.damageMob(attack / 2);
        }
        //lose combination
        if(tempc == 2){
            health =- tempa;
            m.damageMob(attack/2);
        }
    }

    public int compareCombat(int p, int m){
        int winner = 0;
    	//win
        if(p == 0 & m== 1)
            winner = 0;
        if(p == 1 & m ==2)
        	winner = 0;
        if(p == 2 & m == 0)
        	winner = 0;
        //lose
        if(p == 1 & m== 0)
        	winner = 2;
        if(p == 2 & m ==1)
        	winner = 2;
        if(p == 0 & m == 2)
        	winner = 2;
        //tie
        if(p == 0 & m== 0)
            winner = 1;
        if(p == 1 & m ==1)
        	winner = 1;
        if(p == 2 & m == 2)
        	winner = 1;
        return winner;
    }
    //returns the arraylist from inventory that has items in it
    public Inventory getInventory(){
        return inventory;
    }

    //creates a new room
    public void move() throws IOException{
        room = new Room();

    }
    //increments money based on value and removes the item from inventory
    public void sellItem(int i){
        if(inventory.getList().get(i) != null && room.getEncounter().getClass().getName().equals("Shop")) {
            money += 0.75 * (inventory.getList().get(i).getValue());
            inventory.removeItem(i);
        }
    }

    public void moveItem(int i){
        if(room.getChest().getInventory().getList().get(i) != null) {
              Item temp = room.getChest().getInventory().getList().get(i);
            room.getChest().getInventory().getList().remove(i);
            if(inventory.getList().size() < 9)
                inventory.addItem(temp);
        }
    }
    public void removeItem(int i){
        if(inventory.getList().get(i) != null)
            inventory.getList().remove(i);
    }

    //equips an item by moving it to the equipped inventory
    public void equip(int i) {
        if (inventory.getList().get(i) != null) {
            Item temp = inventory.getList().get(i);
            if (temp.getType() == 1 ) {
                inventory.getList().set(i, equipped.getList().get(0));
                equipped.getList().set(0, temp);
            }
            if (temp.getType() == 2 ) {
                inventory.getList().set(i, equipped.getList().get(1));
                equipped.getList().set(1, temp);
            }
            if (temp.getType() == 3 ) {
                inventory.getList().set(i, equipped.getList().get(2));
                equipped.getList().set(2, temp);
            }
        }
    }




}
