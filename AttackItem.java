package dev.huntul.finalfuntasy.item;

import dev.huntul.finalfuntasy.monster.Monster;


public class AttackItem extends Item {
	public AttackItem(String name, int value, int cost) {
		super(name,value,cost);
	}
	
	public <U> void effectItem(U u) {
		((Monster) u).setCurHP(((Monster) u).getCurHP() - getValue());
	}
}
