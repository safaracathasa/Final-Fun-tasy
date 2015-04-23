package dev.huntul.finalfuntasy.character;

public class PengendaliBumi extends CharacterGame
{
	public PengendaliBumi(String nama)
	{
		super(nama, 12, 10, 8, "Pengendali Bumi");
	}

/*	public void useMagic(Monster mon)
	{

		if (this.cLV <= 10)
		{
			System.out.println("Terre!");
			mon.setHP(mon.getHP - this.damageMagic);
		}
		else if ((this.cLV >= 11) && (this.cLV <=20))
		{
			System.out.println("Terra!");
			mon.setHP(mon.getHP - this.damageMagic - 20);
		}
		else if ((this.cLV >= 21) && (this.cLV <=30))
		{
			System.out.println("Terraga!");
			mon.setHP(mon.getHP - this.damageMagic - 50);
		}
		else 
		{
			System.out.println("Armageddon!");
			mon.setHP(mon.getHP - this.damageMagic - 100);
		}		

	}*/
}
