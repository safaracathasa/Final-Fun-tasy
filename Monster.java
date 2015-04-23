package dev.huntul.finalfuntasy.monster;

import dev.huntul.finalfuntasy.character.CharacterGame;
import dev.huntul.finalfuntasy.pemain.Pemain;

public abstract class Monster {

	protected String name;
    protected int ATK;
    protected int maxHP;
    protected int CurHP;
    protected int money;
    protected int incLevel;
    protected String[] item;
    
    public Monster (String name, CharacterGame chars1,CharacterGame chars2,CharacterGame chars3)
    {
        int x = (int)(1+(chars1.getLV()+chars2.getLV()+chars3.getLV())/5);
        this.name = name;
        this.ATK = x;
        this.maxHP = x;
        this.CurHP = x;
        this.money = x;
    }
    
    public void setATK(int atk)
    {
        this.ATK = atk;
    }
    public int getATK()
    {
        return this.ATK;
    }
    
    public void setmaxHP(int hp)
    {
        this.maxHP = hp;
    }
    
    public int getmaxHP()
    {
        return this.maxHP;
    }
    
    public void setCurHP (int hp)
    {
        this.CurHP = hp;
    }
    
    public int getCurHP ()
    {
        return this.CurHP;
    }
    
    //method
    public void useAttack(CharacterGame chars)
    {
        chars.setCurHP(chars.getCurHP() - ATK);
    }
    
    public void giveMoney(Pemain P)
    {
        P.setMoney(P.getMoney() + money);
    }
}
