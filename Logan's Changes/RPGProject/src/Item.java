import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Item{
	private double value;
	private String name; 
	protected int type;
	private int effect;
	private int attack;
	
	//this class creates an item object with value = price in store, n = name of item, type being either a potion or weapon or backpack
	public Item(double v, String n,int t){
		value = v;
		name = n;
		type = t;
		attack = 0;
   }
	public Item(double v, String n,int t, int attack){
		value = v;
		name = n;
		type = t;
		this.attack = attack;
	}
	public Item(){}

	
	public int getEffect() {
		return effect;
	}

	public void setEffect(int effect) {
		this.effect = effect;
	}
	
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int n)
	{
		attack = n;
	}

	public Item generateItem() {
		Inventory inventory = new Inventory();
		Random rand = new Random();
		int ran = rand.nextInt(133) + 1;
		int mod = rand.nextInt(3);

		//if you recieve an axe
		if (ran > 0 && ran <= 33) {
			int value = 70;
			String goodName = naming("axe");
			int type = 1;
			int attack = 1 + mod;
			Weapon axe = new Weapon(value, goodName, type, attack);
			inventory.addItem(axe);//adds axe to inventory not sure syntax not includes for others atm
		}

		//bow
		if (ran > 33 && ran <= 66) {
			int value = 80;
			String goodName = naming("bow");
			int type = 2;
			int attack = 2 + mod;
			Weapon bow = new Weapon(value, goodName, type, attack);
			inventory.addItem(bow);
		}

		//magic
		if (ran > 66 && ran <= 100) {
			int value = 20;
			String goodName = naming("magic");
			int type = 3;
			int attack = 3 + mod;
			Weapon magic = new Weapon(value, goodName, type, attack);
			inventory.addItem(magic);
		}

		//determining if potion should be created------------------------------------
		int ranPot = rand.nextInt(100) + 1;

		//if you recieve normal potion
		if (ranPot > 0 && ranPot <= 33) {
			Potion normal = new Potion("normal");
			inventory.addItem(normal);
		}
		else{
			//super potion
			if (ranPot <= 66) {
				Potion normal = new Potion("super");
				inventory.addItem(normal);
			} 
			else
			//nothing
			if (ranPot <= 99) {
			}
			//super duper potion
			else {
				Potion normal = new Potion("superDuper");
				inventory.addItem(normal);
			}
		}
		return inventory.getList().get(0);
	}

	public String naming(String name) {
		Random rand = new Random();
		int numLine = 0;
		int counter = rand.nextInt(15);
		try {
			if (name.equals("magic")) {
				File file = new File("magic.txt");
				FileReader fileReader = new FileReader(file);
				BufferedReader bufferedReader = new BufferedReader(fileReader);
				StringBuffer stringBuffer = new StringBuffer();
				String line;

				while ((line = bufferedReader.readLine()) != null && numLine <= counter) {
					numLine++;
					if (numLine == counter)
						return line;
				}
				bufferedReader.close();
			}
			if (name.equals("axe")) {
				File file2 = new File("axe.txt");
				FileReader fileReader2 = new FileReader(file2);
				BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
				StringBuffer stringBuffer2 = new StringBuffer();
				String line2;

				while ((line2 = bufferedReader2.readLine()) != null && numLine <= counter) {
					numLine++;
					if (numLine == counter)
						return line2;
				}
				bufferedReader2.close();
			}

			if (name.equals("bow")) {
				File file3 = new File("bow.txt");
				FileReader fileReader3 = new FileReader(file3);
				BufferedReader bufferedReader3 = new BufferedReader(fileReader3);
				StringBuffer stringBuffer3 = new StringBuffer();
				String line3;

				while ((line3 = bufferedReader3.readLine()) != null && numLine <= counter) {
					numLine++;
					if (numLine == counter)
						return line3;
				}

				bufferedReader3.close();

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "Unknown";
	}

	@Override
	public String toString() {
		return (name +"\nType: "+ type+"\nValue: "+value);

	}
}
