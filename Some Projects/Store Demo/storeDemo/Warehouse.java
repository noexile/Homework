package storeDemo;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Warehouse {
	
	enum Vegetable {CUCUMBER, PEPPER, CARROT}
	enum Meat {BEEF, CHICKEN, PORK}
	enum Sweet {WAFFLE, BALKAN, ANELIA}
	static final String VEGETABLE_NAME = "vegetable";
	static final String MEAT_NAME = "meat";
	static final String SWEET_NAME = "sweet";
	
	static final int NUMBER_OF_ITEMS_TO_ADD = 50;
	static final int NUMBER_OF_ITEMS_TO_TAKE = 3;
	static final int MINIMUM_QUANTITY = 5;
	
	
	TreeMap<String, TreeMap<String, Integer>> products;
	
	Warehouse() {
		this.products = new TreeMap<String, TreeMap<String, Integer>>();
		
		this.products.put(VEGETABLE_NAME, new TreeMap<String, Integer>()); // product type , TreeMap<product name, quantity>
		this.products.get(VEGETABLE_NAME).put(Vegetable.CUCUMBER.toString().toLowerCase(), 18); //
		this.products.get(VEGETABLE_NAME).put(Vegetable.PEPPER.toString().toLowerCase(), 33);
		this.products.get(VEGETABLE_NAME).put(Vegetable.CARROT.toString().toLowerCase(), 24);
		
		this.products.put(MEAT_NAME, new TreeMap<String, Integer>()); // product type , TreeMap<product name, quantity>
		this.products.get(MEAT_NAME).put(Meat.BEEF.toString().toLowerCase(), 13);
		this.products.get(MEAT_NAME).put(Meat.CHICKEN.toString().toLowerCase(), 179);
		this.products.get(MEAT_NAME).put(Meat.PORK.toString().toLowerCase(), 19);
		
		this.products.put(SWEET_NAME, new TreeMap<String, Integer>()); // product type , TreeMap<product name, quantity>
		this.products.get(SWEET_NAME).put(Sweet.WAFFLE.toString().toLowerCase(), 30);
		this.products.get(SWEET_NAME).put(Sweet.BALKAN.toString().toLowerCase(), 24);
		this.products.get(SWEET_NAME).put(Sweet.ANELIA.toString().toLowerCase(), 12);
	}
	
	synchronized void takeFromWarehouse(String productName) {
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
	
	synchronized void addToWarehouse() {
		ArrayList<String> outOfStockItems = getOutOfStockItems();
		if(outOfStockItems.size() == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				
			}
		} else {
			for (String product : outOfStockItems) {
				addItems(product);
			}
			notifyAll();
		}
	}
	
	private void take(String productName) {
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> insideMap = outsideMap.getValue();
			if(insideMap.containsKey(productName)) {
				insideMap.put(productName, insideMap.get(productName) - NUMBER_OF_ITEMS_TO_TAKE);
				break;
			}
		}
	}
		
	
	private void addItems(String productName) {
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> insideMap = outsideMap.getValue();
			if(insideMap.containsKey(productName)) {
				insideMap.put(productName, insideMap.get(productName) + 50);
				break;
			}
		}
	}
		

	private boolean productOutOfStock(String productName) {
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> insideMap = outsideMap.getValue();
			if(insideMap.containsKey(productName)) {
				return insideMap.get(productName) <= MINIMUM_QUANTITY;
			}
		}
		return true;
	}
	
	private ArrayList<String> getOutOfStockItems() {
		ArrayList<String> outOfStock = new ArrayList<>();
		for(Entry<String, TreeMap<String, Integer>> outsideMap : products.entrySet()) {
			TreeMap<String, Integer> productsByType = outsideMap.getValue();//products.get(type);
			for(Entry<String, Integer> insideMap : productsByType.entrySet()) {
				if(insideMap.getValue() <= MINIMUM_QUANTITY)
					outOfStock.add(insideMap.getKey());
			}
		}
		return outOfStock;
	}
}
