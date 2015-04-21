public class Pemain {
    private int money;
    private Item[] item;
    private Point position;
    private Characters[] characters;

    public Pemain (int money, Item[] benda, Point posisi, Characters[] chars)
    {
        this.money = money;
        this.item = benda;
        this.position = posisi;
        this.characters = chars;
    }
    
    public void setMoney (int duit)
    {
        this.money = duit;
    }
    
    public void setItem (Item[] benda)
    {
        this.item = benda;
    }
    
    public void setPosition (Point posisi)
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
    
    public Point getPosition ()
    {
        return this.position;
    }
    
    public Characters[] getCharacters ()
    {
        return this.characters;
    }
}
