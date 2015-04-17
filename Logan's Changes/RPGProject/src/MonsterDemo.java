import java.io.*;
public class MonsterDemo {
	
	public static void main(String[] args) throws IOException{
		
		RoomBasic room = new RoomBasic();
		System.out.println(room.getMob().toString());
		room.getMob().damageMob(20);
		System.out.println(room.getMob().toString());
		room.getMob().healMob(10);
		System.out.println(room.getMob().toString());
		room.getMob().healMob(20);
		System.out.println(room.getMob().toString());
		room.getMob().killMonster();
		System.out.println(room.getMob().toString());
		
		Player player = new Player();
		player.combat(2);
		System.out.println(player.getHealth());
		System.out.println(player.getRoom());
	}

}
