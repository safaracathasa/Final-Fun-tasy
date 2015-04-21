public abstract class Character
{
	protected String namaChar;
	protected int cSTR;
	protected int cVIT;
	protected int cINT;
	protected int cLV;
	protected int maxHP;
	protected int maxMP;
	protected int curHP;
	protected int curMP;

	public Character(String nama, int s, int v, int i)
	{
		this.namaChar 	= nama;
		this.cSTR 		= s;
		this.cVIT 		= v;
		this.cINT 		= i;
		this.maxHP 		= (10*v);
		this.curHP 		= this.maxHP;	
		this.maxMP		= (10*i);
		this.curMP 		= this.maxMP;
		this.cLV 		= 1;
	}

// GETTER

	public String getNama()
	{
		return(this.namaChar);
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

	public int getMaxHP()
	{
		return(this.maxHP);
	}

	public int getMaxMP()
	{
		return(this.maxMP);
	}

	public int getCurHP()
	{
		return(this.curHP);
	}

	public int getCurMP()
	{
		return(this.curMP);
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

	public void setMaxHP(int x)
	{
		this.maxHP = x;
	}

	public void setMaxMP(int x)
	{
		this.maxMP = x;
	}

	public void setCurHP(int x)
	{
		this.curHP = x;
	}

	public void setCurMP(int x)
	{
		this.curMP = x;
	}	

	public void setLV(int x)
	{
		this.cLV = x;
	}

// METHODE GET DAMAGE

	public int damageAttack()
	{
		return(2*this.cSTR);
	}

	public int damageMagic()
	{
		return(2*this.cINT);
	}

// METHODE

	public void useAttack(Monster mon)
	{
		mon.setHP(mon.getHP - this.damageAttack);
	}

	public abstract void useMagic(Monster mon);

	public void useItem(Item item, Character ch)
	{
		item.effectItem(ch);
	}

	public abstract void levelUP(int lv)
	{
		// BELUM DI SET EXCEPTION KALAU LEVEL LEBIH DARI 40

		this.cLV = this.cLV + lv;

		float i;

		if ((this.cLV <= 10)
		{
			i = 1;
		}
		else if ((this.cLV >= 11) && (this.cLV <=20))
		{
			i = 1.2;
		}
		else if ((this.cLV >= 21) && (this.cLV <=30))
		{
			i = 1.5;
		}
		else 
		{
			i = 2;
		}

		this.setSTR(this.getSTR + (this.getSTR*i));

		this.setVIT(this.getVIT + (this.getVIT*i));

		this.setINT(this.getINT + (this.getINT*i));
	}
