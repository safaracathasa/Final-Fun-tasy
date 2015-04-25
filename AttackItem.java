package dev.huntul.finalfuntasy.item;

import dev.huntul.finalfuntasy.character.CharacterGame;
import dev.huntul.finalfuntasy.monster.Monster;


public class AttackItem extends Item {
	public AttackItem(String name, int value, int cost) {
		super(name,value,cost);
		setType(2);
	}
	
	public void effectItem(CharacterGame chars, Monster monster) {
		monster.setCurHP(monster.getCurHP() - getValue());
		System.out.println("Hit " + getValue() + " damage!");
	}
}
