import java.util.Scanner;

//	������ 9: �� �� �������� 2 ����� �� ������������ � � �.
//	�� �� ������� ������ ����� �� � �� � �� ������ 2(��������� �
//	�������).��� ����� ����� � ������ �� 3, �� �� ������ ��������� ��
//	������� �� �������� �skip 3�.��� ������ �� ������ �������� ����� (���
//	������������) ����� ��-������ �� 200, �� �� �������� �����������.

public class ex09 {

	public static void main(String[] args) {

		int firstNumber;
		int secondNumber;
		int biggerNumber;
		int smallerNumber;
		int number;
		
		boolean isEqual;
		
		System.out.println("With this example we will enter 2 numbers and print all of the results that fit between them, multiplied by 2");
		System.out.println("If some of the results are module divided by 3, we will write - skip number.");
		System.out.println("We can enter only whole numbers - integers. They must be bigger than 1.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter the first number: ");
			firstNumber = inputNumber.nextInt();
			System.out.print("Enter the second number: ");
			secondNumber = inputNumber.nextInt();
		} while (firstNumber < 1 || secondNumber < 1);
		
		
		if (firstNumber > secondNumber) {
			biggerNumber = firstNumber;
			smallerNumber = secondNumber;
		} else {
			biggerNumber = secondNumber;
			smallerNumber = firstNumber;
		}
		
		isEqual = (firstNumber == secondNumber)? true : false;
		
		if (!isEqual) {
			for (int i = smallerNumber; i <= biggerNumber; i++) {
				number = i;
				if ((number * number) % 3 == 0 && (number*number <= biggerNumber)) {
					System.out.print("skip " + number);
				} else if (number*number <= biggerNumber) {
					System.out.print(number*number);
				}
				if ((number+1) * (number + 1) < biggerNumber) {
					System.out.print(", ");
				}
			}
		} else {
			System.out.println("The numbers are equal: " + firstNumber + " = " + secondNumber);
		}
		
		
		
		
		
		inputNumber.close();
	}

}
