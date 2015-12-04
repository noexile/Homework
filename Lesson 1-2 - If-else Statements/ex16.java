import java.util.Scanner;

//	������ 16:
//	�������� � ���������� ���������� ����� �� ���� abc.
//	������ �� �� ������� ����:
//	��� a = b = c - �����: ������� �� �����;
//	��� a>b>c - �����: ������� �� ��� �������� ���;
//	��� a<b<c ������� �� � �������� ���;
//	� �����: ������� �� ����������, �� ����������� ������.
//	�� �� ������� ��������, ����� ������� ��������� �� ���������� ��
//	������� �� ������� � �������.
//	������: 345
//	�����: �������� ���.

public class ex16 {

	public static void main(String[] args) {

		short number;
		byte firstDigit;
		byte secondDigit;
		byte thirdDigit;
		
		boolean rangeChecker;
		boolean aBiggerThanBBiggerThanC;
		boolean cBiggerThanBBiggerThanA;
		boolean aEqualsBAndC;
		
		System.out.println("With this excercise we will check if the input numbers are ascendent, descendent, equal or not arranged.");
		System.out.println("We can use whole - integer numbers in here. The range is between 100 and 999.");
		System.out.println();
		
		Scanner inputNumber = new Scanner(System.in);
		System.out.print("Enter a: ");
		number = inputNumber.nextShort();

		rangeChecker = ((number > 99 && number < 1000))? true : false;
		firstDigit = (byte) (number / 100);
		secondDigit = (byte) (number / 10);
		secondDigit %= 10;
		thirdDigit = (byte) (number % 10);
		
		aBiggerThanBBiggerThanC = ((firstDigit > secondDigit && secondDigit > thirdDigit))? true : false;
		cBiggerThanBBiggerThanA = ((thirdDigit > secondDigit && thirdDigit > firstDigit))? true : false;
		aEqualsBAndC = ((firstDigit == secondDigit && firstDigit == thirdDigit))? true : false;
		
		if (rangeChecker) {
			if (aBiggerThanBBiggerThanC) {
				System.out.println("The digits are in descending order.");
			} else if (cBiggerThanBBiggerThanA) {
				System.out.println("The digits are in ascending order.");;
			} else if (aEqualsBAndC) {
				System.out.println("The digits are equal.");
			} else {
				System.out.println("The digits are not in order.");
			}
		} else {
			System.out.println("The entered number is not between 100 and 999.");
		}
		inputNumber.close();
	}

}
