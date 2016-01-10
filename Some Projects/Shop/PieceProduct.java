package Shop;

public class PieceProduct extends Product {
	
	private int quantity;
	
	PieceProduct(String name, double price, int quantity) {
		super(name, price);
		setQuantity(quantity);
	}
	
	
	// getters and setters
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
}
