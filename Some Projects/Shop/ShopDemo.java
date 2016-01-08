//  Да се реализира демо програма, която има следните възможности:

//	6. Добавяне на стоки към количката на купувачите;
//	7. Премахване на стоки от количката на купувачите;
//	8. Плащане от страна на купувачите на касата на магазина;
//	9. Визуализиране на наличностите в магазина преди и след като е пазарувал купувача.
//	10. Демото трябва да е така направено, че в никакъв случай да не се хвърля изключение, т.е.	всички изключения, които възникнат, да бъдат обработени.

package Shop;

public class ShopDemo {

	public static void main(String[] args) {
		
		Shop shop = new Shop("Koyto razbira - tuk se spira!", "neverland", 208.9, 10);
		
		PieceProduct bira = new PieceProduct("zagorka", 1.19, 20);
		PieceProduct kniga = new PieceProduct("voina i mir", 19.99, 4);
		PieceProduct stol = new PieceProduct("zagorka", 25, 2);
		QuantityProduct meso = new QuantityProduct("svinski vrat", 8.99, 25.30);
		QuantityProduct sirene = new QuantityProduct("elena", 5.99, 33.5);
		QuantityProduct riba = new QuantityProduct("skumriya", 7, 9.68);
		
		shop.addProduct(bira);
		shop.addProduct(kniga);
		shop.addProduct(stol);
		shop.addProduct(meso);
		shop.addProduct(sirene);
		shop.addProduct(riba);
		
		Buyer sasho = new Buyer(shop, 100, 10);
		sasho.addPieceProductToCart(bira, 3);
		sasho.addPieceProductToCart(stol, 3);
		sasho.addQuantityProductToCart(sirene, 3.2);
	}

}
