import java.util.Scanner;

//	������ 9:
//	�� �� ������� ��������, ����� ���� �� ��������� 2 ���������� ���������� ����� a,b.
//	���������� �� ������ � ��������� ���� ���������� ����� �� �������������� �� ����� ����� � �����, ����� � ������ �����.
//	������ �����: a,b - ���������� ����� �� ��������� [10..99].
//	������: 15, 25
//	�����: 375, 5 �������

public class ex9 {

	public static void main(String[] args) {
		byte firstNumber;
		byte secondNumber;
		short lastNumber;
		short result;
		
		boolean rangeChecker;
		boolean isOdd;
		
		System.out.println("With this example we will multiply two input numbers and will check if the last digit is odd or even.");
		System.out.println("For this exercise we will use only integers witch must be between 10 and 99.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Please enter the first number: ");
		firstNumber = inputNumber.nextByte();
		System.out.print("Please enter the second number: ");
		secondNumber = inputNumber.nextByte();

		rangeChecker = ((firstNumber > 9 && firstNumber < 100) && (secondNumber > 9 && secondNumber < 100))? true : false;
		
		if (rangeChecker) {
			result = (short) (firstNumber * secondNumber);
			lastNumber = (short) (result % 10);
			isOdd = ((lastNumber % 2) == 1)? true : false;
			if (lastNumber != 0) {
				if (isOdd) {
					System.out.println(result + ", " + lastNumber + " is Odd.");
				} else {
					System.out.println(result + ", " + lastNumber + " is Even.");
				}
			} else {
				System.out.println(result + ", " + lastNumber + " is Zero.");
			}
			
		} else {
			System.out.println("One or both of your numbers are not in the range of 10 - 99.");
		}
		
		inputNumber.close();
	}

}
