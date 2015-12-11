package ComputerDemo;

public class ComputerDemo {

	public static void main(String[] args) {
		
		Computer pravetz = new Computer();
		pravetz.price = 100.98;
		
		Computer asus = new Computer(2015, 3198.99, 1_024, 512);
		
		int moreExpensive = pravetz.comparePrice(asus);
		
		if (moreExpensive == 0)
			System.out.println("The prices of both computers are equal.");
		else if (moreExpensive == -1)
			System.out.println("The price of Computer 1 is bigger than the price of Computer 2");
		else
			System.out.println("The price of Computer 2 is bigger than the price of Computer 1");
		
	}
}
