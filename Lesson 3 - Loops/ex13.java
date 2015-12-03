import java.util.Scanner;

//	������ 13: �� �� ������� ��������, ����� ������� ������
//	���������� ���������� �����, ����� ���� ���� �� ������� ������� ������ �����.
//	������ : sum, ������ 2>=sum<=27.
//	������: 26
//	�����: 899, 989, 998.

public class ex13 {

	public static void main(String[] args) {
		
		byte number;
		byte firstDigit;
		byte secondDigit;
		byte thirdDigit;
		
		byte start = 100;
		short end = 999;
		
		System.out.println("With this example we will enter a number between 2 and 27 and then print all hundred numbers witch digits have a sum of this number.");
		System.out.println("We can use only whole numbers - integers. The number must be between 2 and 27.");
		System.out.println();
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter the number: ");
			number = inputNumber.nextByte();
		} while (number < 2 || number > 27);

		for (int i = start; i <= end; i++) {
			firstDigit = (byte) (i / 100);
			secondDigit = (byte) (i / 10);
			secondDigit %= 10;
			thirdDigit = (byte) (i % 10);
			
			if ((firstDigit + secondDigit + thirdDigit) == number) {
				System.out.print(i + " ");		
			}
		}
		
		
		inputNumber.close();
	}

}
