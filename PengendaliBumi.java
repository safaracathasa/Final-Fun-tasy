package finalfuntasy.character;

import finalfuntasy.monster.Monster;

public class PengendaliBumi extends CharacterGame
{
	public PengendaliBumi(String nama, String job)
	{
		super(nama, 12, 10, 8, job);
	}

	public int useMagic(Monster mon)
	{
                int reqMP;
		if (cLV <= 10)
		{
                        reqMP = 25+3*cLV;
			try {
				cekMP(reqMP);
				curMP = curMP - (reqMP);
                                System.out.println("\n" + getNama() + " menggunakan skill kepada " + mon.getName()+"\n");
                                System.out.println("Terre!");
				mon.setCurHP(mon.getCurHP() - damageMagic());
                                System.out.println("Hit " + damageMagic() + " damage!");
                                return 1;
			} catch (OutOfManaExcept e) {
				e.response();
                                return 0;
			}
		}
		else if ((cLV >= 11) && (cLV <=20))
		{
                        reqMP = 55+6*(cLV-10);
			try {
				cekMP(reqMP);
				curMP = curMP - (reqMP);
                                System.out.println("\n" + getNama() + " menggunakan skill kepada " + mon.getName()+"\n");
				System.out.println("Terra!");
				mon.setCurHP(mon.getCurHP() - (int)(damageMagic()*1.2));
                                System.out.println("Hit " + (int)(damageMagic()*1.2) + " damage!");
                                return 1;
			} catch (OutOfManaExcept e) {
				e.response();
                                return 0;
			}
		}
		else if ((cLV >= 21) && (cLV <=30))
		{
                        reqMP = 115+10*(cLV-20);
			try {
				cekMP(reqMP);
				curMP = curMP - (reqMP);
                                System.out.println("\n" + getNama() + " menggunakan skill kepada " + mon.getName()+"\n");
				System.out.println("Terraga!");
				mon.setCurHP(mon.getCurHP() - (int)(damageMagic()*1.5));
                                System.out.println("Hit " + (int)(damageMagic()*1.5) + " damage!");
                                return 1;
			} catch (OutOfManaExcept e) {
				e.response();
                                return 0;
			}
		}
		else 
		{
                        reqMP = 215+15*(cLV-30);
			try {
				cekMP(reqMP);
				curMP = curMP - (reqMP);
                                System.out.println("\n" + getNama() + " menggunakan skill kepada " + mon.getName()+"\n");
				System.out.println("Amageddon!");
				mon.setCurHP((mon.getCurHP() - damageMagic()*2));
                                System.out.println("Hit " + damageMagic()*2 + " damage!");
                                return 1;
			} catch (OutOfManaExcept e) {
				e.response();
                                return 0;
			}
		}	
	}
}
