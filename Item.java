public abstract class Item 
{
	private int value;
	private int cost;
	private String name;
	
	public Item(int value, int cost, String name) 
	{
		this.value = value;
		this.cost = cost;
		this.name = name;
	}

// GETTER & SETTER	

	public int getValue() 
	{
		return value;
	}

	public void setValue(int value) 
	{
		this.value = value;
	}

	public int getCost() 
	{
		return cost;
	}

	public void setCost(int cost) 
	{
		this.cost = cost;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

// METHODE	

	public abstract void effectItem();
	
}
