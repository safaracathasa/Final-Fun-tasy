package finalfuntasy.pemain;

import java.io.Serializable;

import finalfuntasy.character.CharacterGame;
import finalfuntasy.etc.Point;
import finalfuntasy.item.Item;
import finalfuntasy.item.Stock;

public class Pemain implements Serializable {
	private Point posisi;
	private int money;
	private CharacterGame[] characters;
	private Stock[] stocks;
	
	public Pemain(CharacterGame[] characters) {
		posisi = new Point(0,0);
		setMoney(1000);
		this.setCharacters(characters);
		stocks = new Stock[100];
		for (int i = 0; i < stocks.length; i++ ) {
			stocks[i] = null;
		}
	}
	
	public Point getPosisi() {
		return posisi;
	}
	
	public void setPosisi(Point posisi) {
		this.posisi = posisi;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public CharacterGame[] getCharacters() {
		return characters;
	}

	public void setCharacters(CharacterGame[] characters) {
		this.characters = characters;
	}

	public Stock[] getStocks() {
		return stocks;
	}

	public void setStocks(Stock[] stocks) {
		this.stocks = stocks;
	}
	
	public void addItem(Item item) {
		System.out.println("Acquired " + item.getName() + "!");
		int i = 0;
		while (stocks[i] != null) {
			if (item.getName().equals(stocks[i].getItem().getName())) {
				stocks[i].setStock(stocks[i].getStock()+1);
				return;
			}
			i++;
		}
		stocks[i] = new Stock(item,1);
	}
	
	public void delItem(Item item){
		int i = 0;
		while (stocks[i] != null) {
			if (item.getName().equals(stocks[i].getItem().getName())) {
				if (stocks[i].getStock() > 1) {
					stocks[i].setStock(stocks[i].getStock() - 1);
					return;
				} else {
					int j = i;
					for (int k = j+1; k < 100; k++) {
						stocks[j] = stocks[k];
						j++;
						if (k == 99) {
							stocks[k] = null;
							return;
						}
					}
				}
			}
			i++;
		}
	}
}
