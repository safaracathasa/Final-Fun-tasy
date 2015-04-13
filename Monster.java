public class Monster {
    private String monsterName;
    private int ATK;
    private int HP;
    private PosInfo position;
    private int money;
    private Item[] item;
    private int IncLevel;
    
    //instanstsiasi
    public Monster (String nama, int atk, int hp, PosInfo posisi, int uang, Item[] benda, int level)
    {
        this.monsterName = nama;
        this.ATK = atk;
        this.HP = hp;
        this.position = posisi;
        this.money = uang;
        this.item = benda;
        this.IncLevel = level;
    }
    
    //setter dan getter
    public void setName(String name)
    {
        this.monsterName = name;
    }
    
    public String getName()
    {
        return this.monsterName;
    }
    
    public void setATK(int atk)
    {
        this.ATK = atk;
    }
    public int getATK()
    {
        return this.ATK;
    }
    
    public void setHP(int hp)
    {
        this.HP = hp;
    }
    
    public int getHP()
    {
        return this.HP;
    }
    
    public void setPosition(PosInfo posisi)
    {
        this.position = posisi;
    }
    
    public PosInfo getPosition()
    {
        return this.position;
    }
    
    public void setItem(Item[] benda)
    {
        this.item = benda;
    }
    
    public Item[] getItem()
    {
        return this.item;
    }
    
    public void setIncLevel(int level)
    {
        this.IncLevel = level;
    }
    
    public int getIncLevel()
    {
        return this.IncLevel;
    }
    
    //method
    public void AttackCharacter();
    
}
