public class Behemoth extends Monster {
    public Behemoth(Characters chars)
    {
        super(chars);
        this.ATK = 10;
        this.maxHP = 250;
        this.CurHP = 250;
        this.money = 80;
        this.item = {"Potion","Ether","Bomb"};
    }
}