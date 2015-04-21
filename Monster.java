public abstract class Monster {

    protected int ATK;
    protected int maxHP;
    protected int CurHP;
    protected int money;
    protected String[] item;
    
    public Monster (Character chars)
    {
        int x = 1+chars.getLVl()/5;
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
    
    public int getCurHP (int hp)
    {
        this.CurHP = hp;
    }
    
    //method
    public void useAttack(Character chars)
    {
        chars.setCurHP(chars.getCurHP() - ATK);
    }
    
    public void giveMoney(Pemain P)
    {
        P.setMoney(P.getMoney() + money);
    }
    public void upLevel(Character[] chars)
    {
        for (int i=0;i<=2;i++)
        {
            chars[i].levelUP;
        }
    }
}
