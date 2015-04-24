package dev.huntul.finalfuntasy.item;

import java.util.Random;

public class ItemFactory {
	public static Item createItem() {
		Item item = null;
		Random rand = new Random();
		int token = rand.nextInt(5);
		if ((token == 0) || (token == 1) || (token == 2)) {
			item = new HealingItem("Potion",50,50,1);
		} else if ((token == 3) || (token == 4)) {
			item = new HealingItem("Ether",25,100,2);
		} else {
			item = new AttackItem("Bomb",100,200);
		}
		return item;
	}
}
