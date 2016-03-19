package storeDemo;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

import storeDemo.Warehouse.Meat;
import storeDemo.Warehouse.Sweet;
import storeDemo.Warehouse.Vegetable;

class Shop extends Thread {
	
	Warehouse warehouse = Demo.warehouse;
	TreeMap<String, TreeMap<String, Integer>> products;
	String name;
	
	@Override
	public void run() {
		while (true) {
			addToShop();
			try {
				Thread.currentThread().sleep(500);
			} catch (InterruptedException e) {
				
			}
		}
	}
	
	
	public Shop(String shopName) {
		this.name = shopName;
		this.products = new TreeMap<String, TreeMap<String, Integer>>();
		
		this.products.put(Warehouse.VEGETABLE_NAME, new TreeMap<String, Integer>()); // product type , TreeMap<product name, quantity>
		this.products.get(Warehouse.VEGETABLE_NAME).put(Vegetable.CUCUMBER.toString().toLowerCase(), 10); //
		this.products.get(Warehouse.VEGETABLE_NAME).put(Vegetable.PEPPER.toString().toLowerCase(), 10);
		this.products.get(Warehouse.VEGETABLE_NAME).put(Vegetable.CARROT.toString().toLowerCase(), 10);
		
		this.products.put(Warehouse.MEAT_NAME, new TreeMap<String, Integer>()); // product type , TreeMap<product name, quantity>
		this.products.get(Warehouse.MEAT_NAME).put(Meat.BEEF.toString().toLowerCase(), 10);
		this.products.get(Warehouse.MEAT_NAME).put(Meat.CHICKEN.toString().toLowerCase(), 10);
		this.products.get(Warehouse.MEAT_NAME).put(Meat.PORK.toString().toLowerCase(), 10);
		
		this.products.put(Warehouse.SWEET_NAME, new TreeMap<String, Integer>()); // product type , TreeMap<product name, quantity>
		this.products.get(Warehouse.SWEET_NAME).put(Sweet.WAFFLE.toString().toLowerCase(), 10);
		this.products.get(Warehouse.SWEET_NAME).put(Sweet.BALKAN.toString().toLowerCase(), 10);
		this.products.get(Warehouse.SWEET_NAME).put(Sweet.ANELIA.toString().toLowerCase(), 10);
	}
	
	synchronized void addToShop() {
		ArrayList<String> depleted = getDepletedProducts();
		if(depleted.size() == 0){
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		} else {
			for(String product : depleted) {
				fillQuantity(product);
			}
			notifyAll();
		}
	}
	
	synchronized void takeFromShop (String productName) {
		if(productOutOfStock(productName)) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			} 
		} else {
			take(productName);
			notifyAll();
		}
	}

	private ArrayList<String> getDepletedProducts() {
		ArrayList<String> outOfStock = new ArrayList<>();
		
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> productsByType = outsideMap.getValue();//products.get(type);
			for(Entry<String, Integer> insideMap : productsByType.entrySet()) {
				if(insideMap.getValue() <= Warehouse.MINIMUM_QUANTITY)
					outOfStock.add(insideMap.getKey());
			}
		}
		return outOfStock;
	}
	
	private void fillQuantity(String productName) {
		warehouse.takeFromWarehouse(productName);
		
		int quantity = 0;
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> insideMap = outsideMap.getValue();
			if(insideMap.containsKey(productName)) {
				insideMap.put(productName, insideMap.get(productName) + 50);
				quantity = insideMap.get(productName);
				break;
			}
		}
		System.out.println(this.name + " adds " + Warehouse.NUMBER_OF_ITEMS_TO_ADD + " " + productName + " from the warehouse. Quantity left: " + quantity);
	}
	
	private boolean productOutOfStock(String productName) {
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> insideMap = outsideMap.getValue();
			if(insideMap.containsKey(productName)) {
				return insideMap.get(productName) <= Warehouse.MINIMUM_QUANTITY;
			}
		}
		return true;
	}
	
	private void take(String productName) {
		int quantity = 0;
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> insideMap = outsideMap.getValue();
			if(insideMap.containsKey(productName)) {
				insideMap.put(productName, insideMap.get(productName) - Warehouse.NUMBER_OF_ITEMS_TO_TAKE);
				quantity = insideMap.get(productName);
				break;
			}
		}
		System.out.println(Thread.currentThread().getName() + " takes " + Warehouse.NUMBER_OF_ITEMS_TO_TAKE + " " + productName + " from " + this.name + " . Quantity left: " + quantity);
	}
		
}