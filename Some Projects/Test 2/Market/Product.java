package Market;

public class Product {
	
	static final int MAX_PRICE = 15;
	static final int MIN_PRICE = 5;
	
	private String productname;
	private int productPrice;

	Product(String productName, int price) {
		setProductname(productName);
		setProductPrice(price);
	}
	
	// getters and setters
	protected String getProductname() {
		return productname;
	}

	protected void setProductname(String productname) {
		this.productname = productname;
	}

	protected int getProductPrice() {
		return productPrice;
	}

	protected void setProductPrice(int productPrice) {
		this.productPrice = productPrice;
	}

}
