package finalfuntasy.monster;

import finalfuntasy.character.CharacterGame;

public class Marlboro extends Monster {

    public Marlboro(CharacterGame chars1,CharacterGame chars2,CharacterGame chars3)
    {
        super("Marlboro",chars1,chars2,chars3);
        this.ATK = (this.ATK*15)+15;
        this.maxHP = (this.maxHP*400)+400;
        this.CurHP = (this.CurHP*400)+400;
        this.money = (this.money*10)+120;
        this.incLevel = 6;
    }
    
    public void printMonster() {
    	String h =
    	"................................................................................\n"
    	+ ".................................=..............................................\n"
    	+ ".................................+=........~,...................................\n"
    	+ "........................,~.......,?=......I+.......,............................\n"
    	+ "........................+?........Z+=.....7+......:=............................\n"
    	+ "........................I7I~......=NO$...:$77.....?$I...........................\n"
    	+ "...............:........INZZI...+.ZN8I8..OD?$~..7Z7O+...........................\n"
    	+ "...............7I........$878ZZOZINND7DNNN?+$O,.7NO8$=....?=....................\n"
    	+ "...............+O?I=..~..+DNZO8DZ?DNMO7NDDI+8NNN7ZNN87.~?$+.....................\n"
    	+ "............~...ZNOZZN7?.I8?NMMNZO7ZNNONMOO$7MN7?8MM$INDND......................\n"
    	+ "............7~ ..:8NDO77I8M$?OMMON$D:I:~DNDO$NOZ$NM+$ZMNND=.....................\n"
    	+ "............ZZZ....DDN87ONNZO$Z8MMN8?7D$?NNDN~NNON87?NMZ+$O.....................\n"
    	+ ".............DZD$DOODON$:$?7+N88DMMMMND$7NNNM$8OOMON8N8+7ONZ.:~:...,............\n"
    	+ "...........:$$NNN7$DMMNN7$NNNM7I,,.NNMM$NND7MOMNDMNNN8NZ7$D7DI+I?:..............\n"
    	+ "............Z8NNMD$?I8DDNMMMD8IMNDN8INOZDMN:8Z8MMMNNMN8NZ,7DNDD.................\n"
    	+ ".............$OOO88Z$8MN~$ZZMD$IONMNZOOONO$$$NZNMZ=:$DNNN8NNMN8.................\n"
    	+ "..............N8NO+ODDO77NDNZMNDODN8O?NDNN+~=NNM8NDI,=NZND+=7NN$=,=:............\n"
    	+ "......?....+$O8DZONNNND~DMNM8ZDMO8MN7?DODN87ZMMN8NM$?N8DMNOOZNN8O8$=:...........\n"
    	+ "........Z$7=+OONMMNZ$DZ?ONMNN$8MD8N,ZZNZNO8O8DNZNNNNNNNNNMNN+INO....,,..........\n"
    	+ ".......78NO8NNNN8?ND8$DNNMN~M8DNDZMONN8NNNODM88OZDNN88I+~MMNO?NNOI:..::.........\n"
    	+ "......,78NMNNMZ7ZMMMO8O8NND~N8OMMDD8?NNOIN?NDN8NDNM$ZNZ8O=MN$?MDD$$~............\n"
    	+ "......,~8D..7=ZON$=I8ZNMNMIDN.=~=:8O.,...,~D.7,$NNDDDNNN8:ZN7$MNZONI,...........\n"
    	+ ".......78...ZZIDNN8NNNNM,=,+N?O+NDZN:8=?,N7D+.+?....,I:7NMNDNMNNZZ$DO=,.........\n"
    	+ ".......Z8...78ODNNNMM8=I,=MN?MMOM7MMN$NMM7NINNON?~N8IN$MNNNNNNDZ8$I.............\n"
    	+ "........Z.,?+ONNMMMNN:$DMMMMMMMMMMMMMMMMMMMMMMMMNMNNMNZNNMMN8O$...?+............\n"
    	+ "........~.ZDDDNNMMMMM7MMMMMMMMMMMMMMMMMMMMMMMMMOOM$I,M7I$MMNN$7....,+=,.........\n"
    	+ "...........ONDMMDNMMO~NMMMMMMMMMMMMMMMMMMMMM$?N=,.:?NZM7IMMMN7I8.............?..\n"
    	+ ".........77ODNNMDNMMM=:?DOMMMMMMMMMMMDMMZ$N,$+.~=N:+NMN878MMMN78ND7..........+..\n"
    	+ "........7ZO+,.,OZMMOOZOI,D=?N:N+$N77.:NI,7?...:ND:$NNMM88DMMMM8DD8O$II77777$O?..\n"
    	+ ".......IO,.....8DMN$IONNM7$:I,7.:I.,..,:+8:NZOZNZO=8MMMMNMNMNNNDZN8ZMO8Z7?7$?...\n"
    	+ ".......$......,ONMM8ODMN?7ONZN$ZODO=NON8NODIIMMMZO=NMMMMDMNMNDNDZZDNNMMMD8......\n"
    	+ ".............:$OONND8MM:$ZONN,ZON8D+$8MNMZ7,Z8MMDD8NMMMMMMNDMD8OONNNMMMMM8......\n"
    	+ "...........:77$?..87DMM7OONMDZZZNNO8ZDMMMMDODOMMM8$:NM8OMMMMMNOD8OONMMDD88I.....\n"
    	+ "................. OIDMMOMNMN=7ZDMMNNNNMMMMMMNNMMMMD7OMMZZNNMDOMZ77NMMOZOO$I$....\n"
    	+ ".................,$:8MMDNMMMZONMMMMINMMMNMMN$MMDNMNDOMNNOMMN8$$I=ONM$=7ND?$O....\n"
    	+ "..................8$NMOONMMMDDMMMDM7ZNMM8DMOIMMM8MNDMNNNMMMNOZ8O$DMNZ788~Z$$....\n"
    	+ ".................+D87$ZNMMNMNDMMNMM$ZMMM8DM8OMMNZMNNMNNNMMMDZDOZDNNNI$O+IZO7....\n"
    	+ ".............7NNNZIINMNDN8NZ$MN8ZMDD8MMM8MMNMZDMDZMNNNNMNMNDZ=88NMN8O8+IZOMN8...\n"
    	+ "..........~8NDZZZZMMMNONNIZOMNMZDZ+7MNMM$MNDIMNNM8DNNMMMMMMMN8ZZOM8DZ?~$DM$ZZ8..\n"
    	+ ".........IDDO?ZDNNMNMMZMDDDNN8MOMD8DMNMMZ8NNNMNMMMMMNMMMMMMMMNNNMD$N~:O8MD$+,+O.\n"
    	+ ".........8DZIDDMMMMMMNMNDDDDNMMNMNMNDMMMMOMNMNDMONDONMMMMNNMMMMD$NO,=OONM88O$:$.\n"
    	+ ".........$8ZDNI..Z8N8NM8N8MMMMNMMMNMMMNZZONDMMMMDM8MNMMDDO8MMZN8OZ$ZZ8NNMMMDZ7$.\n"
    	+ "........:DZD8...Z8Z88OMDNMMMMDNMNN8NNZI$ZNZOZ88OZDZZON8NZ8OOND$+=ZZOO8NONNNNZ77.\n"
    	+ "........8OO8...ZO77Z88MMMNNMNM8NNON$=$D88OOO8O8$D7Z8NNDMNZDO7+7O8OOO8N,:NNN$$7,.\n"
    	+ ".......8ZDD....DND8DDNZN..=MM8N8MNODNMNNMNNNDDNZ$ZDMDMMN8O$ZZO8NNDMMMMDDZNZ$O,..\n"
    	+ "...:Z8ZON8.....8NDNDDNDZ..8NNMONONMMMMNNNNDD8NND788DNMNZ87$ZNNMNMMM8OZZO8DO+....\n"
    	+ ".?88OZ+=........NMN8DZND..IM8DNMNMNNN.........7D$Z...IDDZI$.......DZ$OD$........\n"
    	+ "=7................ONND7D8..NN8MMM8DD..........$DZ....$NNZ7$,......8$ON..........\n"
    	+ ".....................INND7.,NMNNODND..........Z~.....ODDOO$Z~.?Z..N$D...........\n"
    	+ ".......................ON$...NMNO$8Z,...............$O...$ZZOZD=..,D8...........\n"
    	+ "........................8I....8MN7ZN?.............:OI...........................\n"
    	+ "........................, .....?N8ZD7.............:.............................\n"
    	+ ".................................D8NI...........................................\n"
    	+ ".................................OZD,...........................................\n"
    	+ ".................................OD$............................................\n"
    	+ "................................ZD7.............................................\n"
    	+ ".............................7I7= ..............................................\n"
    	+ "................................................................................";
    	System.out.println(h);
    }
}
