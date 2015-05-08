package finalfuntasy;

import java.util.Random;
import java.util.Scanner;

import finalfuntasy.character.CharacterGame;
import finalfuntasy.monster.Monster;
import finalfuntasy.pemain.Pemain;

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
        System.out.println();
    }
    public int magic(CharacterGame C, Monster M){
        int i = C.useMagic(M);
        return i;
    }
    public int item(Pemain P, Monster M,int j){
        boolean isDone = false;
                
        System.out.println();
    	if (P.getStocks()[0] == null) {
            System.out.println("--- Inventory ---");
            System.out.println("Empty");
            return 0;
	} else {
            do{
                System.out.println("--- Inventory ---");
                int i = 1;
                while (P.getStocks()[i-1] != null) {
                    System.out.println(i + ". " + P.getStocks()[i-1].getItem().getName() + " : " + P.getStocks()[i-1].getStock());
                    i++;
                }
                System.out.println("\n0. Exit");
                int command, cmd;
                Scanner in = new Scanner(System.in);
                do {
                    System.out.print("\nCommand : ");
                    command = in.nextInt();
                    if (command < 0 || command > i-1) {
                        System.out.println("Command not found!");
                    }
                } while (command < 0 || command > i-1);
                if(command == 0){
                    return 0;
                }
                else if (P.getStocks()[command-1].getItem().getType() == 1) {
                    System.out.println("Choose target :");
                    for (int k = 1; k <= 3; k++) {
                        System.out.println(k + ". " + P.getCharacters()[k-1].getNama());
                    }
                    System.out.println("\n0. Back");
                    do {
                        System.out.print("\nCommand : ");
                        cmd = in.nextInt();
                        if (cmd <0 || cmd > 3) {
                            System.out.println("Command not found!");
                        }
                    } while (cmd < 0 || cmd > 3);
                    switch (cmd) {
                        case 1  :{
                            P.getCharacters()[j].useItem(P.getStocks()[command-1].getItem(), P.getCharacters()[0], M);
                            isDone = true;
                            break;
                        }
                        case 2  :{
                            P.getCharacters()[j].useItem(P.getStocks()[command-1].getItem(), P.getCharacters()[1], M);
                            isDone = true;
                            break;
                        }
                        case 3  :{
                            P.getCharacters()[j].useItem(P.getStocks()[command-1].getItem(), P.getCharacters()[2], M);
                            isDone = true;
                            break;
                        }
                    }
                } else {
                    P.getCharacters()[j].useItem(P.getStocks()[command-1].getItem(), P.getCharacters()[j], M);
                    isDone = true;
                }
                if(isDone){
                    P.delItem(P.getStocks()[command-1].getItem());
                }
            } while(!isDone);
            return 1;
	}
    }
    public void monsterAttack(CharacterGame C, Monster M){
        System.out.println(M.getName()+ " Menyerang " + C.getNama());
        M.useAttack(C);
        System.out.println();
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
        M.printMonster();
        do{
            int j = 0;
            int k = 0;
            while((j <= 2) && !isMonsterDied(M)) {
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
                                                k = magic(P.getCharacters()[j],M);
                                                isNextTurn = (k==1);
                                                break;
                                            }
                                            case 3: {
                                            	k = item(P,M,j);
                                                isNextTurn = (k==1);
                                                break;
                                            }
                                            default: {
                                                System.out.println("Masukan salah! ulangi");
                                            }
                            	}
                        } while((command<1)||(command>3));
                    }while(!isNextTurn);
                }
                j++;
            }
                System.out.println("Tekan untuk melanjutkan...");
                String delay = in.nextLine(); delay = in.nextLine();
                if(isMonsterDied(M)){
                    statusBattle = 1;
                }
                else{
                    M.printMonster();
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
			System.out.println("Congratulation!\n");
        	M.giveMoney(P);
        	System.out.println("Obtain " + M.getMoney() + " Gil\n");
        	for(int i = 0;i<=2;i++){
        		if(!isCharacterDied(P.getCharacters()[i])){
        			int j = 0;
        			while ((j < M.getIncLevel()) && (P.getCharacters()[i].getLV() < 40)) {
        				j++;
        				P.getCharacters()[i].levelUP(1);
        			}
        			if (j == 0) {
        				System.out.println("Max level cap reached");
        			} else {
        				System.out.println(P.getCharacters()[i].getNama() + " increase " + j + " level");
        			}
        		}
        		else{
        			P.getCharacters()[i].setCurHP(1);
        		}
        	}
        }
        return statusBattle;
    }
}
