package Shop;

public class PieceProduct extends Product {
	
	private int quantity;
	
	PieceProduct(String name, double price, int quantity) {
		super(name, price);
		setQuantity(quantity);
	}
	
	double sellProduct(int quantity) {
		return this.getPrice() * quantity;
	}
	
	// getters and setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
