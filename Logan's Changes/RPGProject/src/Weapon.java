public class Weapon extends Item
{
	private int attack;

	public Weapon(int a, String name, int type, int attack2){
		super(a,name,type,attack2);
		a = attack;
	}
	//get set methods
	public int getAttack()
	{
		return attack;
	}

	public void setAttack(int n)
	{
		attack = n;
	}
}