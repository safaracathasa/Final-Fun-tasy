package dev.huntul.finalfuntasy.character;

import java.io.Serializable;

import dev.huntul.finalfuntasy.item.Item;
import dev.huntul.finalfuntasy.monster.Monster;

public abstract class CharacterGame implements Serializable {
	protected String namaChar;
	protected int cSTR;
	protected int cVIT;
	protected int cINT;
	protected int cLV;
	protected int maxHP;
	protected int maxMP;
	protected int curHP;
	protected int curMP;
	protected String job;

	public CharacterGame(String nama, int s, int v, int i, String job)
	{
		namaChar	= nama;
		cSTR 		= s;
		cVIT 		= v;
		cINT 		= i;
		maxHP 		= (10*cVIT);
		curHP 		= maxHP;	
		maxMP		= (10*cINT);
		curMP 		= maxMP;
		cLV 		= 1;
		this.job	= job;
	}

// GETTER

	public String getNama()
	{
		return(namaChar);
	}


	public int getSTR()
	{
		return(cSTR);
	}

	public int getVIT()
	{
		return(cVIT);
	}

	public int getINT()
	{
		return(cINT);
	}

	public int getMaxHP()
	{
		return(maxHP);
	}

	public int getMaxMP()
	{
		return(maxMP);
	}

	public int getCurHP()
	{
		return(curHP);
	}

	public int getCurMP()
	{
		return(curMP);
	}

	public int getLV()
	{
		return(cLV);
	}
	
	public String getJob()
	{
		return(job);
	}

// SETTER
// Nama dan Job tidak bisa diubah lagi

	public void setSTR(int x)
	{
		cSTR = x;
	}

	public void setVIT(int x)
	{
		cVIT = x;
	}

	public void setINT(int x)
	{
		cINT = x;
	}

	public void setMaxHP(int x)
	{
		maxHP = x;
	}

	public void setMaxMP(int x)
	{
		maxMP = x;
	}

	public void setCurHP(int x)
	{
		curHP = x;
	}

	public void setCurMP(int x)
	{
		curMP = x;
	}	

	public void setLV(int x)
	{
		cLV = x;
	}

// METHODE GET DAMAGE

	public int damageAttack()
	{
		return(2*cSTR);
	}

	public int damageMagic()
	{
		return(5*cINT);
	}

// METHODE

	public void useAttack(Monster mon)
	{
		mon.setCurHP(mon.getCurHP() - damageAttack());
        System.out.println("Hit " + damageAttack() + " damage!");
	}

	public abstract void useMagic(Monster mon);

	public void useItem(Item item, CharacterGame chars, Monster monster)
	{
		System.out.println(getNama() + " use " + item.getName());
		item.effectItem(chars, monster);
	}
	
	public void cekMP(int cost) throws OutOfManaExcept {
		if (curMP - cost < 0) {
			throw new OutOfManaExcept("Not enough MP!");
		}
	}
	
	public void levelUP(int lv)
	{
		if (cLV >= 40) {
			return;
		}
		
		cLV = cLV + lv;

		float i;

		if (cLV <= 10)
		{
			i = 1;
		}
		else if ((cLV >= 11) && (cLV <=20))
		{
			i = (float) 1.2;
		}
		else if ((cLV >= 21) && (cLV <=30))
		{
			i = (float) 1.5;
		}
		else 
		{
			i = 2;
		}

		setSTR((int) (getSTR() + (0.2*(getSTR()*i))));

		setVIT((int) (getVIT() + (0.2*(getVIT()*i))));

		setINT((int) (getINT() + (0.2*(getINT()*i))));
		
		setMaxHP(getVIT() * 10);
		
		setMaxMP(getINT() * 10);
	}
}
