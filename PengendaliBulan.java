package dev.huntul.finalfuntasy.character;

import dev.huntul.finalfuntasy.monster.Monster;

public class PengendaliBulan extends CharacterGame
{
	public PengendaliBulan(String nama)
	{
		super(nama, 8, 10, 12, "Pengendali Bulan");
	}

	public int damageMagic()
	{
		return(3*this.cINT);
	}


	public void useMagic(Monster mon)
	{

		if (this.cLV <= 10)
		{
			System.out.println("Moon!");
			mon.setCurHP(mon.getCurHP() - damageMagic());
		}
		else if ((this.cLV >= 11) && (this.cLV <=20))
		{
			System.out.println("Moona!");
			mon.setCurHP(mon.getCurHP() - damageMagic() - 20);
		}
		else if ((this.cLV >= 21) && (this.cLV <=30))
		{
			System.out.println("Moonaga!");
			mon.setCurHP(mon.getCurHP() - damageMagic() - 50);
		}
		else 
		{
			System.out.println("Gerhana Bulan!");
			mon.setCurHP(mon.getCurHP() - damageMagic() - 100);
		}		

	}
}
