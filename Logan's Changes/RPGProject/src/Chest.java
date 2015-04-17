import java.util.Random;
import java.io.*;

public class Chest {
	private Inventory inventory;

	//in each chest you'll (3 of 4 chance) find one weapon and (2 of 3) one potion
	public Chest() {
		inventory = new Inventory();
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

		/**rare weapon
		if (ran == 100) {
			int value = 300;
			int type = 4;
			int attack = 10 + mod;
			System.out.println("wow");
			Weapon pooNoo = new Weapon(value, "legendary pool noodle", type, attack);
		}*/

		//determining if potion should be created------------------------------------
		int ranPot = rand.nextInt(100) + 1;

		//if you recieve normal potion
		if (ranPot > 0 && ranPot <= 33) {
			Potion normal = new Potion("normal");
			inventory.addItem(normal);
		} else 
		//super potion
		if (ranPot <= 66) {
			Potion normal = new Potion("super");
			inventory.addItem(normal);
		} else
		//nothing
		if (ranPot <= 99) {
		}
		//super duper potion
		else {
			Potion normal = new Potion("superDuper");
			inventory.addItem(normal);
		}
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public void emptyChest(){
		inventory.clear();
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
}