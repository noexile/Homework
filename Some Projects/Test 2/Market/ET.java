//	ЕТ – едноличен търговец – той оперира само с доставчици на дребно (не
//	повече от 5) и притежава един търговски обект. ЕТ може да притежава
//	бутка на улицата или сергия на пазара.

//	• да прави поръчка на определена стойност към доставчик. Поръчката не може да надвишава 50% от капитала на търговеца. Ако доставчика
//	направи отстъпка, разликата в парите да се върне обратно на търговеца. 

//	При поръчка на стоки от доставчик, търговеца приема в търговския обект
//	списък с произволно генериран брой продукти, като всеки продукт има наименование и произволна цена между 5 и 15 лева. Общата цена на
//	продуктите представлява стойността на доставката.

package Market;

import java.util.Random;

public class ET extends Targovec {

	final static int NUMBER_OF_TARGOVSKI_OBEKTI = 1;
	final static int NUMBER_OF_DOSTAVCHICI = 5;
	private Random rand = new Random();

	public ET(String name, String registrationAddress, int money) {
		super(name, registrationAddress, money, NUMBER_OF_TARGOVSKI_OBEKTI, NUMBER_OF_DOSTAVCHICI);
		addTargovskiObekt();
		addDostavchici();
	}

	// methods
	@Override
	protected void addTargovskiObekt() {
		for (int i = 0; i < this.targovskiObekt.length; i++) {
			boolean temp = rand.nextBoolean();

			if (temp) {
				this.targovskiObekt[i] = new ButkaNaUlicata("Budka na ulicata", "08:00 - 17:00");
			} else {
				this.targovskiObekt[i] = new Sergia("Sergia za produkti", "09:00 - 18:00");
			}
		}
	}

	@Override
	protected void addDostavchici() {
		for (int i = 0; i < dostavchik.length; i++) {
			this.dostavchik[i] = new DostavchikNaDrebno("Toshko Eood " + i, "ul. rezbarska " + i, "08:00 - 20:00");
		}
	}

	// adding products
	public void addProducts(int price) {
		int currentTargovskiObekt = rand.nextInt((targovskiObekt.length - 0) + 0);

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
			price -= tempProduct.getProductPrice();
		}
	}

}
