import java.util.Random;
import java.util.Scanner;
public class Battle{ 
    Random rand = new Random();
    int statusBattle = 0; // 0 masih battle, 1 win, 2 lose
    int[] battleOrder = {0,1,2};
    
    public void printStatus(Pemain P, Monster M){
        for(int i=0;i<=2;i++){
            System.out.println("HP "+P.getCharacters()[i].getNama()+": "+P.getCharacters()[i].getCurHP());
            System.out.println("MP "+P.getCharacters()[i].getNama()+": "+P.getCharacters()[i].getCurMP()+"\n");
        }
        System.out.println("HP "+M.getClass()+": "+M.getCurHP()+"\n");
    }
    public void attack(CharacterGame C, Monster M){
        C.useAttack(M);
        System.out.println(C.getNama() + " menyerang " + M.getClass());
    }
    public void magic(CharacterGame C, Monster M){
        //C.useMagic(M);
        System.out.println(C.getNama() + " menggunakan skill kepada " + M.getClass());
    }
    public void item(CharacterGame C, Monster M){
        
    }
    public void monsterAttack(CharacterGame C, Monster M){
        M.useAttack(C);
        System.out.println(M.getClass()+ " Menyerang " + C.getNama());
    }
    public boolean isCharacterDied(CharacterGame C){
        if(C.getCurHP() <= 0){
            C.setCurHP(0);
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isMonsterDied(Monster M){
        return M.getCurHP() <= 0;
    }
    
    public int runBattle(Pemain P, Monster M){
        Scanner in = new Scanner(System.in);
        boolean isNextTurn = false;
        int command,p;
        do{
            for(int j=0;j<=2;j++){
                if(!isCharacterDied(P.getCharacters()[j]))
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
                                            }
                                            case 2: {
                                                magic(P.getCharacters()[j],M);
                                                isNextTurn = true;
                                            }
                                            case 3: {
                                                isNextTurn = true;
                                            }
                                            default: {
                                                System.out.println("Masukan salah! ulangi");
                                            }
                            }
                        } while((command<1)||(command>3));
                    }while(!isNextTurn);
                }
                if(isMonsterDied(M)){
                    statusBattle = 1;
                }
                else{
                    System.out.println("Giliran " + M.getClass());
                    printStatus(P,M);
                    do{
                        p = rand.nextInt(3);
                    } while(isCharacterDied(P.getCharacters()[p]));
                    monsterAttack(P.getCharacters()[p],M);
                    if(isCharacterDied(P.getCharacters()[0]) && isCharacterDied(P.getCharacters()[1]) && isCharacterDied(P.getCharacters()[2])){
                        statusBattle = 2;
                    }
                }
        }while(statusBattle == 0);
        return statusBattle;
    }
}
