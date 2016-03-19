package Shop;

public abstract class Product {
	
//	Всеки продукт има следните характеристики:
//	- Наименование;
//	- Цена;
//	- Наличност –килограм или брой в зависимост от вида на продукта.
	
//	Продуктите могат да се продават на килограм или на бройка. Няма продукти, които да се
//	продават както на килограм, така и на брой.
//	В магазина могат да пазаруват купувачи. Всеки купувач има следните характеристики:
//	- Магазин, в който е влязал да пазарува;
//	- Сума пари, която носи със себе си;
//	- Максимален брой артикули, които може да купи.
	
	private String name;
	private double price;
	
	Product (String name, double price) {
		setName(name);
		setPrice(price);
	}
	
	
	// getters and setters
	protected String getName() {
		return name;
	}

	protected void setName(String name) {
		this.name = name;
	}

	protected double getPrice() {
		return price;
	}

	protected void setPrice(double price) {
		this.price = price;
	}
}
