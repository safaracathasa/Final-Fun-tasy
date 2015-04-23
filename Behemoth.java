public class Behemoth extends Monster {
    
    public Behemoth(CharacterGame chars1,CharacterGame chars2,CharacterGame chars3)
    {
        super(chars1,chars2,chars3);
        this.ATK = (this.ATK*5)+10;
        this.maxHP = (this.maxHP*50)+250;
        this.CurHP = (this.CurHP*50)+250;
        this.money = (this.money*5)+80;
    }
}
