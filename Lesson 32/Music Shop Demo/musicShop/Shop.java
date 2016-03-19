package musicShop;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Shop {
	
	enum Arrangement {ASCENDING, DESCENDING}
	
	public static final int STARTING_MONEY_IN_CASH_REGISTER = 0;
	private HashMap<String, ArrayList<Instrument>> availableInstruments;
	private TreeMap<String, TreeMap<String, Integer>> catalogue;
	private HashMap<String, ArrayList<Instrument>> soldItems;
	private int moneyInCashRegister;
	private int moneyFromSoldItems;
	private InstrumentSupplier shano = new InstrumentSupplier();
	
	public Shop () {
		this.availableInstruments = new HashMap<String, ArrayList<Instrument>>();
		this.catalogue = new TreeMap<String, TreeMap<String, Integer>>();
		this.soldItems = new HashMap<String, ArrayList<Instrument>>();
		this.moneyInCashRegister = STARTING_MONEY_IN_CASH_REGISTER;
		this.setMoneyFromSoldItems(0);
		
		this.availableInstruments.put("Stringed", new ArrayList<Instrument>());
		this.soldItems.put("Stringed", new ArrayList<Instrument>());
		this.availableInstruments.get("Stringed").add(new Instrument("Violin", 100, 3));
		this.availableInstruments.get("Stringed").add(new Instrument("Viola", 80, 8));
		this.availableInstruments.get("Stringed").add(new Instrument("Contrabass", 135, 2));
		this.availableInstruments.get("Stringed").add(new Instrument("Harp", 50, 0));
		this.availableInstruments.get("Stringed").add(new Instrument("Guitar", 60, 4));
		this.availableInstruments.get("Stringed").add(new Instrument("Fiddle", 500, 1));
		this.soldItems.get("Stringed").add(new Instrument("Violin", 100, 0));
		this.soldItems.get("Stringed").add(new Instrument("Viola", 80, 0));
		this.soldItems.get("Stringed").add(new Instrument("Contrabass", 135, 0));
		this.soldItems.get("Stringed").add(new Instrument("Harp", 50, 0));
		this.soldItems.get("Stringed").add(new Instrument("Guitar", 60, 0));
		this.soldItems.get("Stringed").add(new Instrument("Fiddle", 500, 0));
		
		this.availableInstruments.put("Percussion", new ArrayList<Instrument>());
		this.soldItems.put("Percussion", new ArrayList<Instrument>());
		this.availableInstruments.get("Percussion").add(new Instrument("Drums", 200, 2));
		this.availableInstruments.get("Percussion").add(new Instrument("Tarambuka", 75, 5));
		this.availableInstruments.get("Percussion").add(new Instrument("Tupan", 30, 12));
		this.availableInstruments.get("Percussion").add(new Instrument("Tambourine", 200, 2));
		this.soldItems.get("Percussion").add(new Instrument("Drums", 200, 0));
		this.soldItems.get("Percussion").add(new Instrument("Tarambuka", 75, 0));
		this.soldItems.get("Percussion").add(new Instrument("Tupan", 30, 0));
		this.soldItems.get("Percussion").add(new Instrument("Tambourine", 200, 0));
		
		this.availableInstruments.put("Wind", new ArrayList<Instrument>());
		this.soldItems.put("Wind", new ArrayList<Instrument>());
		this.availableInstruments.get("Wind").add(new Instrument("Trumpet", 310, 4));
		this.availableInstruments.get("Wind").add(new Instrument("Trombone", 90, 11));
		this.availableInstruments.get("Wind").add(new Instrument("Tuba", 85, 10));
		this.availableInstruments.get("Wind").add(new Instrument("Flute", 160, 3));
		this.availableInstruments.get("Wind").add(new Instrument("Clarinet", 115, 13));
		this.soldItems.get("Wind").add(new Instrument("Trumpet", 310, 0));
		this.soldItems.get("Wind").add(new Instrument("Trombone", 90, 0));
		this.soldItems.get("Wind").add(new Instrument("Tuba", 85, 0));
		this.soldItems.get("Wind").add(new Instrument("Flute", 160, 0));
		this.soldItems.get("Wind").add(new Instrument("Clarinet", 115, 0));
		
		this.availableInstruments.put("Keyboards", new ArrayList<Instrument>());
		this.soldItems.put("Keyboards", new ArrayList<Instrument>());
		this.availableInstruments.get("Keyboards").add(new Instrument("Organ", 800, 0));
		this.availableInstruments.get("Keyboards").add(new Instrument("Piano", 350, 2));
		this.availableInstruments.get("Keyboards").add(new Instrument("Accordion", 90, 8));
		this.soldItems.get("Keyboards").add(new Instrument("Organ", 800, 0));
		this.soldItems.get("Keyboards").add(new Instrument("Piano", 350, 0));
		this.soldItems.get("Keyboards").add(new Instrument("Accordion", 90, 0));
		
		this.availableInstruments.put("Electronic", new ArrayList<Instrument>());
		this.soldItems.put("Electronic", new ArrayList<Instrument>());
		this.availableInstruments.get("Electronic").add(new Instrument("Bass", 138, 12));
		this.availableInstruments.get("Electronic").add(new Instrument("Synthesizer", 230, 6));
		this.availableInstruments.get("Electronic").add(new Instrument("Electric Violin", 960, 1));
		this.soldItems.get("Electronic").add(new Instrument("Bass", 138, 0));
		this.soldItems.get("Electronic").add(new Instrument("Synthesizer", 230, 0));
		this.soldItems.get("Electronic").add(new Instrument("Electric Violin", 960, 0));
		
		createCatalogue(); // also creates list of products for the sold items to be added later
	}

	
	// methods
	public void leastSoldInstrument() {
		boolean zeroItemsSold = false;
		int leastSoldQuantity = 0;
		ArrayList<Instrument> instruments = new ArrayList<Instrument>();
		
		for(Map.Entry<String, ArrayList<Instrument>> outerMap : this.soldItems.entrySet()) {
			for (int i = 0; i < outerMap.getValue().size(); i++) {
				if (outerMap.getValue().get(i).getAvailableQuantity() == 0) {
					instruments.add(outerMap.getValue().get(i));
				} else {
					zeroItemsSold = true;
				}
			}
		}
		
		if (zeroItemsSold) { // prints the items as there are some with sold value 0 /the least number of sold item/
			System.out.println("Least sold items:");
			for (int i = 0; i < instruments.size(); i++) {
				System.out.println("- " + instruments.get(i).getName() + " : " + instruments.get(i).getAvailableQuantity() + " items");
			}
			return;
		}
		
		instruments.clear(); // clears the values of the previous checking
		boolean firstItemChecker = true;
		
		for(Map.Entry<String, ArrayList<Instrument>> outerMapSecond : this.soldItems.entrySet()) {
			for (int i = 0; i < outerMapSecond.getValue().size(); i++) {
				if (firstItemChecker) {
					instruments.add(outerMapSecond.getValue().get(i));
					firstItemChecker = false;
					leastSoldQuantity = outerMapSecond.getValue().get(i).getAvailableQuantity();
					continue;
				} 
				
				if (outerMapSecond.getValue().get(i).getAvailableQuantity() == leastSoldQuantity) {
					instruments.add(outerMapSecond.getValue().get(i));
					continue;
				} else if (outerMapSecond.getValue().get(i).getAvailableQuantity() < leastSoldQuantity) {
					instruments.clear();
					instruments.add(outerMapSecond.getValue().get(i));
					leastSoldQuantity = outerMapSecond.getValue().get(i).getAvailableQuantity();
					continue;
				}				
			}
		}
	}
	
	public void mostSoldTypeOfInstruments() {
		String mostSoldType = "";
		int mostSoldItemsFromType = 0;
		boolean zeroSoldItems = true;		
		
		for(Map.Entry<String, ArrayList<Instrument>> outerMap : soldItems.entrySet()) {
			int tempCounter = 0;
			
			for (int i = 0; i < outerMap.getValue().size(); i++) {
				if (outerMap.getValue().get(i) == null) {
					continue;
				}
				if (outerMap.getValue().get(i).getAvailableQuantity() > 0) {
					tempCounter += outerMap.getValue().get(i).getAvailableQuantity();
				}
			}
			
			if (mostSoldItemsFromType < tempCounter) {
				mostSoldItemsFromType = tempCounter;
				mostSoldType = outerMap.getKey();
				zeroSoldItems = false;
			}
			
		}
		
		if (zeroSoldItems) {
			System.out.println("No instruments are sold yet!");
			return;
		}
		System.out.println("Most sold Instrument type: " + mostSoldType + " - " + mostSoldItemsFromType + " pieces.");
	}
	
	public void mostProfitableInstrument() {
		String mostProfitableItem = null;
		int mostSoldItem = 0;
		int totalPriceForSoldItem = 0;
		int tempPrice = 0;
		boolean zeroSoldItems = true;	
		
		for(Map.Entry<String, ArrayList<Instrument>> outerMap : soldItems.entrySet()) {
			
			for (int i = 0; i < outerMap.getValue().size(); i++) {
				tempPrice = 0;
				if (outerMap.getValue().get(i) == null) {
					continue;
				}
				
				tempPrice += (outerMap.getValue().get(i).getAvailableQuantity() * outerMap.getValue().get(i).getPrice());
				
				if (tempPrice > totalPriceForSoldItem) {
					totalPriceForSoldItem = tempPrice;
					mostProfitableItem = outerMap.getValue().get(i).getName();
					mostSoldItem = outerMap.getValue().get(i).getAvailableQuantity();
					zeroSoldItems = false;
				}
			}
		}
		
		if (zeroSoldItems) {
			System.out.println("No instruments are sold yet!");
			return;
		}
		System.out.println("Most profitable Instrument: " + mostProfitableItem + " - " + mostSoldItem + " pieces sold for " + totalPriceForSoldItem + " lv.");
	}
	
	public void mostSoldItem() {
		boolean firstEntry = true;
		Instrument mostSoldInstrument = null;
		
		for(Map.Entry<String, ArrayList<Instrument>> outerMap : this.soldItems.entrySet()) {
			for (int i = 0; i < outerMap.getValue().size(); i++) {
				if (outerMap.getValue().get(i) == null) {
					continue;
				} 
				
				if (outerMap.getValue().get(i).getAvailableQuantity() > 0) {
					if (firstEntry) { // adds the 1st item to be the most sold product
						mostSoldInstrument = outerMap.getValue().get(i);
						firstEntry = false;
						continue;
					}
					
					if (outerMap.getValue().get(i).getAvailableQuantity() > mostSoldInstrument.getAvailableQuantity()) {
						mostSoldInstrument = outerMap.getValue().get(i);
					}
				}
			}
		}
		
		if (firstEntry) {
			System.out.println("No sold items yet!");
			return;
		}
		
		System.out.println("Most sold item: " + mostSoldInstrument.getName() + " - " + mostSoldInstrument.getAvailableQuantity() + " items sold.");
	}
		
	private void addSoldItem(String name, int quantity) {
		for (Map.Entry<String, ArrayList<Instrument>> soldItemsList : this.soldItems.entrySet()) {
			for (int i = 0; i < soldItemsList.getValue().size(); i++) {
				if (soldItemsList.getValue().get(i).getName().equalsIgnoreCase(name)) {
					soldItemsList.getValue().get(i).setAvailableQuantity(soldItemsList.getValue().get(i).getAvailableQuantity() + quantity);
					return;
				}
			}
		}
	}

	public void printSoldItems() {
		ArrayList<Instrument> tempListForSoldItems = new ArrayList<Instrument>();
		
		for(Map.Entry<String, ArrayList<Instrument>> outerMap : this.soldItems.entrySet()) {
			for (int i = 0; i < outerMap.getValue().size(); i++) {
				if (outerMap.getValue().get(i).getAvailableQuantity() > 0) {
					tempListForSoldItems.add(outerMap.getValue().get(i));
				}
			}
		}
		Collections.sort(tempListForSoldItems);

		System.out.println("Sold Items: ");
		for (int i = 0; i < tempListForSoldItems.size(); i++) {
			System.out.println(tempListForSoldItems.get(i).getName() + " - " + tempListForSoldItems.get(i).getAvailableQuantity() + " items sold.");
		}
	}
	
	private void createCatalogue() {
		for(Entry<String, ArrayList<Instrument>> entry : this.availableInstruments.entrySet()) {
			ArrayList<Instrument> tempInstruments = entry.getValue();
			String instrumentType = entry.getKey();
			for (int i = 0; i < tempInstruments.size(); i++) {
				if (tempInstruments.get(i) == null) {
					continue;
				} else if (!this.catalogue.containsKey(instrumentType)) { // if does not have instrument type - add it to the catalogue
					this.catalogue.put(instrumentType, new TreeMap<String, Integer>());
				}
				
				if (!this.catalogue.get(instrumentType).containsKey(tempInstruments.get(i).getName())) { // if does not contain instrument
					this.catalogue.get(instrumentType).put(tempInstruments.get(i).getName(), tempInstruments.get(i).getPrice());
				}
			}
		}
	}
	
	// ADDING INSTRUMENTS
//	public void addInstrument(String name, int quantity) {
//		for(Map.Entry<String, ArrayList<Instrument>> entry : this.availableInstruments.entrySet()) {
//			ArrayList<Instrument> tempInstruments = entry.getValue();
//			for (int i = 0; i < tempInstruments.size(); i++) {
//				if (tempInstruments.get(i) == null) {
//					continue;
//				} else if(tempInstruments.get(i).getName().equalsIgnoreCase(name)) {
//					tempInstruments.get(i).setAvailableQuantity(tempInstruments.get(i).getAvailableQuantity() + quantity);
//				}
//			}
//		}
//	}
	
	public void sellInstrument(String name, int quantity) {
		if(checkIfInstrumentIsAvailable(name, quantity)) { // checks if the item is in the shop
			sell(name, quantity);
			addSoldItem(name, quantity); // adding item in the sold list
		} else { // if item is not available
			for (Map.Entry<String, TreeMap<String, Integer>> shanoItems : this.shano.itemsForSale.entrySet()) {
				for (Map.Entry<String, Integer> shanoItemList : shanoItems.getValue().entrySet()) {
					if (shanoItemList.getKey().equalsIgnoreCase(name)) {
						int waitDays = (shanoItemList.getValue() / 100);
						if (waitDays < 1) {
							waitDays = 1;
						}
						System.out.println("We are sorry but we does not have the Instrument in Stock. If ordered today it will arrive in: " + waitDays + " days.");
						return;
					}
				}
			}
			System.out.println("We are sorry but we will not supply more of this item: " + name);
		}
	}
	
	private void sell(String name, int quantity) {
		for(Map.Entry<String, ArrayList<Instrument>> entry : this.availableInstruments.entrySet()) {
			ArrayList<Instrument> tempInstruments = entry.getValue();
			for (int i = 0; i < tempInstruments.size(); i++) {
				if (tempInstruments.get(i).getName().equalsIgnoreCase(name)) {
					if (tempInstruments.get(i).getAvailableQuantity() < quantity) {
						System.out.println("Unfortunately the instrument: " + tempInstruments.get(i).getName() + " is out of stock.");
						return;
					}
					
					System.out.print("Item sold: " + name + ". Quantity: " + quantity + " for " + tempInstruments.get(i).getPrice() + " lv");	
					if (quantity > 1) {
						System.out.println(" each");
					} else {
						System.out.println();
					}
					this.moneyInCashRegister += (tempInstruments.get(i).getPrice() * quantity);
					this.moneyFromSoldItems += (tempInstruments.get(i).getPrice() * quantity);
					tempInstruments.get(i).setAvailableQuantity(tempInstruments.get(i).getAvailableQuantity() - quantity);
					return;
				}
			}
		}
	}

	private boolean checkIfInstrumentIsAvailable(String name, int quantity) {
		for(Map.Entry<String, ArrayList<Instrument>> entry : this.availableInstruments.entrySet()) {
			ArrayList<Instrument> tempInstruments = entry.getValue();
			for (int i = 0; i < tempInstruments.size(); i++) {
				if (tempInstruments.get(i) == null) {
					continue;
				} else if(tempInstruments.get(i).getName().equalsIgnoreCase(name)) {
					if (tempInstruments.get(i).getAvailableQuantity() < quantity) {
						return false;
					}
					return true;
				}
			}
		}
		return false;
	}

	public void printCatalogue() {
		System.out.println("Catalogue:");
		int numeration = 1;
		for (Map.Entry<String, TreeMap<String, Integer>> outerMap : catalogue.entrySet()) {
			System.out.println((numeration++) + " " + outerMap.getKey() + ": ");
			TreeMap<String, Integer> innerMap = outerMap.getValue();
			for (Map.Entry<String, Integer> inner : innerMap.entrySet()) {
				System.out.println("- " + inner.getKey() + ", " + inner.getValue() + " lv.");
			}
		}
	}
	
	public void printCatalogueSortedByType() {
		System.out.println("Catalogue:");
		int numeration = 1;
		for (Map.Entry<String, TreeMap<String, Integer>> outerMap : catalogue.entrySet()) {
			System.out.println((numeration++) + " " + outerMap.getKey() + ": ");
			TreeMap<String, Integer> innerMap = outerMap.getValue();
			for (Map.Entry<String, Integer> inner : innerMap.entrySet()) {
				System.out.println("- " + inner.getKey() + ", " + inner.getValue() + " lv.");
			}
		}
	}
	
	public void printCatalogueSortedByName() {
		ArrayList<String> list = new ArrayList<String>();
		
		for(Map.Entry<String, TreeMap<String, Integer>> outerMap : catalogue.entrySet()) {
			TreeMap<String, Integer> innerMap = outerMap.getValue();
			for (String key: innerMap.keySet()) {
				list.add(key);
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
	
	public void printCatalogueSortedByPrice(String arrangeBy) {
		if (arrangeBy.equalsIgnoreCase(Arrangement.ASCENDING.toString().toLowerCase()) || arrangeBy.equalsIgnoreCase(Arrangement.DESCENDING.toString().toLowerCase())) {
			Map<String, Integer> unsortMap = new TreeMap<String, Integer>();
			for(Map.Entry<String, TreeMap<String, Integer>> outerMap : catalogue.entrySet()) {
				unsortMap.putAll(outerMap.getValue());
			}
			
			if (arrangeBy.equalsIgnoreCase(Arrangement.ASCENDING.toString())) {
				Map<String, Integer> sortedMapAsc = sortByComparator(unsortMap, true);
				printMap(sortedMapAsc);
			} else if (arrangeBy.equalsIgnoreCase(Arrangement.DESCENDING.toString())) {
				Map<String, Integer> sortedMapDesc = sortByComparator(unsortMap, false);
				printMap(sortedMapDesc);
			}
		} else {
			System.out.println("You can arrange the price only in ascending or descending order!");
		}
	}

	public void printItemsOnStock() {
		System.out.println("Available Items in the shop:");
		for(Map.Entry<String, ArrayList<Instrument>> outerMap : this.availableInstruments.entrySet()) {
			ArrayList<Instrument> inner = outerMap.getValue();
			for (int i = 0; i < inner.size(); i++) {
				if (inner.get(i).getAvailableQuantity() == 0) {
					continue;
				}
				
				System.out.println("- " + inner.get(i).getName() + ", " + inner.get(i).getAvailableQuantity() + " items");
			}
		}
	}
	
	public void printCurrentShopMoney() {
		System.out.println(this.moneyInCashRegister + " lv."); // prints available money in cash register
	}

	private Map<String, Integer> sortByComparator(Map<String, Integer> unsortMap, boolean order) {
	    List<Entry<String, Integer>> list = new LinkedList<Entry<String, Integer>>(unsortMap.entrySet());
	
	    // Sorting the list based on values
	    Collections.sort(list, new Comparator<Entry<String, Integer>>() {
	        public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
	            if (order) {
	                return o1.getValue().compareTo(o2.getValue());
	            } else {
	                return o2.getValue().compareTo(o1.getValue());
	            }
	        }
	    });
	
	    // Maintaining insertion order with the help of LinkedList
	    Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
	    for (Entry<String, Integer> entry : list) {
	        sortedMap.put(entry.getKey(), entry.getValue());
	    }
	    return sortedMap;
	}
	
	 private void printMap(Map<String, Integer> map) {
		System.out.println("Catalogue:");
        for (Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("- " + entry.getKey() + ", " + entry.getValue() + " lv.");
        }
	 }
	 
	// getters and setters
	private int getMoneyInCashRegister() {
		return moneyInCashRegister;
	}

	private HashMap<String,ArrayList<Instrument>> getAvailableInstruments() {
		return availableInstruments;
	}

	private int getMoneyFromSoldItems() {
		return moneyFromSoldItems;
	}

	private void setMoneyFromSoldItems(int moneyFromSoldItems) {
		this.moneyFromSoldItems = moneyFromSoldItems;
	}
	
	// Instrument supplier
	
//	Да се създаде обект „Доставчик на инструменти“, който предлага гама от
//	инструменти, като за всеки инструмент има информация за времето на доставката до магазина.
	
	// TODO
	private class InstrumentSupplier {
		
		private String name;
		private TreeMap<String, TreeMap<String, Integer>> itemsForSale;
		
		InstrumentSupplier() {
			this.name ="Bat Sali";	
			this.itemsForSale = new TreeMap<String, TreeMap<String, Integer>>();
			
			this.itemsForSale.put("Stringed", new TreeMap<String, Integer>());
			this.itemsForSale.get("Stringed").put("Violin", 80);
			this.itemsForSale.get("Stringed").put("Guitar", 50);
			this.itemsForSale.get("Stringed").put("Contrabass", 90);
			
			this.itemsForSale.put("Percussion", new TreeMap<String, Integer>());
			this.itemsForSale.get("Percussion").put("Drums", 140);
			this.itemsForSale.get("Percussion").put("Tarambuka", 55);
			this.itemsForSale.get("Percussion").put("Tupan", 15);
			
			this.itemsForSale.put("Wind", new TreeMap<String, Integer>());
			this.itemsForSale.get("Wind").put("Trumpet", 220);
			this.itemsForSale.get("Wind").put("Trombone", 60);
			this.itemsForSale.get("Wind").put("Flute", 220);
			
			this.itemsForSale.put("Keyboards", new TreeMap<String, Integer>());
			this.itemsForSale.get("Keyboards").put("Organ", 550);
			this.itemsForSale.get("Keyboards").put("Piano", 280);
			this.itemsForSale.get("Keyboards").put("Accordion", 65);
		}
		
		// getters and setters
		String getName() {
			return name;
		}
		
		TreeMap<String, TreeMap<String, Integer>> getItemsForSale() {
			return itemsForSale;
		}
		
	}
	
	private class SortByType implements Comparator<LinkedHashMap<String, LinkedHashMap<String, Integer>>>{
		
		private LinkedHashMap<String, LinkedHashMap<String, Integer>> map;
		
		private SortByType(LinkedHashMap<String, LinkedHashMap<String, Integer>> map) {
	        this.map = map;
	    }


		@Override
		public int compare(LinkedHashMap<String, LinkedHashMap<String, Integer>> o1, LinkedHashMap<String, LinkedHashMap<String, Integer>> o2) {
			Map.Entry<String, LinkedHashMap<String, Integer>> e1 = (Entry<String, LinkedHashMap<String, Integer>>) o1.entrySet();
			Map.Entry<String, LinkedHashMap<String, Integer>> e2 = (Entry<String, LinkedHashMap<String, Integer>>) o2.entrySet();
			
			return e1.getKey().compareTo(e2.getKey());
		}	
	}
	
}
