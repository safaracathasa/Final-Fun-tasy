package dev.huntul.finalfuntasy;

import dev.huntul.finalfuntasy.arena.Arena;
import dev.huntul.finalfuntasy.arena.OutOfArenaExcept;
import dev.huntul.finalfuntasy.etc.PosInfo;
import dev.huntul.finalfuntasy.pemain.Pemain;

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
	ObjectOutputStream objectOutputStream;
	private Scanner in;
	private PosInfo pInfo;
	ObjectInputStream objectInputStream;
	
	public Game() {
		pemain = new Pemain();
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
		while (running) {
			printMap(arena.getHeight(),arena.getWidth());
			System.out.println();
			do {
				error = false;
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
