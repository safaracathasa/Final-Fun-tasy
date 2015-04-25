package dev.huntul.finalfuntasy.character;

import dev.huntul.finalfuntasy.monster.Monster;

public class PengendaliBumi extends CharacterGame
{
	public PengendaliBumi(String nama, String job)
	{
		super(nama, 12, 10, 8, job);
	}

	public void useMagic(Monster mon)
	{

		if (cLV <= 10)
		{
			try {
				cekMP(20);
				curMP = curMP - 30;
				System.out.println("Terre!");
				mon.setCurHP(mon.getCurHP() - damageMagic());
		        System.out.println("Hit " + damageMagic() + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else if ((cLV >= 11) && (cLV <=20))
		{
			try {
				cekMP(30);
				curMP = curMP - 50;
				System.out.println("Terra!");
				mon.setCurHP((int) (mon.getCurHP() - damageMagic()*1.2));
		        System.out.println("Hit " + damageMagic()*1.2 + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else if ((cLV >= 21) && (cLV <=30))
		{
			try {
				cekMP(40);
				curMP = curMP - 75;
				System.out.println("Terraga!");
				mon.setCurHP((int) (mon.getCurHP() - damageMagic()*1.5));
		        System.out.println("Hit " + damageMagic()*1.5 + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}
		else 
		{
			try {
				cekMP(50);
				curMP = curMP - 100;
				System.out.println("Armageddon!");
				mon.setCurHP((int) (mon.getCurHP() - damageMagic()*2));
		        System.out.println("Hit " + damageMagic()*2 + " damage!");
			} catch (OutOfManaExcept e) {
				e.response();
			}
		}		
	}
}
