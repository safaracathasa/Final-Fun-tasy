package finalfuntasy.character;

import finalfuntasy.monster.Monster;

public class PengendaliMatahari extends CharacterGame
{
	public PengendaliMatahari(String nama, String job)
	{
		super(nama, 8, 12, 10, job);
	}

	public void useMagic(Monster mon)
	{

		if (cLV <= 10)
		{
			try {
				cekMP(25+3*cLV);
				curMP = curMP - (25+3*cLV);
				System.out.println("Sun!");
				mon.setCurHP(mon.getCurHP() - damageMagic());
		        System.out.println("Hit " + damageMagic() + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else if ((cLV >= 11) && (cLV <=20))
		{
			try {
				cekMP(65+10*(cLV-10));
				curMP = curMP - (65+10*(cLV-10));
				System.out.println("Suna!");
				mon.setCurHP(mon.getCurHP() - (int)(damageMagic()*1.2));
		        System.out.println("Hit " + (int)(damageMagic()*1.2) + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else if ((cLV >= 21) && (cLV <=30))
		{
			try {
				cekMP(165+20*(cLV-20));
				curMP = curMP - (165+20*(cLV-20));
				System.out.println("Sunaga!");
				mon.setCurHP(mon.getCurHP() - (int)(damageMagic()*1.5));
		        System.out.println("Hit " + (int)(damageMagic()*1.5) + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else 
		{
			try {
				cekMP(365+35*(cLV-30));
				curMP = curMP - (365+35*(cLV-30));
				System.out.println("Gerhana Matahari!");
				mon.setCurHP((mon.getCurHP() - damageMagic()*2));
		        System.out.println("Hit " + damageMagic()*2 + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}	
	}
}	
