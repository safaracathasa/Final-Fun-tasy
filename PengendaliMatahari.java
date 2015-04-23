package dev.huntul.finalfuntasy.character;

import dev.huntul.finalfuntasy.monster.Monster;

public class PengendaliMatahari extends CharacterGame
{
	public PengendaliMatahari(String nama)
	{
		super(nama, 12, 10, 8, "Pengendali Matahari");
	}

	public int damageAttack()
	{
		return(3*this.cSTR);
	}


	public void useMagic(Monster mon)
	{

		if (this.cLV <= 10)
		{
			System.out.println("Sun!");
			mon.setCurHP(mon.getCurHP() - damageMagic());
		}
		else if ((this.cLV >= 11) && (this.cLV <=20))
		{
			System.out.println("Suna!");
			mon.setCurHP(mon.getCurHP() - damageMagic() - 20);
		}
		else if ((this.cLV >= 21) && (this.cLV <=30))
		{
			System.out.println("Sunaga!");
			mon.setCurHP(mon.getCurHP() - damageMagic() - 50);
		}
		else 
		{
			System.out.println("Gerhana Matahari!");
			mon.setCurHP(mon.getCurHP() - damageMagic() - 100);
		}		

	}
}
