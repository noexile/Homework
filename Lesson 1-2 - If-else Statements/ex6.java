import java.util.Scanner;

// Задача 6:
// Въведете 3 числа от клавиатурата а1, а2 и а3. Разменете стойностите
// им така, че а1 да има стойността на а2, а2 да има стойността на а3, а
// а3 да има старата стойност на а1.

public class ex6 {
	public static void main(String[] args) {
		double a;
		double b;
		double c;
		double buffer;

		System.out.println("With this exercise we will change the values of three input values.");
		System.out.println("We can use double values. You can enter only values between -1000 and 1000.");

		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter a number for A: ");
		a = inputNumber.nextShort();
		System.out.print("Enter a number for A: ");
		b = inputNumber.nextShort();
		System.out.print("Enter a number for A: ");
		c = inputNumber.nextShort();
		
		boolean valueRangeChecker = ((a >= -1000 && a <= 1000) && (b >= -1000 && b <= 1000)	&& (c >= -1000 && c <= 1000)) ? true : false;
		
		if (valueRangeChecker) {
			System.out.println("As entered the input values are a1 = " + a + ", a2 = " + b + ", a3 = " + c);
			buffer = a;
			a = b;
			b = c;
			c = buffer;

			System.out.println("After we changed the values they become a1 = " + a + ", a2 = " + b + ", a3 = " + c);
		} else {
			System.out.println("One or more of the entered numbers is not in the range of -1000 and 1000.");
		}

	}
}
