public class PengendaliMatahari extends Character
{
	public Hero(String nama)
	{
		super(nama, 12, 10, 8);
	}

	public damageAttack()
	{
		return(3*this.cSTR);
	} @Override


	public void useMagic(Monster mon)
	{

		if ((this.cLV <= 10)
		{
			System.out.println("Sun!");
			mon.setHP(mon.getHP - this.damageMagic);
		}
		else if ((this.cLV >= 11) && (this.cLV <=20))
		{
			System.out.println("Suna!");
			mon.setHP(mon.getHP - this.damageMagic - 20);
		}
		else if ((this.cLV >= 21) && (this.cLV <=30))
		{
			System.out.println("Sundaga!");
			mon.setHP(mon.getHP - this.damageMagic - 50);
		}
		else 
		{
			System.out.println("Gerhana Matahari!");
			mon.setHP(mon.getHP - this.damageMagic - 100);
		}		

	}
}