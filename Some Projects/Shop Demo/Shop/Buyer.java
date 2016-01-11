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
	Product[] productCart;
	private int cartFreePlaces;
	private double ammountToPay;
	

	public Buyer(Shop enteredShop, double money) {
		setEnteredShop(enteredShop);
		setMoney(money);
		this.productCart = new Product[enteredShop.productLimit];
		setCartFreePlaces(productCart.length);
		setAmmountToPay(0);
	}
	
	public void payShop() {
		if (getMoney() < getAmmountToPay()) {
			System.out.println("Not enough money.");
			return;
		} 
		
		System.out.println();
		System.out.println("client's money before purchace: " + getMoney());
		System.out.println("---");
		setMoney(getMoney() - getAmmountToPay());
		getEnteredShop().setMoneyInCashRegister(getEnteredShop().getMoneyInCashRegister() + getAmmountToPay());
		System.out.println("ammount to pay: " + getAmmountToPay());
		System.out.println("client's money after purchace: " + getMoney());
		setAmmountToPay(0);
	}
	
	public void addPieceProductToCart(Product product, int quantity) {
		if (getCartFreePlaces() == 0) {
			System.out.println("No more room in the cart.");
			return;
		}
		
		if (product instanceof PieceProduct) {
			for (int i = 0; i < productCart.length; i++) {
				if (productCart[i] != null) {
					continue;
				}
				
				if (product.getName().equals(enteredShop.productList[i].getName())) {
					
					if ((((PieceProduct)enteredShop.productList[i]).getQuantity() < quantity)) {
						System.out.println("---");
						System.out.println("Insufficient product quantity: " + enteredShop.productList[i].getName() + " - " + ((PieceProduct)enteredShop.productList[i]).getQuantity() + " pcs.");
						System.out.println("---");
						return;
					}
					
					productCart[i] = product;
					setCartFreePlaces(getCartFreePlaces() - 1);
					setAmmountToPay(getAmmountToPay() + (product.getPrice() * quantity)); 
							
					((PieceProduct)enteredShop.productList[i]).setQuantity(((PieceProduct)enteredShop.productList[i]).getQuantity() - quantity);
					break;
				}

			}
		}
		
	}

	public void addQuantityProductToCart(Product product, double quantity) {
		if (getCartFreePlaces() == 0) {
			System.out.println("No more room in the cart.");
			return;
		}
		
		if (product instanceof QuantityProduct) {
			for (int i = 0; i < productCart.length; i++) {
				if (productCart[i] != null) {
					continue;
				}
				
				if (product.getName().equals(enteredShop.productList[i].getName())) {
					
					if ((((QuantityProduct)enteredShop.productList[i]).getQuantity() < quantity)) {
						System.out.println("Insufficient product quantity: " + enteredShop.productList[i].getName() + " - " + ((PieceProduct)enteredShop.productList[i]).getQuantity() + " kg.");
						return;
					}
					
					productCart[i] = product;
					setCartFreePlaces(getCartFreePlaces() - 1);
					setAmmountToPay(getAmmountToPay() + (product.getPrice() * quantity)); 
							
					((QuantityProduct)enteredShop.productList[i]).setQuantity(((QuantityProduct)enteredShop.productList[i]).getQuantity() - quantity);
					break;
				}

			}
		}
	}
	
	public void removePieceProductFromCart(Product product, int quantity) {
		if (product instanceof PieceProduct) {
			for (int i = 0; i < productCart.length; i++) {
				if (productCart[i] == null) {
					continue;
				}
				
				if (product.getName().equals(enteredShop.productList[i].getName())) {
					if (((PieceProduct)productCart[i]).getQuantity() < quantity) {
						System.out.println("Available quantity in the cart: " + enteredShop.productList[i].getName() + " - " + ((PieceProduct)productCart[i]).getQuantity() + " pcs.");
						return;
					}
					
					setCartFreePlaces(getCartFreePlaces() + 1);
					setAmmountToPay(getAmmountToPay() - (product.getPrice() * quantity)); 
					
					((PieceProduct)enteredShop.productList[i]).setQuantity(((PieceProduct)enteredShop.productList[i]).getQuantity() + quantity);
					
					if (((PieceProduct)productCart[i]).getQuantity() == quantity) {
						productCart[i] = null;
					}
					break;
				}
				
			}
		}
	}
	
	public void removeQuantityProductFromCart(Product product, double quantity) {
		if (product instanceof QuantityProduct) {
			for (int i = 0; i < productCart.length; i++) {
				if (productCart[i] == null) {
					continue;
				}
				
				if (product.getName().equals(enteredShop.productList[i].getName())) {
					if (((QuantityProduct)productCart[i]).getQuantity() < quantity) {
						System.out.println("Available quantity in the cart: " + enteredShop.productList[i].getName() + " - " + ((QuantityProduct)productCart[i]).getQuantity() + " pcs.");
						return;
					}
					
					setCartFreePlaces(getCartFreePlaces() + 1);
					setAmmountToPay(getAmmountToPay() - (product.getPrice() * quantity)); 
					
					((QuantityProduct)enteredShop.productList[i]).setQuantity(((QuantityProduct)enteredShop.productList[i]).getQuantity() + quantity);
					
					if (((QuantityProduct)productCart[i]).getQuantity() == quantity) {
						productCart[i] = null;
					}
					break;
				}
				
			}
		}
	}
		
	boolean freePlacesValidation() {
		if (getCartFreePlaces() < 1) {
			System.out.println("Not enough free places in the cart.");
			return false;
		}
		return true;
	}
	
	boolean containsProduct(Product product) {
		
		for (int i = 0; i < productCart.length; i++) {
			if (productCart[i] == null) {
				continue;
			}
			if (!productCart[i].equals(product)) {
				return false;
			}
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
	
	private int getCartFreePlaces() {
		return cartFreePlaces;
	}

	private void setCartFreePlaces(int cartFreePlaces) {
		this.cartFreePlaces = cartFreePlaces;
	}

	public double getAmmountToPay() {
		return ammountToPay;
	}

	public void setAmmountToPay(double ammountToPay) {
		this.ammountToPay = ammountToPay;
	}
}
