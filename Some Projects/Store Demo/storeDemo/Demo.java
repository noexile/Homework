package storeDemo;

import storeDemo.Warehouse;

public class Demo {

	static Warehouse warehouse = new Warehouse();
	static Shop shop1 = new Shop("Shop 1");
	static Shop shop2 = new Shop("Shop 2");
	static Shop shop3 = new Shop("Shop 3");

	public static void main(String[] args) {

		shop1.start();
		shop2.start();
		shop3.start();
		
		new Supplier("Supplier 1").start();
		
		new Client("Client 1", shop1).start();
		new Client("Client 2", shop1).start();
		new Client("Client 3", shop1).start();
		
		new Client("Client 4", shop2).start();
		new Client("Client 5", shop2).start();
		new Client("Client 6", shop2).start();
		
		new Client("Client 7", shop3).start();
		new Client("Client 8", shop3).start();
		new Client("Client 9", shop3).start();
		
		
//		shop1.printShopProducts();
	}

}
