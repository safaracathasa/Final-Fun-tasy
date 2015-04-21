public class HealingItem extends Item 
{
	public HealingItem(int value, int cost, String name, int ) 
	{
		super(value,cost,name);
	}

	public void effectItem(Character ch)
	{
		ch.setCurHP(ch.getCurHP + value);
	}
}
