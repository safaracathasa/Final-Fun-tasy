package dev.huntul.finalfuntasy.item;

import dev.huntul.finalfuntasy.character.CharacterGame;
import dev.huntul.finalfuntasy.monster.Monster;


public class HealingItem extends Item {
	private int id;
	public HealingItem(String name, int value, int cost, int id) {
		super(name,value,cost);
		this.id = id;
	}

	public void effectItem(CharacterGame chars, Monster monster) {
		if (id == 1) {
			chars.setCurHP(chars.getCurHP() + getValue());
			if (chars.getCurHP() >= chars.getMaxHP()) {
				chars.setCurHP(chars.getMaxHP());
			}
		} else {
			chars.setCurMP(chars.getCurMP() + getValue());
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
