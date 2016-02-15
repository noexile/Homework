package musicShop;

public class Instrument implements Comparable<Instrument>{

	private String name;
	private int price;
	private int availableQuantity;
	
	
	public Instrument(String name, int price, int availableQuantity) {
		this.name = name;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}
	
	// getters and setters
	public String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	void setPrice(int price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	
	// compare by instrument quantity
	@Override
	public int compareTo(Instrument compareInstrument) {
		int compareQuantity = ((Instrument) compareInstrument).getAvailableQuantity(); 
		
		return compareQuantity - getAvailableQuantity();
	}
	
}
