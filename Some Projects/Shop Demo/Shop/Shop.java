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
	
	public Shop (String name, String address, double moneyInCashRegister, int productLimit) {
		setName(name);
		setAddress(address);
		setMoneyInCashRegister(moneyInCashRegister);
		this.productLimit = productLimit;
		setFreePlacesForProducts(productLimit);
		this.productList = new Product[productLimit];
	}
	
	public void addProduct(Product product) {
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
	
	public void viewItemsInShop() {
		for (int i = 0; i < productList.length; i++) {
			if (productList[i] != null) {
				if (productList[i] instanceof PieceProduct) {
					System.out.println("Product: " + productList[i].getName() + " - " + ((PieceProduct) productList[i]).getQuantity() + " pcs.");
				} else if(productList[i] instanceof QuantityProduct) {
					System.out.println("Product: " + productList[i].getName() + " - " + ((QuantityProduct) productList[i]).getQuantity() + " kg.");
				}
			}
		}
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
