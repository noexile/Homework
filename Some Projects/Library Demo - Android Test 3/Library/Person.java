package Library;

import java.util.ArrayList;
import java.util.Random;

import LibraryDemo.Demo;

public class Person extends Thread {
	
	ArrayList<ReadableItem> takenItemsFromLibrary;
	private Library library;
	
	public Person(String name) {
		super(name);
		this.takenItemsFromLibrary = new ArrayList<ReadableItem>();
		this.library = Demo.lib;
	}
	
	@Override
	public void run() {
		enterLibrary();
		
		Random rand = new Random();
		while (true) {
			int timeToSleep = rand.nextInt(8001 - 4000) + 4000;
			
			try {
				Thread.currentThread().sleep(timeToSleep);
			} catch (InterruptedException e) {}
			
			if (rand.nextBoolean()) { // take book
				String randomName = this.library.nameOfReadableItems.get(rand.nextInt(this.library.nameOfReadableItems.size()));
				takeReadableItem(randomName);
				
			} else { // return book
				if (this.takenItemsFromLibrary.size() != 0) {
					String name = ((ReadableItem)this.takenItemsFromLibrary.get(rand.nextInt(this.takenItemsFromLibrary.size() - 0) + 0)).getName();
					returnReadableItem(name);
				}
			}
			
		}		
	}
	
	synchronized private void enterLibrary() {
		this.library.customers.add(this);
	}
	
	private void takeReadableItem(String name) {
		ReadableItem itemTaken = this.library.takeReadableItemFromLibrary(name, this);	
		if (itemTaken != null) {
			takenItemsFromLibrary.add((ReadableItem) itemTaken);
		}
	}
	
	private void returnReadableItem(String name) {
		this.library.returnReadableItemFromLibrary(name, this);
		
		for (int i = 0; i < this.takenItemsFromLibrary.size(); i++) {
			if (((ReadableItem)this.takenItemsFromLibrary.get(i)).getName().equalsIgnoreCase(name)) {
				
				long returnedTime = System.currentTimeMillis() - ((ReadableItem)this.takenItemsFromLibrary.get(i)).getTakenOn();
				
				int rentMoney = 2;
				double rentPercent = 0.02;
				
				if (this.takenItemsFromLibrary.get(i) instanceof Textbook) {
					rentMoney = 3;
					rentPercent = 0.03;
				}
				
				if (returnedTime <= 10_000) {
					System.out.println("Payed 2 lv for renting: " + name);
				} else {
					System.out.println("Payed " + (rentMoney + (rentMoney * (returnedTime / 1000 * rentPercent))) + " lv for renting: " + name);
				}
				this.takenItemsFromLibrary.remove(i);
				return;
			}
			
		}
	}
	
}
