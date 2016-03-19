package ComputerDemo;

public class Computer {
	
	short year;
	double price;
	boolean isNotebook;
	double hardDiskMemory;
	double freeMemory;
	String operationSystem;
	
	Computer() {
		this.isNotebook = false;
		this.operationSystem = "Win XP";
	}
	
	Computer(int year, double price, double hardDiskMemory, double freeMemory) {
		this();
		this.year = (short) year;
		this.price = price;
		this.hardDiskMemory = hardDiskMemory;
		this.freeMemory = freeMemory;
	}
	
	void changeOperationSystem(String newOperationSystem) {
		operationSystem = newOperationSystem;
	}
	
	void useMemory (int memory) {
		if (memory <= freeMemory)
			freeMemory -= memory;
		else
			System.out.println("Not enough free memory");
	}
	
	int comparePrice(Computer c) {
		if (this.price == c.price)
			return 0;
		if (this.price > c.price)
			return -1;		
		return 1;
	}
}
