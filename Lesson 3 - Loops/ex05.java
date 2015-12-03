import java.util.Scanner;

//	Задача 5: Да се въведат от потребителя 2 числа. И да се изведат на екрана всички числа от по-малкото до по-голямото.

public class ex05 {
	
	public static void main(String[] args) {
		
		int firstNumber;
		int secondNumber;
		int biggerNumber;
		int smallerNumber;
		
		boolean isEqual;
		
		System.out.println("With this example we will print all of the numbers between 2 witch we will enter.");
		System.out.println("We can use only whole numbers - integers. The numbers can be between -1 000 000 and 1 000 000");
		System.out.println();
		
		Scanner inputNumnber = new Scanner(System.in);
		
		do {
			System.out.print("Enter the first number: ");
			firstNumber = inputNumnber.nextInt();
			System.out.print("Enter the second number: ");
			secondNumber = inputNumnber.nextInt();
		} while (!(firstNumber >= -1_000_000 && firstNumber <= 1_000_000) && (secondNumber >= -1_000_000 && secondNumber <= 1_000_000));
		
		isEqual = (firstNumber == secondNumber)? true : false;
		
		if (isEqual) {
			System.out.println("The entered numbers are equal: " + firstNumber + " = " + secondNumber);
		} else {
			if (firstNumber > secondNumber) {
				biggerNumber = firstNumber;
				smallerNumber = secondNumber;
			} else {
				biggerNumber = secondNumber;
				smallerNumber = firstNumber;
			}
			
			for (int i = smallerNumber; i <= biggerNumber; i++) {
				System.out.print(i + " ");
			}
		}
		
		
		inputNumnber.close();
	}
}
