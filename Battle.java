package dev.huntul.finalfuntasy;

import java.util.Random;
import java.util.Scanner;

import dev.huntul.finalfuntasy.character.CharacterGame;
import dev.huntul.finalfuntasy.monster.Monster;
import dev.huntul.finalfuntasy.pemain.Pemain;

public class Battle{ 
    Random rand = new Random();
    int statusBattle = 0; // 0 masih battle, 1 win, 2 lose
    
    public void printStatus(Pemain P, Monster M){
        for(int i=0;i<=2;i++){
            System.out.println("HP "+P.getCharacters()[i].getNama()+": "+P.getCharacters()[i].getCurHP() + "/" + P.getCharacters()[i].getMaxHP());
            System.out.println("MP "+P.getCharacters()[i].getNama()+": "+P.getCharacters()[i].getCurMP() + "/" + P.getCharacters()[i].getMaxMP()+"\n");
        }
        System.out.println("HP "+M.getName() +": "+M.getCurHP()+"/"+M.getmaxHP()+"\n");
    }
    public void attack(CharacterGame C, Monster M){
        System.out.println();
        System.out.println(C.getNama() + " menyerang " + M.getName());
        C.useAttack(M);
    }
    public void magic(CharacterGame C, Monster M){
        System.out.println();
        System.out.println(C.getNama() + " menggunakan skill kepada " + M.getName());
        C.useMagic(M);
        System.out.println();
    }
    public void item(Pemain P, Monster M,int j){
        System.out.println();
    	if (P.getStocks()[0] == null) {
            System.out.println("--- Inventory ---");
			System.out.println("Empty");
		} else {
	        System.out.println("--- Inventory ---");
			int i = 1;
			while (P.getStocks()[i-1] != null) {
				System.out.println(i + ". " + P.getStocks()[i-1].getItem().getName() + " : " + P.getStocks()[i-1].getStock());
				i++;
			}
			int command;
			do {
		        Scanner in = new Scanner(System.in);
				System.out.print("\nCommand : ");
				command = in.nextInt();
				if (command <1 || command > i-1) {
					System.out.println("Command not found!");
				}
			} while (command < 1 || command > i-1);
			P.getCharacters()[j].useItem(P.getStocks()[command-1].getItem(), P.getCharacters()[j], M);
			P.delItem(P.getStocks()[command-1].getItem());
		}
        System.out.println();
    }
    public void monsterAttack(CharacterGame C, Monster M){
        M.useAttack(C);
        System.out.println(M.getName()+ " Menyerang " + C.getNama());
    }
    public boolean isCharacterDied(CharacterGame C){
        return C.getCurHP() <= 0;
    }
    
    public boolean isMonsterDied(Monster M){
        return M.getCurHP() <= 0;
    }
    
    public int runBattle(Pemain P, Monster M){
        Scanner in = new Scanner(System.in);
        boolean isNextTurn = false;
        int command,p;
        System.out.println("Encounter a monster!");
        System.out.println();
        System.out.println(M.getName() + " draws near!");
        System.out.println();
        do{
            for(int j=0;j<=2;j++){
                if(!isCharacterDied(P.getCharacters()[j])){
                    isNextTurn = false;
                    do{
                        System.out.println("Giliran " + P.getCharacters()[j].getNama());
                        printStatus(P,M);
                        System.out.println("(1)Attack, (2)Magic, (3)Item");
                        do{
                            command = in.nextInt();
                            switch (command) {
                                            case 1: {
                                                attack(P.getCharacters()[j],M);
                                                isNextTurn = true;
                                                break;
                                            }
                                            case 2: {
                                                magic(P.getCharacters()[j],M);
                                                isNextTurn = true;
                                                break;
                                            }
                                            case 3: {
                                            	item(P,M,j);
                                                isNextTurn = true;
                                                break;
                                            }
                                            default: {
                                                System.out.println("Masukan salah! ulangi");
                                            }
                            	}
                        } while((command<1)||(command>3));
                    }while(!isNextTurn);
                }
            }
            
                if(isMonsterDied(M)){
                    statusBattle = 1;
                }
                else{
                    System.out.println("Giliran " + M.getName());
                    printStatus(P,M);
                    do{
                        p = rand.nextInt(3);
                    } while(isCharacterDied(P.getCharacters()[p]));
                    monsterAttack(P.getCharacters()[p],M);
                    if(isCharacterDied(P.getCharacters()[p])){
                    	P.getCharacters()[p].setCurHP(0);
                    }
                    if(isCharacterDied(P.getCharacters()[0]) && isCharacterDied(P.getCharacters()[1]) && isCharacterDied(P.getCharacters()[2])){
                        statusBattle = 2;
                    }
                }
        }while(statusBattle == 0);
        if(statusBattle == 1){
        	M.giveMoney(P);
        	for(int i = 0;i<=2;i++){
        		if(!isCharacterDied(P.getCharacters()[i])){
        			P.getCharacters()[i].levelUP(M.getIncLevel());
        		}
        		else{
        			P.getCharacters()[i].setCurHP(1);
        		}
        	}
        }
        return statusBattle;
    }
}
