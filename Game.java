package dev.huntul.finalfuntasy;

import dev.huntul.finalfuntasy.arena.Arena;
import dev.huntul.finalfuntasy.arena.OutOfArenaExcept;
import dev.huntul.finalfuntasy.character.CharacterGame;
import dev.huntul.finalfuntasy.character.PengendaliBulan;
import dev.huntul.finalfuntasy.character.PengendaliBumi;
import dev.huntul.finalfuntasy.character.PengendaliMatahari;
import dev.huntul.finalfuntasy.etc.MismatchPositionExcept;
import dev.huntul.finalfuntasy.etc.PosInfo;
import dev.huntul.finalfuntasy.item.Item;
import dev.huntul.finalfuntasy.item.ItemFactory;
import dev.huntul.finalfuntasy.monster.MonsterFactory;
import dev.huntul.finalfuntasy.pemain.Pemain;
import dev.huntul.finalfuntasy.shop.OutOfMoneyExcept;
import dev.huntul.finalfuntasy.shop.Shop;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Game {
	private boolean running = false;
	private boolean error;
//	private Thread thread;
	private Pemain pemain;
	private Arena arena;
	private ObjectOutputStream objectOutputStream;
	private Scanner in;
	private PosInfo pInfo;
	private ObjectInputStream objectInputStream;
	private Shop shop;
	
	public Game() {
		System.out.println("--- CHARACTER CREATION ---");
		System.out.println();
		in = new Scanner(System.in);
		CharacterGame[] characters = new CharacterGame[3];
		System.out.print("Nama Pengendali Bumi : ");
		String char1 = in.next();
		characters[0] = new PengendaliBumi(char1);
		System.out.print("Nama Pengendali Bulan : ");
		String char2 = in.next();
		characters[1] = new PengendaliBulan(char2);
		System.out.print("Nama Pengendali Matahari : ");
		String char3 = in.next();
		characters[2] = new PengendaliMatahari(char3);
		pemain = new Pemain(characters);
		arena = new Arena(10,10);
		pInfo = new PosInfo();
		pInfo.plotMonster(pemain.getPosisi().getX(),pemain.getPosisi().getY());
	}

	public Game(String save) {
		try {
			objectInputStream = new ObjectInputStream(new FileInputStream(save));
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			pInfo = (PosInfo) objectInputStream.readObject();
			pemain = (Pemain) objectInputStream.readObject();
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		arena = new Arena(10,10);
	}
	
	public void run() {
		running = true;
		in = new Scanner(System.in);
		shop = new Shop();
		while (running) {
			printMap(arena.getHeight(),arena.getWidth());
			System.out.println();
			do {
				error = false;
				if (pInfo.cekItem(pemain.getPosisi().getX(),pemain.getPosisi().getY())) {
					pInfo.lootItem(pemain.getPosisi().getX(),pemain.getPosisi().getY());
					pemain.addItem(ItemFactory.createItem());
				}
				if (pInfo.cekMonster(pemain.getPosisi().getX(),pemain.getPosisi().getY())) {
					int k = (new Battle()).runBattle(pemain,MonsterFactory.createMonster(pemain.getCharacters()[0],pemain.getCharacters()[1],pemain.getCharacters()[2]));
					if(k==1){
						System.out.println("Congratulation!");
						pInfo.rePlotMonster(pemain.getPosisi().getX(),pemain.getPosisi().getY());
						printMap(arena.getHeight(),arena.getWidth());
						
					}
					else{
						System.out.println("Game Over!");
						return;
					}
					
				}
				System.out.println();
				System.out.print("COMMAND : ");
				String cmd = in.next();
				switch (cmd) {
					case "w" 	: {
						try {
							arena.cekPos(pemain.getPosisi().getX(),pemain.getPosisi().getY()-1);
							pemain.getPosisi().setY(pemain.getPosisi().getY()-1);
						} catch (OutOfArenaExcept e) {
							e.response();
						}
						break;
					}
					case "a" 	: {
						try {
							arena.cekPos(pemain.getPosisi().getX()-1,pemain.getPosisi().getY());
							pemain.getPosisi().setX(pemain.getPosisi().getX()-1);
						} catch (OutOfArenaExcept e) {
							e.response();
						}
						break;
					}
					case "s" 	: {
						try {
							arena.cekPos(pemain.getPosisi().getX(),pemain.getPosisi().getY()+1);
							pemain.getPosisi().setY(pemain.getPosisi().getY()+1);
						} catch (OutOfArenaExcept e) {
							e.response();
						}
						break;
					}
					case "d" 	: {
						try {
							arena.cekPos(pemain.getPosisi().getX()+1,pemain.getPosisi().getY());
							pemain.getPosisi().setX(pemain.getPosisi().getX()+1);
						} catch (OutOfArenaExcept e) {
							e.response();
						}
						break;
					}
					case "q" 	: {
						running = false;
						break;
					}
					case "v" 	: {
						try {
							objectOutputStream = new ObjectOutputStream(new FileOutputStream("save.txt"));
						} catch (IOException e) {
							e.printStackTrace();
						}
						try {
							objectOutputStream.writeObject(pInfo);
							objectOutputStream.writeObject(pemain);
						} catch (IOException e) {
							e.printStackTrace();
						}
						System.out.println("Save successful!");
						error = true;
						break;
					}
					case "t" 	: {
						System.out.println("--- Player Status ---");
						System.out.println("Posisi X 	: " + pemain.getPosisi().getX());
						System.out.println("Posisi Y 	: " + pemain.getPosisi().getY());
						System.out.println("Money		: " + pemain.getMoney());
						
						System.out.println("--- " + pemain.getCharacters()[0].getNama() + " Status ---");
						System.out.println("Level	 	: " + pemain.getCharacters()[0].getLV());
						System.out.println("HP		: " + pemain.getCharacters()[0].getCurHP() + "/" + pemain.getCharacters()[0].getMaxHP());
						System.out.println("MP		: " + pemain.getCharacters()[0].getCurMP() + "/" + pemain.getCharacters()[0].getMaxMP());
						System.out.println("STR 		: " + pemain.getCharacters()[0].getSTR());
						System.out.println("VIT 		: " + pemain.getCharacters()[0].getVIT());
						System.out.println("INT 		: " + pemain.getCharacters()[0].getINT());
						System.out.println("Job 		: " + pemain.getCharacters()[0].getJob());
						
						System.out.println("--- " + pemain.getCharacters()[1].getNama() + " Status ---");
						System.out.println("Level	 	: " + pemain.getCharacters()[1].getLV());
						System.out.println("HP		: " + pemain.getCharacters()[1].getCurHP() + "/" + pemain.getCharacters()[0].getMaxHP());
						System.out.println("MP		: " + pemain.getCharacters()[1].getCurMP() + "/" + pemain.getCharacters()[0].getMaxMP());
						System.out.println("STR 		: " + pemain.getCharacters()[1].getSTR());
						System.out.println("VIT 		: " + pemain.getCharacters()[1].getVIT());
						System.out.println("INT 		: " + pemain.getCharacters()[1].getINT());
						System.out.println("Job 		: " + pemain.getCharacters()[1].getJob());
						
						System.out.println("--- " + pemain.getCharacters()[2].getNama() + " Status ---");
						System.out.println("Level	 	: " + pemain.getCharacters()[2].getLV());
						System.out.println("HP		: " + pemain.getCharacters()[2].getCurHP() + "/" + pemain.getCharacters()[0].getMaxHP());
						System.out.println("MP		: " + pemain.getCharacters()[2].getCurMP() + "/" + pemain.getCharacters()[0].getMaxMP());
						System.out.println("STR 		: " + pemain.getCharacters()[2].getSTR());
						System.out.println("VIT 		: " + pemain.getCharacters()[2].getVIT());
						System.out.println("INT 		: " + pemain.getCharacters()[2].getINT());
						System.out.println("Job 		: " + pemain.getCharacters()[2].getJob());

						System.out.println("--- Inventory ---");
						if (pemain.getStocks()[0] == null) {
							System.out.println("Empty");
						} else {
							int i = 1;
							while (pemain.getStocks()[i-1] != null) {
								System.out.println(i + ". " + pemain.getStocks()[i-1].getItem().getName() + " : " + pemain.getStocks()[i-1].getStock());
								i++;
							}
						}
						
						error = true;
						break;
					}
					case "h" 	: {
						try {
							pInfo.isToko(pemain.getPosisi().getX(),pemain.getPosisi().getY());
							shop.showItem();
							int pil;
							do {
								System.out.println();
								System.out.print("Pilihan : ");
								pil = in.nextInt();
								if (pil > shop.getItems().length) {
									System.out.println("Pilihan salah, ulangi!");
								}
							} while (pil > shop.getItems().length);
							try {
								shop.cekMoney(pemain.getMoney(),shop.getItems()[pil-1].getCost());
								shop.buyItem(shop.getItems()[pil-1],pemain);
							} catch (OutOfMoneyExcept e) {
								e.response();
							}
						} catch (MismatchPositionExcept e) {
							e.response();
						}
						
						error = true;
						break;
					}
					
					case "m" 	: {			
						printMap(arena.getHeight(),arena.getWidth());
						System.out.println();
						error = true;
						break;
					}
					
					default		: {
						System.out.println("Command not found!");
						error = true;
						break;
					}
				}
			} while (error);
		}
//		stop();
	}
	
/*	public synchronized void start() {
		if (running) {
			return;
		}
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	public synchronized void stop() {
		if (!running) {
			return;
		}
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}*/
	
	public void printMap(int height, int width) {
		for (int i = 0; i < (width*2)+3; i++) {
			System.out.print("_");
		}
		System.out.println();

		System.out.print("|");
		for (int i = 0; i < (width*2)+1; i++) {
			System.out.print(" ");
		}
		System.out.println("|");
		System.out.print("|");
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(" " + printPos(j,i));
			}
			System.out.println(" |");
			if (i < height-1)
				System.out.print("|");
		}
		System.out.print("|");
		for (int i = 0; i < (width*2)+1; i++) {
			System.out.print("_");
		}
		System.out.println("|");
	}
	
	public String printPos(int x, int y) {
		if (pInfo.cekToko(x,y)) {
			if ((pemain.getPosisi().getX() == x) && (pemain.getPosisi().getY() == y)) {
				return "x";
			} else {
				return "s";
	 		}
		} else if (pInfo.cekItem(x,y)) {
			if ((pemain.getPosisi().getX() == x) && (pemain.getPosisi().getY() == y)) {
				return "x";
			} else {
				return "i";
			}
		} else if (pInfo.cekMonster(x,y)) {
			if ((pemain.getPosisi().getX() == x) && (pemain.getPosisi().getY() == y)) {
				return "x";
			} else {
				return "m";
			}
		} else {
			if ((pemain.getPosisi().getX() == x) && (pemain.getPosisi().getY() == y)) {
				return "x";
			} else {
				return " ";
			}
		}
	}
}
