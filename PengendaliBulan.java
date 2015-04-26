package dev.huntul.finalfuntasy.character;

import dev.huntul.finalfuntasy.monster.Monster;

public class PengendaliBulan extends CharacterGame
{
	public PengendaliBulan(String nama, String job)
	{
		super(nama, 8, 10, 12, job);
	}

	public void useMagic(Monster mon)
	{

		if (cLV <= 10)
		{
			try {
				cekMP(30);
				curMP = curMP - 30;
				System.out.println("Moon!");
				mon.setCurHP(mon.getCurHP() - damageMagic());
		        System.out.println("Hit " + damageMagic() + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else if ((cLV >= 11) && (cLV <=20))
		{
			try {
				cekMP(50);
				curMP = curMP - 50;
				System.out.println("Moona!");
				mon.setCurHP((int) (mon.getCurHP() - damageMagic()*1.2));
		        System.out.println("Hit " + damageMagic()*1.2 + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else if ((cLV >= 21) && (cLV <=30))
		{
			try {
				cekMP(75);
				curMP = curMP - 75;
				System.out.println("Moonaga!");
				mon.setCurHP((int) (mon.getCurHP() - damageMagic()*1.5));
		        System.out.println("Hit " + damageMagic()*1.5 + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else 
		{
			try {
				cekMP(100);
				curMP = curMP - 100;
				System.out.println("Gerhana Bulan!");
				mon.setCurHP((mon.getCurHP() - damageMagic()*2));
		        System.out.println("Hit " + damageMagic()*2 + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}		
	}
}
