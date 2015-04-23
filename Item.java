package dev.huntul.finalfuntasy.item;

import java.io.Serializable;

public abstract class Item implements Serializable {
	private int value;
	private int cost;
	private String name;
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
	public abstract <U> void effectItem(U u);
}
