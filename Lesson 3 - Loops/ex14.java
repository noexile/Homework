import java.util.Scanner;

//	������ 14: �� �� ������� ��������, ����� �� ��������
//	���������� ����� N �� ��������� [10..200] ������� � �������
//	��� ������ �����, ����� �� ������ �� 7 � �� ��-����� �� N.

public class ex14 {

	public static void main(String[] args) {

		int number;
		
		System.out.println("With this exercise we will enter a number in the range of 10 to 200 and then print all of the numbers module divided (%) by 7 == 0.");
		System.out.println("We can enter only a whole number - integer. It have to be in the range of 10 to 200.");
		System.out.println();		
		Scanner inputNumber = new Scanner(System.in);
		
		do {
			System.out.print("Enter a number: ");
			number = inputNumber.nextInt();
		} while (number < 10 || number > 200);
		
		for (int i = number; i > 9; i--) {
			if (i % 7 == 0) {
				System.out.println(i);
			}
		}
		
		inputNumber.close();
	}

}
