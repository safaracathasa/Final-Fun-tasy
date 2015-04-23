public abstract class Monster {

    protected int ATK;
    protected int maxHP;
    protected int CurHP;
    protected int money;
    protected String[] item;
    
    public Monster (CharacterGame chars1,CharacterGame chars2,CharacterGame chars3)
    {
        int x = (int)(1+(chars1.getLV()+chars2.getLV()+chars3.getLV())/5);
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
    public void upLevel(CharacterGame[] chars)
    {
        for (int i=0;i<=2;i++)
        {
            chars[i].levelUP(chars[i].getLV());
        }
    }
}
