package finalfuntasy.item;

import java.io.Serializable;

import finalfuntasy.character.CharacterGame;
import finalfuntasy.monster.Monster;

public abstract class Item implements Serializable {
	protected int value;
	protected int cost;
	protected int type;
	protected String name;
	public Item(String name, int value, int cost) {
		this.value = value;
		this.cost = cost;
		this.setName(name);
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public abstract void effectItem(CharacterGame chars, Monster monster);
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
