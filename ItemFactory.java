package finalfuntasy.item;

import java.util.Random;

public class ItemFactory {
	public static Item createItem() {
		Item item = null;
		Random rand = new Random();
		int token = rand.nextInt(6);
		if ((token == 0) || (token == 1) || (token == 2)) {
			item = new HealingItem("Potion",200,50,1);
		} else if ((token == 3) || (token == 4)) {
			item = new HealingItem("Ether",100,100,2);
		} else {
			item = new AttackItem("Bomb",300,200);
		}
		return item;
	}
}
