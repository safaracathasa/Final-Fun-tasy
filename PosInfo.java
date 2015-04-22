// Kelas PosInfo V1.03

package dev.huntul.finalfuntasy.etc;
import java.io.Serializable;
import java.util.Random;

public class PosInfo implements Serializable {
	private int[] posMonsterX = new int[20];
	private int[] posMonsterY = new int[20];
	private int[] posItemX = new int[10];
	private int[] posItemY = new int[10];
	private int[] lootItemX = new int[10];
	private int[] lootItemY = new int[10];
	private int iEff = 0;
	
	public PosInfo() {
		
	}
	
	public int getItem(){
		
		// Posisi item
		int[] potion = {0,3,7,9}; // 1
		int[] ether = {1,2,8}; // 2
		int[] bomb = {4,5,6}; // 3
		int i;
		
		for(i==0;i<potion.length;i++){
			if(lootItemX[iEff] == posItemX[potion[i]]){
				return 1;
			}
		}
		for(i==0;i<ether.length;i++){
			if(lootItemX[iEff] == posItemX[ether[i]]){
				return 2;
			}
		}
		for(i==0;i<bomb.length;i++){
			if(lootItemX[iEff] == posItemX[bomb[i]]){
				return 3;
			}
		}
	}
	
	public boolean cekToko(int x, int y) {
        // Mengembalikan True jika posisi pemain tepat berada pada posisi toko
        // Silakan diedit bagian "KONSTANTA", menyesuaikan dengan kebutuhan

        // KONSTANTA
        // posisi toko 1
        int x1 = 0;
        int y1 = 9;
        // posisi toko 2
        int x2 = 7;
        int y2 = 8;
        // posisi toko 3
        int x3 = 0;
        int y3 = 4;
        // posisi toko 4
        int x4 = 9;
        int y4 = 1;
        // posisi toko 5
        int x5 = 5;
        int y5 = 5;
        
        // PENGECEKAN
        boolean test1 = (x==x1 && y==y1);
        boolean test2 = (x==x2 && y==y2);
        boolean test3 = (x==x3 && y==y3);
        boolean test4 = (x==x4 && y==y4);
        boolean test5 = (x==x5 && y==y5);
        
        return(test1||test2||test3||test4||test5);
    }
    public void lootItem(int x, int y){
    	lootItemX[iEff] = x;
    	lootItemY[iEff] = y;
    	iEff = iEff + 1;
    }
    public boolean cekItem(int x, int y) {
        // Mengembalikan True jika posisi pemain tepat berada pada posisi item
        // Silakan diedit bagian "KONSTANTA", menyesuaikan dengan kebutuhan

        // KONSTANTA
        // posisi item 01
        posItemX[0] = 2;
        posItemY[0] = 1;
        // posisi item 02
        posItemX[1] = 9;
        posItemY[1] = 9;
        // posisi item 03
        posItemX[2] = 5;
        posItemY[2] = 2;
        // posisi item 04
        posItemX[3] = 0;
        posItemY[3] = 7;
        // posisi item 05
        posItemX[4] = 3;
        posItemY[4] = 0;
        // posisi item 06
        posItemX[5] = 7;
        posItemY[5] = 6;
        // posisi item 07
        posItemX[6] = 2;
        posItemY[6] = 9;
        // posisi item 08
        posItemX[7] = 9;
        posItemY[7] = 7;
        // posisi item 09
        posItemX[8] = 1;
        posItemY[8] = 5;
        // posisi item 10
        posItemX[9] = 4;
        posItemY[9] = 4;
        
        // PENGECEKAN
        
        boolean test01 = (x==posItemX[0] && y==posItemY[0]);
        boolean test02 = (x==posItemX[1] && y==posItemY[1]);
        boolean test03 = (x==posItemX[2] && y==posItemY[2]);
        boolean test04 = (x==posItemX[3] && y==posItemY[3]);
        boolean test05 = (x==posItemX[4] && y==posItemY[4]);
        boolean test06 = (x==posItemX[5] && y==posItemY[5]);
        boolean test07 = (x==posItemX[6] && y==posItemY[6]);
        boolean test08 = (x==posItemX[7] && y==posItemY[7]);
        boolean test09 = (x==posItemX[8] && y==posItemY[8]);
        boolean test10 = (x==posItemX[9] && y==posItemY[9]);
        
        boolean isLooted = false;
        for(int i=0;i<iEff;i++){
        	isLooted = isLooted || (lootItemX[i] == x && lootItemY[i] = y);
        }
        
        return((test01||test02||test03||test04||test05||test06||test07||test08||test09||test10)&&(!isLooted));
    }
    
public void plotMonster(int x, int y) {
        
        boolean isSameAsItemOrToko;
        boolean isSameAsOtherMonster;
        boolean isSameAsPemain;
        
        Random rand = new Random();
        for(int i = 0;i<20;i++){
            do{
                posMonsterX[i] = rand.nextInt(9);
                posMonsterY[i] = rand.nextInt(9);
                isSameAsPemain = ((posMonsterX[i] == x) && (posMonsterY[i] == y));
                isSameAsItemOrToko = cekItem(posMonsterX[i],posMonsterY[i]) || cekToko(posMonsterX[i],posMonsterY[i]);
                isSameAsOtherMonster = false;
                for(int j=0;j<i;j++){
                    isSameAsOtherMonster = isSameAsOtherMonster || ((posMonsterX[i] == posMonsterX[j])&&(posMonsterY[i] == posMonsterY[j]));
                }
            } while(isSameAsItemOrToko || isSameAsOtherMonster || isSameAsPemain);
        }
    }
    public boolean cekMonster(int x, int y) {
        // Mengembalikan True jika posisi pemain tepat berada pada posisi monster
    	

    	 // posisi item 01
        int x01 = 8;
        int y01 = 8;
    	
        // PENGECEKAN
        boolean test01 = (x==posMonsterX[0] && y==posMonsterY[0]);
        boolean test02 = (x==posMonsterX[1] && y==posMonsterY[1]);
        boolean test03 = (x==posMonsterX[2] && y==posMonsterY[2]);
        boolean test04 = (x==posMonsterX[3] && y==posMonsterY[3]);
        boolean test05 = (x==posMonsterX[4] && y==posMonsterY[4]);
        boolean test06 = (x==posMonsterX[5] && y==posMonsterY[5]);
        boolean test07 = (x==posMonsterX[6] && y==posMonsterY[6]);
        boolean test08 = (x==posMonsterX[7] && y==posMonsterY[7]);
        boolean test09 = (x==posMonsterX[8] && y==posMonsterY[8]);
        boolean test10 = (x==posMonsterX[9] && y==posMonsterY[9]);
        boolean test11 = (x==posMonsterX[10] && y==posMonsterY[10]);
        boolean test12 = (x==posMonsterX[11] && y==posMonsterY[11]);
        boolean test13 = (x==posMonsterX[12] && y==posMonsterY[12]);
        boolean test14 = (x==posMonsterX[13] && y==posMonsterY[13]);
        boolean test15 = (x==posMonsterX[14] && y==posMonsterY[14]);
        boolean test16 = (x==posMonsterX[15] && y==posMonsterY[15]);
        boolean test17 = (x==posMonsterX[16] && y==posMonsterY[16]);
        boolean test18 = (x==posMonsterX[17] && y==posMonsterY[17]);
        boolean test19 = (x==posMonsterX[18] && y==posMonsterY[18]);
        boolean test20 = (x==posMonsterX[19] && y==posMonsterY[19]);
     
        return(test01||test02||test03||test04||test05||test06||test07||test08||test09||test10||test11||test12||test13||test14||test15||test16||test17||test18||test19||test20);
    }
}
