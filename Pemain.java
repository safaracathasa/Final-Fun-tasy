package dev.huntul.finalfuntasy.pemain;

import java.io.Serializable;

import dev.huntul.finalfuntasy.character.CharacterGame;
import dev.huntul.finalfuntasy.etc.Point;
import dev.huntul.finalfuntasy.item.Item;
import dev.huntul.finalfuntasy.item.Stock;

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
			if (item.getName() == stocks[i].getItem().getName()) {
				stocks[i].setStock(stocks[i].getStock()+1);
				return;
			}
			i++;
		}
		stocks[i] = new Stock(item,1);
	}
}
