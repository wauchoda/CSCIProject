/**
 * Created by David on 2015-03-14.
 */
public class Shop {
    private shopKeeper sk;
    private Inventory inventory;
    private Item item;

    public Shop(){
        sk = new shopKeeper();
        inventory = new Inventory();
        item = new Item();
        for(int i = 0; i< 4; i++){
            inventory.addItem(item.generateItem());
        }
    }

    public Item buyItem(int i) {
        Item temp = inventory.getList().get(i);
        if (Player.money > inventory.getList().get(i).getValue()) {
            Player.money -= inventory.getList().get(i).getValue();
            inventory.getList().remove(i);
            return temp;
        }
        return null;
    }

    public shopKeeper getShopKeeper() {
        return sk;
    }

    public void setShopKeeper(shopKeeper sk) {
        this.sk = sk;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }
}
