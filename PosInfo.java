package dev.huntul.finalfuntasy.etc;

public class PosInfo {
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
    
    public boolean cekMonster(int x, int y) {
        // Mengembalikan True jika posisi pemain tepat berada pada posisi monster
        // Silakan diedit bagian "KONSTANTA", menyesuaikan dengan kebutuhan

        // KONSTANTA
        // posisi monster 01
        int x01 = 1;
        int y01 = 1;
        // posisi monster 02
        int x02 = 2;
        int y02 = 2;
        // posisi monster 03
        int x03 = 3;
        int y03 = 3;
        // posisi monster 04
        int x04 = 4;
        int y04 = 4;
        // posisi monster 05
        int x05 = 5;
        int y05 = 5;
        // posisi monster 06
        int x06 = 6;
        int y06 = 6;
        // posisi monster 07
        int x07 = 7;
        int y07 = 7;
        // posisi monster 08
        int x08 = 8;
        int y08 = 8;
        // posisi monster 09
        int x09 = 9;
        int y09 = 9;
        // posisi monster 10
        int x10 = 0;
        int y10 = 0;
        // posisi monster 11
        int x11 = 0;
        int y11 = 2;
        // posisi monster 12
        int x12 = 1;
        int y12 = 3;
        // posisi monster 13
        int x13 = 2;
        int y13 = 4;
        // posisi monster 14
        int x14 = 3;
        int y14 = 5;
        // posisi monster 15
        int x15 = 4;
        int y15 = 6;
        // posisi monster 16
        int x16 = 5;
        int y16 = 7;
        // posisi monster 17
        int x17 = 6;
        int y17 = 8;
        // posisi monster 18
        int x18 = 7;
        int y18 = 9;
        // posisi monster 19
        int x19 = 8;
        int y19 = 0;
        // posisi monster 20
        int x20 = 0;
        int y20 = 3;
        
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
        boolean test11 = (x==x11 && y==y11);
        boolean test12 = (x==x12 && y==y12);
        boolean test13 = (x==x13 && y==y13);
        boolean test14 = (x==x14 && y==y14);
        boolean test15 = (x==x15 && y==y15);
        boolean test16 = (x==x16 && y==y16);
        boolean test17 = (x==x17 && y==y17);
        boolean test18 = (x==x18 && y==y18);
        boolean test19 = (x==x19 && y==y19);
        boolean test20 = (x==x20 && y==y20);
        
        return(test01||test02||test03||test04||test05||test06||test07||test08||test09||test10||test11||test12||test13||test14||test15||test16||test17||test18||test19||test20);
    }
}
