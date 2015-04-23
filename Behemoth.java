public class Behemoth extends Monster {
    
    public Behemoth(CharacterGame chars)
    {
        super(chars);
        this.ATK = this.ATK*10;
        this.maxHP = this.maxHP*250;
        this.CurHP = this.CurHP*250;
        this.money = this.money*80;
    }
}
