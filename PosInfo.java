// Kelas PosInfo, berisi informasi posisi fix dimana toko, item, dan monster berada pada map
// Last edit: 10/04-2015

package BagianDzaka_01;

public class PosInfo {
    private int posX; // Skala 0~9
    private int posY; // Skala 0~9
    
    public void setX(int x){
        posX = x;
    }
    public void setY(int y){
        posY = y;
    }
    
    public boolean cekToko(){
        // Mengembalikan True jika posisi pemain tepat berada pada posisi toko
        // Silakan diedit bagian "KONSTANTA", menyesuaikan dengan kebutuhan

        // KONSTANTA
        // posisi toko 1
        int x1 = 1;
        int y1 = 2;
        // posisi toko 2
        int x2 = 2;
        int y2 = 3;
        // posisi toko 3
        int x3 = 3;
        int y3 = 4;
        // posisi toko 4
        int x4 = 4;
        int y4 = 5;
        // posisi toko 5
        int x5 = 5;
        int y5 = 6;
        
        // PENGECEKAN
        boolean test1 = (posX==x1 && posY==y1);
        boolean test2 = (posX==x2 && posY==y2);
        boolean test3 = (posX==x3 && posY==y3);
        boolean test4 = (posX==x4 && posY==y4);
        boolean test5 = (posX==x5 && posY==y5);
        
        return(test1||test2||test3||test4||test5);
    }
    
    public boolean cekItem(){
        // Mengembalikan True jika posisi pemain tepat berada pada posisi item
        // Silakan diedit bagian "KONSTANTA", menyesuaikan dengan kebutuhan

        // KONSTANTA
        // posisi item 01
        int x01 = 2;
        int y01 = 1;
        // posisi item 02
        int x02 = 3;
        int y02 = 2;
        // posisi item 03
        int x03 = 4;
        int y03 = 3;
        // posisi item 04
        int x04 = 5;
        int y04 = 4;
        // posisi item 05
        int x05 = 6;
        int y05 = 5;
        // posisi item 06
        int x06 = 7;
        int y06 = 6;
        // posisi item 07
        int x07 = 8;
        int y07 = 7;
        // posisi item 08
        int x08 = 9;
        int y08 = 8;
        // posisi item 09
        int x09 = 0;
        int y09 = 9;
        // posisi item 10
        int x10 = 9;
        int y10 = 0;
        
        // PENGECEKAN
        boolean test01 = (posX==x01 && posY==y01);
        boolean test02 = (posX==x02 && posY==y02);
        boolean test03 = (posX==x03 && posY==y03);
        boolean test04 = (posX==x04 && posY==y04);
        boolean test05 = (posX==x05 && posY==y05);
        boolean test06 = (posX==x06 && posY==y06);
        boolean test07 = (posX==x07 && posY==y07);
        boolean test08 = (posX==x08 && posY==y08);
        boolean test09 = (posX==x09 && posY==y09);
        boolean test10 = (posX==x10 && posY==y10);
        
        return(test01||test02||test03||test04||test05||test06||test07||test08||test09||test10);
    }
    
    public boolean cekMonster(){
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
        boolean test01 = (posX==x01 && posY==y01);
        boolean test02 = (posX==x02 && posY==y02);
        boolean test03 = (posX==x03 && posY==y03);
        boolean test04 = (posX==x04 && posY==y04);
        boolean test05 = (posX==x05 && posY==y05);
        boolean test06 = (posX==x06 && posY==y06);
        boolean test07 = (posX==x07 && posY==y07);
        boolean test08 = (posX==x08 && posY==y08);
        boolean test09 = (posX==x09 && posY==y09);
        boolean test10 = (posX==x10 && posY==y10);
        boolean test11 = (posX==x11 && posY==y11);
        boolean test12 = (posX==x12 && posY==y12);
        boolean test13 = (posX==x13 && posY==y13);
        boolean test14 = (posX==x14 && posY==y14);
        boolean test15 = (posX==x15 && posY==y15);
        boolean test16 = (posX==x16 && posY==y16);
        boolean test17 = (posX==x17 && posY==y17);
        boolean test18 = (posX==x18 && posY==y18);
        boolean test19 = (posX==x19 && posY==y19);
        boolean test20 = (posX==x20 && posY==y20);
        
        return(test01||test02||test03||test04||test05||test06||test07||test08||test09||test10||test11||test12||test13||test14||test15||test16||test17||test18||test19||test20);
    }
}
