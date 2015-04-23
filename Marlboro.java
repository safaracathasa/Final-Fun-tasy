public class Marlboro extends Monster {

    public Marlboro (CharacterGame chars)
    {
        super(chars);
        this.ATK = this.ATK*15;
        this.maxHP = this.maxHP*400;
        this.CurHP = this.CurHP*400;
        this.money = this.money*120;
    }
}
