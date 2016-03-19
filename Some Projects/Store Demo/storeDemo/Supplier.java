package storeDemo;

class Supplier extends Thread {
	
	Warehouse warehouse = Demo.warehouse;
	
	Supplier(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		while (true) {
			warehouse.addToWarehouse();
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
}