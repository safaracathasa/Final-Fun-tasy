public class Kingsman extends Monster {

    public Kingsman (CharacterGame chars)
    {
        super(chars);
        this.ATK = this.ATK*5;
        this.maxHP = this.maxHP*200;
        this.CurHP = this.CurHP*200;
        this.money = this.money*50;
    }
}
