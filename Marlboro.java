public class Marlboro extends Monster {

    public Marlboro(CharacterGame chars1,CharacterGame chars2,CharacterGame chars3)
    {
        super(chars1,chars2,chars3);
        this.ATK = (this.ATK*8)+15;
        this.maxHP = (this.maxHP*70)+400;
        this.CurHP = (this.CurHP*70)+400;
        this.money = (this.money*10)+120;
    }
}
