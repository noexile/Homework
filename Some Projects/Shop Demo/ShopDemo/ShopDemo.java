//  Да се реализира демо програма, която има следните възможности:

//	1. Създаване на магазин с предварително подадена вместимост от продукти;
//	2. Създаване на различни видове стоки на килограм –Месо, Сирене, Риба. Всяка стока се създава с наименование, цена и количество;
//	3. Създаване на различни видове стоки на бройка –Бира, Книга, Стол. Всяка стока се създава с наименование, цена и количество;
//	4. Добавяне на стоките в магазина;
//	5. Създаване на купувачи с предварително подадени магазин, брой продукти за	пазаруване и пари в наличност.
//	6. Добавяне на стоки към количката на купувачите;
//	7. Премахване на стоки от количката на купувачите;
//	8. Плащане от страна на купувачите на касата на магазина;
//	9. Визуализиране на наличностите в магазина преди и след като е пазарувал купувача.
//	10. Демото трябва да е така направено, че в никакъв случай да не се хвърля изключение, т.е.	всички изключения, които възникнат, да бъдат обработени.

package ShopDemo;

import Shop.Buyer;
import Shop.PieceProduct;
import Shop.Product;
import Shop.QuantityProduct;
import Shop.Shop;

public class ShopDemo {

	public static void main(String[] args) {
		
		Shop shop = new Shop("Koyto razbira - tuk se spira!", "neverland", 208.9, 10);
		
		Product bira = new PieceProduct("zagorka", 1.19, 20);
		Product kniga = new PieceProduct("voina i mir", 19.99, 4);
		Product stol = new PieceProduct("prosto stol", 25, 2);
		Product meso = new QuantityProduct("svinski vrat", 8.99, 25.30);
		Product sirene = new QuantityProduct("elena", 5.99, 33.5);
		Product riba = new QuantityProduct("skumriya", 7, 9.68);
		
		shop.addProduct(bira);
		shop.addProduct(kniga);
		shop.addProduct(stol);
		shop.addProduct(meso);
		shop.addProduct(sirene);
		shop.addProduct(riba);
		
		shop.viewItemsInShop();
		
		Buyer sasho = new Buyer(shop, 100);
		sasho.addPieceProductToCart(bira, 3);
		sasho.addPieceProductToCart(stol, 3);
		sasho.addQuantityProductToCart(sirene, 3.2);
		
		sasho.removePieceProductFromCart(bira, 1);
		sasho.removeQuantityProductFromCart(sirene, 1.5);
		
		shop.viewItemsInShop();
		
		sasho.payShop();
		
		
	}

}
