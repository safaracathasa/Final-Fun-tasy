public class Kingsman extends Monster {

    public Kingsman (Character chars)
    {
        super(chars);
        this.ATK = 5 * x;
        this.maxHP = 200 * x;
        this.CurHP = 200 * x;
        this.money = 50 * x;
        this.item = {"Potion","Ether","Bomb"};
    }
}
