
public class Computer {
	
	short year;
	double price;
	boolean isNotebook;
	int hardDiskMemory;
	int freeMemory;
	String operationSystem;
	
	void changeOperationSystem(String newOperationSystem) {
		operationSystem = newOperationSystem;
	}
	
	void useMemory (int memory) {
		if (memory <= freeMemory) {
			freeMemory -= memory;
		} else {
			System.out.println("Not enough free memory");
		}
	}
}
