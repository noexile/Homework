package musicShopDemo;

import java.util.ArrayList;
import java.util.Map;

import musicShop.Instrument;
import musicShop.Shop;

public class Demo {

	public static void main(String[] args) {	
		
		Shop zaiko = new Shop();
//		zaiko.addInstrument("trumpet", 1111);
		zaiko.sellInstrument("flute", 3);
		zaiko.sellInstrument("trumpet", 333);
		zaiko.sellInstrument("Tambourine", 1);
		zaiko.sellInstrument("trumpet", 333);

				
//		for(Map.Entry<String, ArrayList<Instrument>> entry : zaiko.getAvailableInstruments().entrySet()) {
//			ArrayList<Instrument> temp = entry.getValue();
//			for (int i = 0; i < temp.size(); i++) {
//				System.out.println(temp.get(i).getName() + " : " + temp.get(i).getAvailableQuantity());
//			}
//		}
//		
//		zaiko.printCurrentShopMoney();
//		
//		zaiko.printCatalogueSortedByName();
//		
//		zaiko.printCatalogueSortedByPrice("DESCENDING");
//		zaiko.printCatalogueSortedByPrice("ascending");

//		zaiko.printItemsOnStock();		
//		zaiko.printSoldItems();
		
//		zaiko.printCurrentShopMoney();
//		zaiko.mostSoldItem();
		
//		zaiko.leastSoldInstrument();
		
//		zaiko.mostSoldTypeOfInstruments();
		
		zaiko.mostProfitableInstrument();
	}
}
