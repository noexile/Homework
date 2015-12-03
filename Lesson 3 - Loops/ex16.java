import java.util.Scanner;

//	Задача 16:
//	Да се състави програма, чрез която се въвеждат 2 естествени
//	числа N, M от интервала [10..5555].
//	Програмата, чрез цикъл for, да извежда всички числа от
//	интервала, които са кратни на 50 в низходящ ред.
//	Пример: 25,249
//	Изход: 200,150,100, 50.

public class ex16 {

	public static void main(String[] args) {

		short firstNumber;
		short secondNumber;
		short smallerNumber;
		short biggerNumber;
		
		boolean isEqual;
		
		System.out.println("With this example we will enter 2 numbers and print all the values between them that can be divided by 50.");
		System.out.println("We can enter only whole numbers - integers. They can be only between 10 and 5555.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter the first number: ");
			firstNumber = inputNumber.nextShort();
			System.out.print("Enter the second number: ");
			secondNumber = inputNumber.nextShort();
		} while (firstNumber < 10 || firstNumber > 5555 || secondNumber < 10 || secondNumber > 5555);
		
		isEqual = (firstNumber == secondNumber)? true : false;
		
		if (isEqual) {
			if (firstNumber % 50 == 0) {
				System.out.print(firstNumber);
			} else {
				System.out.print("The numbers are equal: " + firstNumber + " = " + secondNumber + " and are not divided by 50.");
			}
		} else {
			if (firstNumber > secondNumber) {
				biggerNumber = firstNumber;
				smallerNumber = secondNumber;
			} else {
				biggerNumber = secondNumber;
				smallerNumber = firstNumber;
			}
			
			for (int i = biggerNumber; i >= smallerNumber; i--) {
				if (i % 50 == 0) {
					System.out.print(i);
				}
				if (i - 50 >= smallerNumber && i % 50 == 0) {
					System.out.print(", ");
				}
			}
			
		}
		
		
		inputNumber.close();
	}

}
