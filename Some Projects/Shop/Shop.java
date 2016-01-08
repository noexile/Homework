package Shop;

public class Shop {
	
	/*
	 * Магазинът има следните характеристики:
	 - Наименование;
   	 - Адрес;
 	 - Пари в касата;
	 - Списък с продукти.
	 * 
	 */
	public final int productLimit;
	
	private String name;
	private String address;
	private double moneyInCashRegister;
	Product[] productList;
	private int freePlacesForProducts;
	
	Shop (String name, String address, double moneyInCashRegister, int productLimit) {
		setName(name);
		setAddress(address);
		setMoneyInCashRegister(moneyInCashRegister);
		this.productLimit = productLimit;
		setFreePlacesForProducts(productLimit);
	}
	
	void addProduct(Product product) {
		if (getFreePlacesForProducts() < 1) {
			System.out.println("Not enough free places for new products!");
			return;
		}
		if (product instanceof QuantityProduct) {
			productList[productList.length - freePlacesForProducts] = (QuantityProduct)product;
		} else if (product instanceof PieceProduct) {
			productList[productList.length - freePlacesForProducts] = (PieceProduct)product;
		}
		
		setFreePlacesForProducts(getFreePlacesForProducts() - 1);
	}
	
	// TODO
	void removeProduct(Product product) {
		
	}
	
	// getters and setters
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	String getAddress() {
		return address;
	}

	void setAddress(String address) {
		this.address = address;
	}

	double getMoneyInCashRegister() {
		return moneyInCashRegister;
	}

	void setMoneyInCashRegister(double moneyInCashRegister) {
		this.moneyInCashRegister = moneyInCashRegister;
	}

	public int getFreePlacesForProducts() {
		return freePlacesForProducts;
	}

	public void setFreePlacesForProducts(int freePlacesForProducts) {
		this.freePlacesForProducts = freePlacesForProducts;
	}
}
