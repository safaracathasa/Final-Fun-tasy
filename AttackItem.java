package dev.huntul.finalfuntasy.item;

import dev.huntul.finalfuntasy.character.CharacterGame;


public class AttackItem extends Item {
	public AttackItem(String name, int value, int cost) {
		super(name,value,cost);
	}
	
	public <U> void effectItem(U u) {
		((CharacterGame) u).setCurHP(((CharacterGame) u).getCurHP() + getValue());
	}
}
