public class Item{
	private double value;
	private String name; 
	protected int type;
	private int effect;
	
	//this class creates an item object with value = price in store, n = name of item, type being either a potion or weapon or backpack
	public Item(double v, String n,int t){
		value = v;
		name = n;
		type = t;
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

	@Override
	public String toString() {
		return (name +"\n Type: "+ type+"\nValue: "+value);

	}
}
