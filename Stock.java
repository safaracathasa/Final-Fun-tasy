package dev.huntul.finalfuntasy.item;

import java.io.Serializable;

public class Stock implements Serializable {
	private Item item;
	private int stock;
	public Stock(Item item, int stock) {
		this.item = item;
		this.stock = stock;
	}
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
}
