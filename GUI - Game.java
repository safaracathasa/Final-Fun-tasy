package dev.huntul.finalfuntasyGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import dev.huntul.finalfuntasyGUI.display.Display;
import dev.huntul.finalfuntasyGUI.gfx.ImageLoader;
import dev.huntul.finalfuntasyGUI.gfx.MediaPlayer;
import dev.huntul.finalfuntasyGUI.gfx.Sound;
import dev.huntul.finalfuntasyGUI.input.KeyManager;

public class Game implements Runnable {
	private boolean running, enterEvent, keyPressed;
	private Thread thread;
	private String title;
	private int height, width, x, y, timer, enter, cursorPos;
	private Display display;
	private BufferStrategy bs;
	private BufferedImage logo, cursor;
	private Graphics g;
	private KeyManager keyManager;
	private Sound cursorSound, prelude;
	
	public Game(String title, int height, int width) {
		this.title = title;
		this.height = height;
		this.width = width;
		keyManager = new KeyManager();
	}
	
	public void init() {
		display = new Display(title,height,width);
		display.getCanvas().setBackground(Color.WHITE);
		display.getFrame().addKeyListener(keyManager);
		logo = ImageLoader.loadImage("/textures/final-fantasy-v.jpg");
		cursor = ImageLoader.loadImage("/textures/FF1_PSP_cursor.png");
		cursorPos = 1;
		cursorSound = new Sound("res/audio/cursor.wav");
		prelude = new Sound("res/audio/prelude.wav");
		prelude.loop();
		prelude.play();
		timer = 0;
		enter = 0;
		enterEvent = false;
		keyPressed = false;
		x = 0;
		y = 0;
	}
	
	public void update() {
		keyManager.update();
		if (keyManager.enter && !keyPressed) {
			enterEvent = true;
			keyPressed = true;
			System.out.println("Enter pressed!");
		}
		if (keyManager.down && enterEvent && !keyPressed) {
			cursorPos = (cursorPos + 1) % 3;
			if (cursorPos == 0) {
				cursorPos = 3;
			}
//			new Thread(new MediaPlayer("D:/Kuliah/STI/Semester 4/Pemograman Berorientasi Objek/Programs/Final Fun-tasy - GUI Test/res/audio/cursor.wav")).start();
			cursorSound.play();
			keyPressed = true;
		}
		if (keyManager.up && enterEvent && !keyPressed) {
			cursorPos = (cursorPos - 1) % 3;
			if (cursorPos == 0) {
				cursorPos = 3;
			}
//			new Thread(new MediaPlayer("D:/Kuliah/STI/Semester 4/Pemograman Berorientasi Objek/Programs/Final Fun-tasy - GUI Test/res/audio/cursor.wav")).start();
			cursorSound.play();
			keyPressed = true;
		}
		if (!keyManager.enter && !keyManager.down && !keyManager.up && keyPressed) {
			keyPressed = false;
		}
		timer++;
		if (timer < 50) {
			x = 220;
			y = 300;
		} else if (timer >= 50 && timer < 100) {
			x = 0;
			y = 0;
		} else {
			timer = 0;
		}
	}
	
	public void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = bs.getDrawGraphics();
		
		// clear screen
		g.clearRect(0, 0, width, height);
		
		// draw start
		g.drawImage(logo, 100, 30, 400, 212, null);
		g.setFont(new Font("Dialog",Font.BOLD,20));
		if (enterEvent) {
			g.drawString("New Game", 245, 280);
			g.drawString("Load Game", 242, 330);
			g.drawString("Exit", 275, 380);
			switch (cursorPos) {
				case 1 : g.drawImage(cursor, 195, 265, 30, 30, null);
						 break;
				case 2 : g.drawImage(cursor, 195, 315, 30, 30, null);
				 		 break;
				case 3 : g.drawImage(cursor, 195, 365, 30, 30, null);
						 break;
			}
		} else {
			g.drawString("PRESS ENTER", x, y);
		}
		g.setFont(new Font("Dialog",Font.BOLD,15));
		g.drawString("2015 Kacang Sari Roti CO.,LTD.All Rights Reserved.", 115, 475);
		
		// draw end
		bs.show();
		g.dispose();
	}
	
	public void run() {
		init();
		
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;
		
		while(running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime  = now;
			
			if(delta >= 1) {
				update();
				render();
				ticks++;
				delta--;
			}
			
			if (timer >= 1000000000) {
				ticks = 0;
				timer = 0;
			}
		}
		stop();
	}
	
	public synchronized void start() {
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
	}
}
