package dev.huntul.finalfuntasy.etc;
import java.io.Serializable;
import java.util.Random;

public class PosInfo implements Serializable {
	private int[] posMonsterX = new int[20];
	private int[] posMonsterY = new int[20];
	public PosInfo() {
		
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
    
    	public void isToko(int x, int y) throws MismatchPositionExcept {
		if (!cekToko(x,y)) {
			throw new MismatchPositionExcept("Hanya bisa membeli item di toko!");
		}
	}
    
    public boolean cekItem(int x, int y) {
        // Mengembalikan True jika posisi pemain tepat berada pada posisi item
        // Silakan diedit bagian "KONSTANTA", menyesuaikan dengan kebutuhan

        // KONSTANTA
        // posisi item 01
        int x01 = 2;
        int y01 = 1;
        // posisi item 02
        int x02 = 9;
        int y02 = 9;
        // posisi item 03
        int x03 = 5;
        int y03 = 2;
        // posisi item 04
        int x04 = 0;
        int y04 = 7;
        // posisi item 05
        int x05 = 3;
        int y05 = 0;
        // posisi item 06
        int x06 = 7;
        int y06 = 6;
        // posisi item 07
        int x07 = 2;
        int y07 = 9;
        // posisi item 08
        int x08 = 9;
        int y08 = 7;
        // posisi item 09
        int x09 = 1;
        int y09 = 5;
        // posisi item 10
        int x10 = 4;
        int y10 = 4;
        
        // PENGECEKAN
        boolean test01 = (x==x01 && y==y01);
        boolean test02 = (x==x02 && y==y02);
        boolean test03 = (x==x03 && y==y03);
        boolean test04 = (x==x04 && y==y04);
        boolean test05 = (x==x05 && y==y05);
        boolean test06 = (x==x06 && y==y06);
        boolean test07 = (x==x07 && y==y07);
        boolean test08 = (x==x08 && y==y08);
        boolean test09 = (x==x09 && y==y09);
        boolean test10 = (x==x10 && y==y10);
        
        return(test01||test02||test03||test04||test05||test06||test07||test08||test09||test10);
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
