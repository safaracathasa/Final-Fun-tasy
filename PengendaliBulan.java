public class PengendaliBulan extends Character
{
	public Hero(String nama)
	{
		super(nama, 8, 10, 12);
	}

	public damageMagic()
	{
		return(3*this.cINT);
	} @Override


	public void useMagic(Monster mon)
	{

		if ((this.cLV <= 10)
		{
			System.out.println("Moon!");
			mon.setHP(mon.getHP - this.damageMagic);
		}
		else if ((this.cLV >= 11) && (this.cLV <=20))
		{
			System.out.println("Moona!");
			mon.setHP(mon.getHP - this.damageMagic - 20);
		}
		else if ((this.cLV >= 21) && (this.cLV <=30))
		{
			System.out.println("Moonaga!");
			mon.setHP(mon.getHP - this.damageMagic - 50);
		}
		else 
		{
			System.out.println("Gerhana Bulan!");
			mon.setHP(mon.getHP - this.damageMagic - 100);
		}		

	}
}