package Shop;

public class QuantityProduct extends Product {
	
	private double quantity;
	
	public QuantityProduct(String name, double price, double quantity) {
		super(name, price);
		setQuantity(quantity);
	}

	
	// getters and setters
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
}
