import java.util.Scanner;

//	������ 8:
//	�� �� ������� ��������, ����� ���� �� ��������� 4-������o
//	���������� ����� �� ��������� [1000.. 9999]. �� ���� ����� ��
//	�������� 2 ���� 2-������� �����. ������� ����� �� ������� �� 1-��
//	� 4-�� ����� �� ���������� �����. ������� ����� �� ������� �� 2-�a -
//	3-�� ����� �� ���������� �����. ���� �������� �� �� ������ ���� 1-��
//	���� ����� e ��-����� <, ����� = ��� ��-������ �� 2-�� �����.
//	������: 3332 �����: ��-����� (32<33)
//	������: 1144 �����: ����� (14=14)
//	������: 9875 �����: ��-������ (95>87)

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
