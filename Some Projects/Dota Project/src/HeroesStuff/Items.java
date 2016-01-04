package HeroesStuff;

public class Items {
	
	private String itemName;
	private int itemStrength;
	private int itemAgility;
	private int itemInteligence;
	
	// creates Item() constructor that inputs the name and stats o the item
	Items(String itemName, int itemStrength, int itemAgility, int itemInteligence) {
		if (itemName.trim().isEmpty()) {
			System.out.println("Invalid item name!");
			return;
		}
		setItemName(itemName);
		setItemStrength(itemStrength);
		setItemAgility(itemAgility);
		setItemInteligence(itemInteligence);
	}
	
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemStrength() {
		return itemStrength;
	}

	public void setItemStrength(int itemStrength) {
		this.itemStrength = itemStrength;
	}

	public int getItemAgility() {
		return itemAgility;
	}

	public void setItemAgility(int itemAgility) {
		this.itemAgility = itemAgility;
	}

	public int getItemInteligence() {
		return itemInteligence;
	}

	public void setItemInteligence(int itemInteligence) {
		this.itemInteligence = itemInteligence;
	}
	
	
}
