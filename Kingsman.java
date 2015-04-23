public class Kingsman extends Monster {

    public Kingsman (CharacterGame chars1,CharacterGame chars2,CharacterGame chars3)
    {
        super(chars1,chars2,chars3);
        this.ATK = (this.ATK*2)+5;
        this.maxHP = (this.maxHP*40)+200;
        this.CurHP = (this.CurHP*40)+200;
        this.money = (this.money*3)+50;
    }
}
