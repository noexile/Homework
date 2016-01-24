package Market;

import java.util.Random;

public class TargovskaVeriga extends Targovec {
	
	private Random rand = new Random();	
	private int counter1 = 1;
	private int counter2 = 1;
	private int counter3 = 1;
	
	final static int NUMBER_OF_TARGOVSKI_OBEKTI = 10;
	final static int NUMBER_OF_DOSTAVCHICI = 15;

	public TargovskaVeriga(String name, String registrationAddress, int money) {
		super(name, registrationAddress, money, NUMBER_OF_TARGOVSKI_OBEKTI, NUMBER_OF_DOSTAVCHICI);	
		addTargovskiObekt();
		addDostavchici();
	}
	
	// methods
	@Override
	protected void addTargovskiObekt() {
		for (int i = 0; i < this.targovskiObekt.length; i++) {
			int temp = rand.nextInt((3 - 1) + 1) + 1;
			
			switch(temp) {
			case 1: this.targovskiObekt[i] = new Sergia("ul. Klokotnica " + this.counter1++, "09:00 - 18:00");
				break;
			case 2: this.targovskiObekt[i] = new MagazinVMola("ulicata na Mol Serdika " + this.counter2++, "10:00 - 21:00");
				break;
			case 3: this.targovskiObekt[i] = new ButkaNaUlicata("ul. Sharena " + this.counter3++, "08:00 - 15:00");
				break;
				
				default: System.out.println("If you are reading this then shit got real !?");
					break;
			}
		}
		this.counter1 = 1;
		this.counter2 = 1;
		this.counter3 = 1;
	}

	@Override
	protected void addDostavchici() {
			for (int i = 0; i < this.dostavchik.length; i++) {
				boolean temp = rand.nextBoolean();
				if (temp) {
					this.dostavchik[i] = new DostavchikNaDrebno("Dostavchik na drebno " + counter1, "ul. nezabravka " + counter1++, "08:00 - 20:00");
				} else {
					this.dostavchik[i] = new DostavchikNaEdro("Dostavchik na edro " + counter2, "ul. nezabravka " + counter2++, "08:00 - 20:00");
				}
			}
		this.counter1 = 1;
		this.counter2 = 1;
	}
	
	@Override
	public void addProducts(int price) {
		
		int currentTargovskiObekt = rand.nextInt((targovskiObekt.length - 0) + 0);
		int temproraryDostavchik = rand.nextInt((NUMBER_OF_DOSTAVCHICI - 1) + 1) + 1;

		if (price * 2 > getMoney()) {
			System.out.println("The price of the order cannot exceed the half of your money !");
			System.out.println("You have: " + getMoney());
			return;
		}

		for (int i = 0; i < this.products.length; i++) {

			if (price == 0) {
				return;
			}

			int temp = rand.nextInt((5 - 1) + 1) + 1;
			Product tempProduct = null;

			switch (temp) {
				case 1:
					tempProduct = new Product("fish", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
					break;
				case 2:
					tempProduct = new Product("kniga", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
					break;
				case 3:
					tempProduct = new Product("gumi", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
					break;
				case 4:
					tempProduct = new Product("himikal", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
					break;
				case 5:
					tempProduct = new Product("atomna centrala", rand.nextInt(Product.MAX_PRICE - Product.MIN_PRICE) + Product.MIN_PRICE);
					break;
	
				default:
					System.out.println("If you are reading this ... well better don't ...");
					break;
			}

			if (tempProduct.getProductPrice() > price) {
				tempProduct.setProductPrice(price);
			}

			this.targovskiObekt[currentTargovskiObekt].products[this.targovskiObekt[currentTargovskiObekt].products.length - this.targovskiObekt[currentTargovskiObekt].getFreePlacesForProducts()] = tempProduct;
			this.targovskiObekt[currentTargovskiObekt].setFreePlacesForProducts(this.targovskiObekt[currentTargovskiObekt].getFreePlacesForProducts() - 1);
			
			System.out.print("Dostavchik " + dostavchik[temproraryDostavchik].getName() + " prodade stoka na " + this.getName() + " za ");
			if (dostavchik[temproraryDostavchik] instanceof DostavchikNaDrebno) {
				System.out.println(price);
				setMoney(getMoney() - price);
			} else if (dostavchik[temproraryDostavchik] instanceof DostavchikNaEdro) {
				System.out.println(price - ((price / 100) * 15));
				setMoney(getMoney() - (price - ((price / 100) * 15)));
			}
		
		}
	}

}
