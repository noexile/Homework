import java.util.Scanner;

//	Задача 10: Въведете число от клавиатурата и определете дали е
//	просто. Просто число е това което се дели САМО на 1 и на себе си.

public class ex10 {

	public static void main(String[] args) {

		int number;
		boolean checker = true;
		
		Scanner inputNumber = new Scanner(System.in);

		System.out.print("Enter the number for checking: ");
		number = inputNumber.nextShort();

		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				checker = false;
				break;
			}
		}
		
		if (checker) {
			System.out.println("The entered number: " + number + " is a prime number.");
		} else {
			System.out.println("The entered number: " + number + " is NOT a prime number.");
		}
		
		inputNumber.close();
	}

}
