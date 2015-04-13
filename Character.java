public class Character implements Skillable 
{
	protected String namaChar;
	protected int cSTR;
	protected int cVIT;
	protected int cINT;
	protected int cLV;
	protected String jobChar;

	public Character(String nama, String job)
	{
		switch (job)
		{
			case ("Hero") :
			{
				this.namaChar 	= nama;
				this.jobChar 	= job;
				this.cSTR 		= 6;
				this.cVIT 		= 10;
				this.cINT		= 4;
				this.cLV 		= 1;	
			}
			case ("Mage") :
			{
				this.namaChar 	= nama;
				this.jobChar 	= job;
				this.cSTR 		= 2;
				this.cVIT 		= 6;
				this.cINT		= 12;
				this.cLV 		= 1;	
			}
			case ("Pirate") :
			{
				this.namaChar 	= nama;
				this.jobChar 	= job;
				this.cSTR 		= 8;
				this.cVIT 		= 8;
				this.cINT		= 4;
				this.cLV 		= 1;	
			}
		}
	}

// GETTER

	public String getNama()
	{
		return(this.namaChar);
	}

	public String getJob()
	{
		return(this.jobChar);
	}

	public int getSTR()
	{
		return(this.cSTR);
	}

	public int getVIT()
	{
		return(this.cVIT);
	}

	public int getINT()
	{
		return(this.cINT);
	}

	public int getHP()
	{
		return((this.cVIT) * 10);
	}

	public int getMP()
	{
		return((this.cINT) * 10);
	}

	public int getATK()
	{
		return((this.cSTR) * 2);
	}

	public int getLV()
	{
		return(this.cLV);
	}

// SETTER
// Nama dan Job tidak bisa diubah lagi

	public void setSTR(int x)
	{
		this.cSTR = x;
	}

	public void setVIT(int x)
	{
		this.cVIT = x;
	}

	public void setINT(int x)
	{
		this.cINT = x;
	}

	public void setHP(int x)
	{
		this.cHP = x;
	}

	public void setMP(int x)
	{
		this.cMP = x;
	}

	public void setLV(int x)
	{
		this.cLV = x;
	}

// METHODE



// IMPLEMENTASI INTERFACE
	
	public void Attack()
	{
		switch (this.jobChar)
		{
			case ("Hero") :
			{

			}
			case ("Mage") :
			{

			}
			case ("Pirate") :
			{

			}
		}
	}

	public void Defend()
	{

	}

	public void Heal()
	{

	}

}
