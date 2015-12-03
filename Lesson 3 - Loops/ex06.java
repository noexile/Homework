import java.util.Scanner;

//	Задача 6: Да се прочете число от екрана(конзолата) и да се изведе сбора на всички числа между 1 и въведеното число.

public class ex06 {

	public static void main(String[] args) {
		
		int number;
		int sum = 0;
				
		System.out.println("With this exercise we will input a number and then calculate the sum between it and 1.");
		System.out.println("The number have to be a whole number - integer and be positive. It have to be in the range between 1 and 10 000.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter the number: ");
			number = inputNumber.nextInt();
			
		} while (!(number > 0 && number < 10_001));
		
		for (int i = 1; i <= number; i++) {
			sum += i;
		}
		
		System.out.println("The sum between all numbers between 1 and " + number + " = " + sum);
		
		inputNumber.close();
	}
}
