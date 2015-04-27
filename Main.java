package finalfuntasy;

import java.util.Scanner;

public class Main {
	private static int cmd;
	private static boolean running = false;
	public static void main(String[] args) {
		running = true;
		Scanner in = new Scanner(System.in);
		System.out.println("--- Final Funtasy V ---");
		System.out.println();
		do {
			System.out.println();
			System.out.println("===== MAIN MENU =====");
			System.out.println();
			System.out.println("1. New Game");
			System.out.println("2. Load Game");
			System.out.println("3. Exit Game");
			System.out.println();
			System.out.print("COMMAND : ");
			cmd = in.nextInt();
			switch (cmd) {
				case 1	: 	{
								System.out.println();
								System.out.println("New Game");
								Game game = new Game();
								game.run();
								break;
							}
				case 2	: 	{
								System.out.println();
								System.out.println("Load Game");
								Game game = new Game("save.txt");
								game.run();
								break;
							}
				case 3	: 	{
								System.out.println();
								System.out.println("Exit");
								running = false;
								break;
							}
				default	: 	{
								System.out.println("Command not found!");
								break;
							}
			}
		} while (running);
	}
}
