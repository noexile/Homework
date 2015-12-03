import java.util.Scanner;

//	Задача 17:
//	Да се състави програма, която извежда квадрат, чийто страни са
//	оформени със знака *, а вътрешността е запълнена със въведен
//	знак.
//	Входни данни b - дължина на страната число от интервала
//	[3..20], c - желан знак.
//	Програмата да използва цикъл for.
//	Пример: 4 +
//	Изход:
//	****
//	*++*
//	*++*
//	****

public class ex17 {

	public static void main(String[] args) {
		
		byte number;
		char symbol;
		
		System.out.println("With this example we will print a square with specific dimensions and inside symbol entered from the keyboard.");
		System.out.println("The number can a whole number - integer and can be between 3 and 20. The symbol has no limitations.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter the square size: ");
			number = inputNumber.nextByte();
		} while (number < 3 || number > 20);
		
		System.out.print("Enter the inside symbol: ");
		symbol = inputNumber.next().charAt(0);
		
		for (int i = 1; i <= number; i++) {
			for (int j = 1; j <= number; j++) {
				if (i == 1 || i == number) {
					System.out.print("*");
				} else if (j == 1 || j == number) {
					System.out.print("*");
				} else {
					System.out.print(symbol);
				}
			}
			System.out.println();
		}
		
		inputNumber.close();
	}

}
