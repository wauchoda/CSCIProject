public class Item{
	private double value;
	private String name; 
	protected String type;
	private int effect;
	
	//this class creates an item object with value = price in store, n = name of item, type being either a potion or weapon or backpack
	public Item(double v, String n,String t){
		v = value;
		n = name;
		t = type;
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
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
