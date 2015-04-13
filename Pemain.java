public class Pemain {
    private int money;
    private Item[] item;
    private PosInfo position;
    private Characters[] characters;

    public Pemain (int money, Item[] benda, PosiInfo posisi, Characters[] chars)
    {
        
    }
    
    public void setMoney (int duit)
    {
        this.money = duit;
    }
    
    public void setItem (Item[] benda)
    {
        this.item = benda;
    }
    
    public void setPosition (PosInfo posisi)
    {
        this.position = posisi;
    }
    
    public void setCharacters (Characters[] chars)
    {
        this.characters = chars;
    }
    
    public int getMoney ()
    {
        return this.money;
    }
    
    public Item[] getItem ()
    {
        return this.item;
    }
    
    public PosInfo getPosition ()
    {
        return this.position;
    }
    
    public Characters[] getCharacters ()
    {
        return this.characters;
    }
}
