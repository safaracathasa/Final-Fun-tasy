package finalfuntasy.monster;

import finalfuntasy.character.CharacterGame;
import finalfuntasy.pemain.Pemain;
import java.util.Random;

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
        int x = (int)((chars1.getLV()+chars2.getLV()+chars3.getLV())/3);
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
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public int getIncLevel(){
    	return incLevel;
    }
    public void setIncLevel(int i){
    	incLevel = i;
    }
    
    public void setMoney(int money)
    {
        this.money = money;
    }
    public int getMoney()
    {
        return this.money;
    }
    
    //method
    public void useAttack(CharacterGame chars)
    {
        int dmg =(int)(ATK*0.8 + ATK*randomProb()*0.2);
        chars.setCurHP(chars.getCurHP() - dmg);
        System.out.println("Hit " + dmg + " damage!");
    }
    
    public void giveMoney(Pemain P)
    {
        P.setMoney(P.getMoney() + money);
    }
    
    public abstract void printMonster();


    private float randomProb(){
        Random rand = new Random();
        return (rand.nextInt(101)/100f);
    }
}
