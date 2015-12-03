import java.util.Scanner;

//	Задача 15: Да се състави програма, която да изчисли сумата на
//	всички числа от 1 до въведено число N.
//	Пример: 5
//	Изход: 15
//	Използвайте цикъл do-while.

public class ex15 {

	public static void main(String[] args) {

		int number;
		int n = 1;
		int sum = 0;
		boolean isPositive;
		
		System.out.println("With this example we will enter a number from the keyboard and then we will print the sum of all numbers between it and 1.");
		System.out.println("The number can be a whole number - integer.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter the number: ");
		number = inputNumber.nextInt();
		
		if (number >= 1) {
			isPositive = true;
		} else {
			isPositive = false;
		}
		
		if (isPositive) {
			do {
				sum += n;
				n++;
			} while (n <= number);
		} else {
			do {
				sum += n;
				n--;
			} while (n >= number);
		}
		System.out.println(sum);
		
		inputNumber.close();
	}

}
