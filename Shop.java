package dev.huntul.finalfuntasy.shop;

import dev.huntul.finalfuntasy.item.HealingItem;
import dev.huntul.finalfuntasy.item.Item;
import dev.huntul.finalfuntasy.item.Stock;
import dev.huntul.finalfuntasy.item.SupportItem;
import dev.huntul.finalfuntasy.pemain.Pemain;

public class Shop {
	private Item[] items;

	public Shop() {
		items = new Item[3];
		items[0] = new HealingItem("Potion",50,50);
		items[1] = new HealingItem("Ether",25,100);
		items[2] = new SupportItem("Bomb",100,200);
	}
	
	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}
	
	public void showItem() {
		System.out.println("List item yang dijual : ");
		for (int i = 1; i <= items.length; i++) {
			System.out.println(i + ". " + items[i-1].getName() + " : " + items[i-1].getCost() + " Gil");
		}
	}
	
	public void cekMoney(int money, int cost) throws OutOfMoneyExcept {
		if (money - cost < 0) {
			throw new OutOfMoneyExcept("Not enough money!");
		}
	}
	
	public void buyItem(Item item, Pemain pemain) {
		pemain.setMoney(pemain.getMoney()-item.getCost());
		System.out.println("Terima kasih!");
		int i = 0;
		while (pemain.getStocks()[i] != null) {
			if (item == pemain.getStocks()[i].getItem()) {
				pemain.getStocks()[i].setStock(pemain.getStocks()[i].getStock()+1);
				return;
			}
			i++;
		}
		pemain.getStocks()[i] = new Stock(item,1);
	}
}
