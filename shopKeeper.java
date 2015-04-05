package CSCIProject; /**creates a shopkeeper for use with the shop
 * Created by David on 2015-03-14.
 */
import java.util.Random;
public class shopKeeper {
    Random rand = new Random();
    private int damage;
    private int health;
    private String name;
    private double price;

    //constructor
    public shopKeeper(){
        name = "CSCIProject.Shop Keeper";
        price = 0.01*(rand.nextInt(150) + 50) ;
        damage = 10;
        health = 20;
    }

    //get/set methods
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }



}
