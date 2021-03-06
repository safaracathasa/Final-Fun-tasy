package finalfuntasy.item;

import finalfuntasy.character.CharacterGame;
import finalfuntasy.monster.Monster;


public class HealingItem extends Item {
	private int id;
	public HealingItem(String name, int value, int cost, int id) {
		super(name,value,cost);
		this.id = id;
		setType(1);
	}

	public void effectItem(CharacterGame chars, Monster monster) {
		if (id == 1) {
			chars.setCurHP(chars.getCurHP() + getValue());
			System.out.println("Use " + getName() + " on " + chars.getNama());
			System.out.println("Healed " + getValue() + " HP");
			if (chars.getCurHP() >= chars.getMaxHP()) {
				chars.setCurHP(chars.getMaxHP());
			}
		} else {
			chars.setCurMP(chars.getCurMP() + getValue());
			System.out.println("Use " + getName() + " on " + chars.getNama());
			System.out.println("Healed " + getValue() + " MP");
			if (chars.getCurMP() >= chars.getMaxMP()) {
				chars.setCurMP(chars.getMaxMP());
			}
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
