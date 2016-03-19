import java.util.Scanner;

// Задача 3:
// Въведете 2 различни числа от конзолата и разменете стойността им.
// Разпечатайте новите стойности.

public class ex3 {

	public static void main(String[] args) {

		short firstNumber;
		short secondNumber;
		short buffer;
		
		System.out.println("With this exercise we will swap the values of 2 variables.");
		System.out.println("The numbers must be integers and be between -1000 and 1000.");
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter a value for A: ");
		firstNumber = inputNumber.nextShort();
		System.out.print("Enter a value for B: ");
		secondNumber = inputNumber.nextShort();
		
		if ((firstNumber >= -1000 && firstNumber <= 1000) && (secondNumber >= -1000 && secondNumber <= 1000)) {
			System.out.println("A = " + firstNumber + " and " + "B = " + secondNumber);
			buffer = firstNumber;
			firstNumber = secondNumber;
			secondNumber = buffer;
			System.out.println("After swapping their values: ");
			System.out.println("A = " + firstNumber + " and " + "B = " + secondNumber);
		} else {
			System.out.println("One or two of the numbers you entered are not between -1000 and 1000");
		}
		

		inputNumber.close();
	}

}
