package Shop;

public class QuantityProduct extends Product {
	
	private double quantity;
	
	QuantityProduct(String name, double price, double quantity) {
		super(name, price);
		setQuantity(quantity);
	}
	
	double sellProduct(double quantity) {
		return this.getPrice() * quantity;
	}

	
	// getters and setters
	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
}
