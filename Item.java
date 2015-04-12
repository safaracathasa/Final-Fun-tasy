package dev.huntul.finalfuntasy.item;

public abstract class Item {
	private int value;
	private int cost;
	private String desc;
	public Item(int value, int cost, String desc) {
		this.value = value;
		this.cost = cost;
		this.desc = desc;
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
