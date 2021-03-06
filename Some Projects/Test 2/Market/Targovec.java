//	�� �� ������ �����, ����� ������ ������ �� ����������� �������� � �� ����� �������� �� ������� ��������� �������. ����������� ������� e:
//	   - ������� �� ����� �� ��������� �� ����� ��������� �����. �� �� ������� �� ������ ������� ��� �����, �������� �� ���� � ��������� ���.

//	   - ��������� �� ������ �� ����� ��������� ����� � �� �� ������� �� ������ ������ ���� �� ���������. ���� �������� �������� �
//	     ���������� ����� � �������� ������ ������ �� � �������� �� ����.

//	   - ������� �� ������� ����� ��� ��������� �� ����� ��������� �����.

package Market;

import java.util.Random;

public abstract class Targovec {
	
	private static final int MAX_LIMIT_OF_PRODUCTS = 10_000;
	private static Random rand = new Random();
	private String name;
	private String registrationAddress;
	private int money;
	protected TargovskiObekt[] targovskiObekt;
	protected Dostavchik[] dostavchik;
	protected Product[] products;
	protected int freePlacesForProducts;
	
	// constructor
	public Targovec(String name, String registrationAddress, int money, int shops, int dostavchici) {
		setName(name);
		setRegistrationAddress(registrationAddress);
		setMoney(money);
		this.targovskiObekt = new TargovskiObekt[shops];
		this.dostavchik = new Dostavchik[dostavchici];
		this.products = new Product[MAX_LIMIT_OF_PRODUCTS];
		setFreePlacesForProducts(MAX_LIMIT_OF_PRODUCTS);
	}
	
	// methods
	protected abstract void addTargovskiObekt();
	protected abstract void addDostavchici();
	
	public static void startWork(Targovec[] targovci) {
		for (int i = 0; i < targovci.length; i++) {
			int tempPrice = rand.nextInt((targovci[i].getMoney()));
			targovci[i].addProducts(tempPrice);
		}
	}
	
	// adding products
	public void addProducts(int price) {
		
		if (price * 2 > getMoney()) {
			System.out.println("The price of the order cannot exceed the half of your money !");
			System.out.println("You have: " + getMoney());
			return;
		}
		
		for (int i = 0; i < this.products.length; i++) {
			
			if(price == 0) {
				return;
			}
			
			int temp = rand.nextInt((5 - 1) + 1) + 1;
			Product tempProduct = null;
			
			switch (temp) {
			case 1: tempProduct = new Product("fish", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
				break;
			case 2: tempProduct = new Product("kniga", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
				break;
			case 3: tempProduct = new Product("gumi", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
				break;
			case 4: tempProduct = new Product("himikal", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
				break;
			case 5: tempProduct = new Product("atomna centrala", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
				break;
				
			default: System.out.println("If you are reading this ... well better don't ...");
				break;
			}
			
			if (tempProduct.getProductPrice() > price) {
				tempProduct.setProductPrice(price);
			}
			
			this.products[this.products.length - this.freePlacesForProducts--] = tempProduct;
			price -= tempProduct.getProductPrice();
		}
		
		// TODO sorting
//		for (int i = 0; i < this.products.length - getFreePlacesForProducts(); i++) {
//			
//		}
	}
	
	public void sellAllGoodsFromTargovskiObekt(int number) {
		if (number > this.targovskiObekt[number].products.length) {
			System.out.println("no such targovski obekt");
			return;
		}
		
		for (int i = 0; i < this.targovskiObekt[number].products.length - this.targovskiObekt[number].getFreePlacesForProducts(); i++) {
			int tempMoney = (this.targovskiObekt[number].products[i].getProductPrice() / 100) * 130;
			setMoney(getMoney() + tempMoney);
			this.targovskiObekt[number].products[i] = null;
			this.targovskiObekt[number].setFreePlacesForProducts(this.targovskiObekt[number].getFreePlacesForProducts() + 1);
		}
	}
	
	public void payTax() {
		int totalTax = 0;
		for (int i = 0; i < targovskiObekt.length; i++) {
			totalTax += targovskiObekt[i].getCountryTax();
		}
		System.out.println("Total tax for: " + this.getName() + " is " + totalTax);
		System.out.println("Money before tax: " + getMoney());
		setMoney(getMoney() - totalTax);
		System.out.println("Money after tax: " + getMoney());
	}
	
	public void printBallance() {
		System.out.println("Ballance: " + getMoney());
	}

	// getters and setters
	protected String getName() {
		return name;
	}
	
	protected void setName(String name) {
		this.name = name;
	}
	
	protected String getRegistrationAddress() {
		return registrationAddress;
	}
	
	protected void setRegistrationAddress(String registrationAddress) {
		this.registrationAddress = registrationAddress;
	}

	public int getMoney() {
		return money;
	}

	protected void setMoney(int money) {
		this.money = money;
	}

	protected int getFreePlacesForProducts() {
		return freePlacesForProducts;
	}

	protected void setFreePlacesForProducts(int freePlacesForProducts) {
		this.freePlacesForProducts = freePlacesForProducts;
	}
	
	
}
