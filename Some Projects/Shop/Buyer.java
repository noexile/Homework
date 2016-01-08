package Shop;

public class Buyer {
	
//	Всеки купувач може да извършва следните действия:
//	- Да добавя продукт на килограм към количката си;
//	- Да добавя продукт на бройки в количката си;
//	- Да премахва продукт на килограм от количката си;
//	- Да премахва продукт на бройки от количката си.
	
//	Ако продукта се продава на килограм или на бройки, се упоменава колко килограма или
//	колко броя от продукта се добавят или премахват. Добавянето или премахването на
//	продукта ше актуализира наличността на съответния продукт както в количката на
//	купувача, така и в магазина, в който се намира.
	
//	- Да плаща всички продукти на касата. Плащането увеличава парите на магазина и намалява тези на купувача.
	
	private Shop enteredShop;
	private double money;
	private int maxPiecesThatCanBeBough;
	Product[] productCart;
	private int cartFreePlaces;
	private int productPosition;
	private double ammountToPay;
	

	Buyer(Shop enteredShop, double money, int maxPiecesThatCanBeBough) {
		setEnteredShop(enteredShop);
		setMoney(money);
		setMaxPiecesThatCanBeBough(maxPiecesThatCanBeBough);
		this.productCart = new Product[enteredShop.productLimit];
		this.cartFreePlaces = maxPiecesThatCanBeBough;
	}
	
	void payShop(double totalAmount) {
		if (getMoney() < totalAmount) {
			System.out.println("Not enough money.");
		}
		setMoney(getMoney() - totalAmount);
		getEnteredShop().setMoneyInCashRegister(getEnteredShop().getMoneyInCashRegister() + totalAmount);
	}
	
	void addPieceProductToCart(PieceProduct product, int quantity) {
		if (freePlacesValidation()) {
			return;
		}
		if (getMoney() < getAmmountToPay() + product.sellProduct(quantity)) {
			System.out.println("Cannot add product to cart - not enough money.");
			return;
		}
		
		for (int i = 0; i < enteredShop.productLimit; i++) {
			if(enteredShop.productList[i].equals(product)) {
				if (enteredShop.productList[i].pieceProduct.getQuantity() < quantity) {
					System.out.println("Insufficient quantity.");
					return;
				}
				
				enteredShop.productList[i].pieceProduct.setQuantity(enteredShop.productList[i].pieceProduct.getQuantity() - quantity);
			}
		}
		
		setAmmountToPay(getAmmountToPay() + product.sellProduct(quantity));
		productCart[productCart.length - cartFreePlaces--] = product;
	}

	void addQuantityProductToCart(QuantityProduct product, double quantity) {
		if (freePlacesValidation()) {
			return;
		}
		if (getMoney() < getAmmountToPay() + product.sellProduct(quantity)) {
			System.out.println("Cannot add product to cart - not enough money.");
			return;
		}
		
		for (int i = 0; i < enteredShop.productLimit; i++) {
			if(enteredShop.productList[i].equals(product)) {
				if (enteredShop.productList[i].quantityProduct.getQuantity() < quantity) {
					System.out.println("Insufficient quantity.");
					return;
				}
				
				enteredShop.productList[i].quantityProduct.setQuantity(enteredShop.productList[i].pieceProduct.getQuantity() - quantity);
			}
		}
		
		setAmmountToPay(getAmmountToPay() + product.sellProduct(quantity));
		productCart[productCart.length - cartFreePlaces--] = product;
	}
	
	// TODO
	void removePieceProductFromCart(PieceProduct product, int quantity) {
		
	}
	
	// TODO
	void removeQuantityProductFromCart(QuantityProduct product, double quantity) {
			
	}
		
	boolean freePlacesValidation() {
		if (getCartFreePlaces() < 1) {
			System.out.println("Not enough free places in the cart.");
			return false;
		}
		return true;
	}
	
	// getters and setters
	private Shop getEnteredShop() {
		return enteredShop;
	}
	
	private void setEnteredShop(Shop enteredShop) {
		this.enteredShop = enteredShop;
	}
	
	private double getMoney() {
		return money;
	}
	
	private void setMoney(double money) {
		this.money = money;
	}
	
	private int getMaxPiecesThatCanBeBough() {
		return maxPiecesThatCanBeBough;
	}
	
	private void setMaxPiecesThatCanBeBough(int maxPiecesThatCanBeBough) {
		this.maxPiecesThatCanBeBough = maxPiecesThatCanBeBough;
	}
	
	private int getCartFreePlaces() {
		return cartFreePlaces;
	}

	private void setCartFreePlaces(int cartFreePlaces) {
		this.cartFreePlaces = cartFreePlaces;
	}
	
	private int getProductPosition() {
		return productPosition;
	}

	private void setProductPosition(int productPosition) {
		this.productPosition = productPosition;
	}

	public double getAmmountToPay() {
		return ammountToPay;
	}

	public void setAmmountToPay(double ammountToPay) {
		this.ammountToPay = ammountToPay;
	}
}
