package dev.huntul.finalfuntasy;

import dev.huntul.finalfuntasy.arena.Arena;
import dev.huntul.finalfuntasy.arena.OutOfArenaExcept;
import dev.huntul.finalfuntasy.etc.PosInfo;
import dev.huntul.finalfuntasy.pemain.Pemain;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
	private boolean running = false;
	private boolean error;
	private int x,y;
//	private Thread thread;
	private Pemain pemain;
	private Arena arena;
	private FileWriter f;
	private Scanner reader, in;
	private PosInfo pInfo;
	
	public Game() {
		pemain = new Pemain();
		arena = new Arena(10,10);
		pInfo = new PosInfo();
	}

	public Game(String save) {
		try {
			reader = new Scanner(new FileInputStream(save));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (reader.hasNext()) {
			x = reader.nextInt();
			y = reader.nextInt();
		}
		pemain = new Pemain(x,y);
		arena = new Arena(10,10);
		pInfo = new PosInfo();
	}
	
	public void run() {
		running = true;
		in = new Scanner(System.in);
		while (running) {
			do {
				error = false;
				printMap(arena.getHeight(),arena.getWidth());
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
							try {
								f = new FileWriter(new File("save.txt"));
							} catch (IOException e1) {
								e1.printStackTrace();
							}
							f.write(pemain.getPosisi().getX() + " " + pemain.getPosisi().getY() + "\n");
							System.out.println("Game berhasil di-save!");
							f.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
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
		} else {
			if ((pemain.getPosisi().getX() == x) && (pemain.getPosisi().getY() == y)) {
				return "x";
			} else {
				return " ";
			}
		}
	}
}
