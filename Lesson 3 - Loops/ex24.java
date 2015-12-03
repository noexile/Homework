import java.util.Scanner;

//	Задача 24:
//	Едно число X е палиндром, aко се чете еднакво отпред назад и отзад напред.
//	Да се състави програма, която проверява дали въведено число е палиндром.
//	Входни данни: N - естествено число от интервала [10 .. 30000].
//	Пример: 17571
//	Изход: числото е палиндром
//	Използвайте цикъл do-while.

public class ex24 {

	public static void main(String[] args) {
		
		short number;
		short checker;
		short reverceNumber = 0;
		short remainder;
		
		System.out.println("With this example we will enter a number and check if it is a polindrome -> this means that the numbr read from backwards = the entered number.");
		System.out.println("We can enter only whole numbers - integers. The number can be from 10 to 30 000.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter Number: ");
			number = inputNumber.nextShort();
		} while (number < 10 || number > 30000);
		
		checker = number; 
		
		do {
			remainder = (short) (number % 10);
			reverceNumber *= 10;
			reverceNumber += remainder;
			number = (short) (number / 10);
		} while (number > 0);
		
		if (reverceNumber == checker) {
			System.out.println(checker + " is a palindrome.");
		} else {
			System.out.println(checker + " is not a palindrome.");
		}
		
		inputNumber.close();
	}

}
