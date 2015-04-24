package dev.huntul.finalfuntasy.character;

import dev.huntul.finalfuntasy.monster.Monster;

public class PengendaliBumi extends CharacterGame
{
	public PengendaliBumi(String nama)
	{
		super(nama, 12, 10, 8, "Pengendali Bumi");
	}

	public void useMagic(Monster mon)
	{

		if (this.cLV <= 10)
		{
			System.out.println("Terre!");
			curMP = curMP - 20;
			mon.setCurHP(mon.getCurHP() - damageMagic());
		}
		else if ((this.cLV >= 11) && (this.cLV <=20))
		{
			System.out.println("Terra!");
			curMP = curMP - 30;
			mon.setCurHP(mon.getCurHP() - damageMagic() - 20);
		}
		else if ((this.cLV >= 21) && (this.cLV <=30))
		{
			System.out.println("Terraga!");
			curMP = curMP - 40;
			mon.setCurHP(mon.getCurHP() - damageMagic() - 50);
		}
		else 
		{
			System.out.println("Armageddon!");
			curMP = curMP - 50;
			mon.setCurHP(mon.getCurHP() - damageMagic() - 100);
		}		
	}
}
