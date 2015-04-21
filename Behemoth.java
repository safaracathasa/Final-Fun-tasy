public class Behemoth extends Monster {
    
    public Behemoth(Character chars)
    {
        super(chars);
        this.ATK = 10*x;
        this.maxHP = 250*x;
        this.CurHP = 250*x;
        this.money = 80*x;
        this.item = {"Potion","Ether","Bomb"};
    }
}
