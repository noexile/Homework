import java.util.Scanner;

//	Задача 14:
//	Да се състави метод, който приема за стойност число N и връща стойността на N! (N факториел).

public class ex14 {

	public static void main(String[] args) {
		
		System.out.println("This exercise will use a method in order to print the factorial value of N.");
		System.out.println("The number must be bigger than 0.");
		System.out.println();

		long number = inputNumber();		
		
		printFactorial(number);
		
	}
	
	static long inputNumber() {
		
		long number = 0;
		String arraySize;
		boolean isDigit;
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter N: ");
			arraySize = input.nextLine();
			isDigit = false;
			
			for (int i = 0; i < arraySize.length(); i++) {
				if (!Character.isDigit(arraySize.charAt(i))) {
					isDigit = true;
					break;
				} 
				if (i == arraySize.length() - 1) {
					number = Integer.parseInt(arraySize);
				}
			}
			
		} while (number < 1 || isDigit);
		
		input.close();
		
		return number;
	}

	static void printFactorial(long number) {
		int n = 1;
		
		for (int i = 1; i <= number; i++) {
			n *= i;
		}
		
		System.out.println("Factoriel value for " + number + " is: " + n);
	}

}
