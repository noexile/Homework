import java.util.Scanner;

//	Задача 8:
//	Да се състави програма, която чете от конзолата 4-цифренo
//	естествено число от интервала [1000.. 9999]. От това число се
//	формират 2 нови 2-цифрени числа. Първото число се формира от 1-та
//	и 4-та цифра на въведеното число. Второто число се формира от 2-рa -
//	3-та цифра на въведеното число. Като резултат да се изведе дали 1-то
//	ново число e по-малко <, равно = или по-голямо от 2-то число.
//	Пример: 3332 Изход: по-малко (32<33)
//	Пример: 1144 Изход: равни (14=14)
//	Пример: 9875 Изход: по-голямо (95>87)

public class ex8 {
	public static void main(String[] args) {

		short number;

		short firstDigit;
		short secondDigit;
		short thirdDigit;
		short fourthDigit;

		short firstNumber;
		short secondNumber;

		boolean checker;
		boolean biggerNumber;
		boolean isEqual;

		System.out.println("With this example we will create 2 numbers from imput one from us and then we will compare witch is bigger.");
		System.out.println("It must be with 4 digits so it should be between 1000 and 9999.");
		System.out.println("After that we will take the first and last digit and also the second and third digit to make 2 new numbers.");
		System.out.println();

		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter a number between 1000 and 9999: ");
		number = inputNumber.nextShort();

		checker = (number > 999 && number < 10000) ? true : false;

		if (checker) {

			// we cast the equations because we want to reduce the memory spend
			// on initialising the variables. Otherwise we have to make the
			// variables bigger such as integers.
			firstDigit = (short) (number / 1000);
			secondDigit = (short) (number / 100);
			secondDigit %= 10; // secondDigit = secondDigit % 10;
			thirdDigit = (short) (number / 10);
			thirdDigit %= 10; // thirdDigit = thirdDigit % 10;

			fourthDigit = (short) (number % 10);

			firstNumber = (short) ((firstDigit * 10) + fourthDigit);
			secondNumber = (short) ((secondDigit * 10) + thirdDigit);

			biggerNumber = (firstNumber > secondNumber) ? true : false;
			isEqual = (firstNumber == secondNumber) ? true : false;

			if (isEqual) {
				System.out.println(secondNumber + " = " + firstNumber);
			} else {
				if (biggerNumber) {
					System.out.println(firstNumber + " > " + secondNumber);
				} else {
					System.out.println(firstNumber + " < " + secondNumber);
				}
			}

		}

		inputNumber.close();
	}
}
