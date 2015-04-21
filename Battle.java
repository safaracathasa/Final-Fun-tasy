// Kelas Battle, V1.01

import java.util.Random;
import java.util.Scanner;
public class Battle{ 
    Random rand = new Random();
    String[] monsterName = {"Kingsman","Behemoth","Marlboro"};
    int statusBattle = 0; // 0 masih battle, 1 win, 2 lose
    int i = rand.nextInt(3);
    Monster M = new ?(monsterName[i]);
    
    public void printStatus(Pemain P){
        for(int i=0;i<=2;i++){
            System.out.println("HP "+P.getCharacters()[i].getName()+": "+P.getCharacters()[i].getCurHP());
            System.out.println("MP "+P.getCharacters()[i].getName()+": "+P.getCharacters()[i].getCurMP()+"\n");
        }
        System.out.println("HP "+M.getClass()+": "+M.getCurHP()+"\n");
    }
    
    public void runBattle(Pemain P){
        Scanner in = new Scanner(System.in);
        int command;
        do{
            for(int j=0;j<=2;j++){
                    System.out.println("Giliran " + P.getCharacters()[j].getName());
                    printStatus(P);
                    System.out.println("(1)Attack, (2)Magic, (3)Item");
                do{
                    command = in.nextInt();
                    switch (command) {
                                    case 1: {
                                        P.getCharacters()[j].useAttack(M);
                                        System.out.println(P.getCharacters()[j].getName() + " menyerang " + M.getClass());
                                        
                                    }
                                    case 2: { 
                                        System.out.println("Pilih Magic");
                                        for(int i=0;i<"Magic".length;i++){
                                            System.out.println("(" + i + ") " + "Magic"[i].name);
                                        }
                                        int k = in.nextInt();
                                        //try catch untuk mana-nya, implementasi ya tul wkwk
                                        P.getCharacters()[j].useMagic(M);
                                    }
                                    case 3: { // kelas itemnya dibuat duluu
                                            
                                    }
                                    default: {
                                        System.out.println("Masukan salah! ulangi");
                                    }
                    }
                } while((command<1)||(command>3));
            }
            System.out.println("Giliran " + M.getClass());
            printStatus(P);
            M.useAttack(P.getCharacters()[rand.nextInt(3)]);
        }while(statusBattle == 0);
        
    }
}
