
//	Задача 1:
//	Създайте клас Computer, който представя компютър. Класът да има следните полета:
//	year – числова стойност, показваща година на производство на компютъра
//	price – числова стойност (не е задължително да е цяло число), показваща цената на компютъра
//	isNotebook – булева стойност – дали компютъра е преносим или не 
//	hardDiskMemory – числова стойност за размера на хардиска
//	freeMemory – числова стойност, показваща размера на свободната памет
//	operationSystem – текстово поле за операционната система на компютъра
//	
//	Класът да дефинира следните методи:
//	-метод changeOperationSystem(newOperationSystem), който сменя стойността на полето operationSystem със стойността, подадена като параметър.
//	-метод useMemory(memory), който намалява свободната памет (freeMemory) със стойността, подадена като аргумент. Ако стойността на аргумента е по-голяма от свободната памет, 
//	извежда съобщение "Not enough free memory!"
//	
//	Да се създадат 2 обекта от тип Computer.
//	Да се зададат стойности на всеки от компютрите за year, price, hardDiskMemory, freeMemory, operationSystem.
//	Нека единият компютър да е лаптоп. На единия от двата компютъра да се задели памет 100 (чрез метода useMemory), 
//	а на другия, да се смени операционната система (чрез метода changeOperationSystem), след което да се изведат на екрана всичките полета на двата компютъра.

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
