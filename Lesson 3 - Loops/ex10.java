import java.util.Scanner;

//	������ 10: �������� ����� �� ������������ � ���������� ���� �
//	������. ������ ����� � ���� ����� �� ���� ���� �� 1 � �� ���� ��.

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
