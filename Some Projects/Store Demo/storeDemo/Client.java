package storeDemo;

public class Client extends Thread {
	
	Shop shop;
	
	
	public Client(String name, Shop shop) {
		super(name);
		this.shop = shop;
	}
	
	@Override
	public void run() {
		while (true) {
			shop.takeFromShop(Warehouse.Meat.BEEF.toString().toLowerCase());
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}

}
