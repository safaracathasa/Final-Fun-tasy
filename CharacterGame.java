package finalfuntasy.character;

import java.io.Serializable;
import java.util.Random;

import finalfuntasy.item.Item;
import finalfuntasy.monster.Monster;

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
        
        private float randomProb(){
            Random rand = new Random();
            return (rand.nextInt(101)/100f);
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
            int dmg = (int)(1.6*cSTR + 0.4*randomProb()*cSTR);
            float chance = randomProb();
            if(chance>0.9){
                System.out.println("\nCRITICAL!");
                dmg = dmg*2;
            }
		return dmg;
	}

	public int damageMagic()
	{
            
            return(int)(4*cINT + randomProb()*cINT);
	}

// METHODE

	public void useAttack(Monster mon)
	{
            int damage = damageAttack();
            mon.setCurHP(mon.getCurHP() - damage);
            System.out.println("Hit " + damage + " damage!");
	}

	public abstract int useMagic(Monster mon);

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

		setSTR((int) (1 + getSTR() + (0.12*(getSTR()*(1-(cLV/41f))))));

		setVIT((int) (1 + getVIT() + (0.11*(getVIT()*(1-(cLV/41f))))));

		setINT((int) (1 + getINT() + (0.1*(getINT()*(1-(cLV/41f))))));
		
		setMaxHP(getVIT() * 10);
		
		setMaxMP(getINT() * 10);
	}
}
