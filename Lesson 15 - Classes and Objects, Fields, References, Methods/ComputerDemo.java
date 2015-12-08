
public class ComputerDemo {

	public static void main(String[] args) {
		
		Computer pravetz = new Computer();
		pravetz.year = 1986;
		pravetz.price = 980.90;
		pravetz.hardDiskMemory = 16;
		pravetz.freeMemory = 13;
		pravetz.operationSystem = "MS DOS";
		pravetz.isNotebook = false;
		
		Computer asus = new Computer();
		asus.year = 2015;
		asus.price = 3200;
		asus.hardDiskMemory = 1_024_000;
		asus.freeMemory = 512_000;
		asus.operationSystem = "Windows 7";
		asus.isNotebook = true;
		
		pravetz.changeOperationSystem("Windows 3.11");
		asus.useMemory(100);
		
		System.out.println("Year: " + pravetz.year);
		System.out.println("Price: " + pravetz.price + " USD.");
		System.out.println("HDD memory: " + pravetz.hardDiskMemory + " mb");
		System.out.println("HDD free memory: " + pravetz.freeMemory);
		System.out.println("Operation System: " + pravetz.operationSystem);
		System.out.println((pravetz.isNotebook)? "The computer is a notebook." : "The computer is not a notebook.");

		System.out.println();
		
		System.out.println("Year: " + asus.year);
		System.out.println("Price: " + asus.price + " USD.");
		System.out.println("HDD memory: " + asus.hardDiskMemory + " mb");
		System.out.println("HDD free memory: " + asus.freeMemory);
		System.out.println("Operation System: " + asus.operationSystem);
		System.out.println((asus.isNotebook)? "The computer is a notebook." : "The computer is not a notebook.");
	}
}
