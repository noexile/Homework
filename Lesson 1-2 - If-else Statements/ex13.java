import java.util.Scanner;

//	������ 13:
//	�� �� ������� ��������, ����� �� ������� ����� � �������/����� �� ���������� ����������� t � ������ ������.
//	�������������� ��������� ��:
//	��� -20 ������ �������;
//	����� 0 � -20 - �������;
//	����� 15 � 0 - ������;
//	����� 25 � 15 - �����;
//	��� 25 � ������.
//	������ �����: ���� ����� �� ��������� [-100..100].
//	������: 12
//	�����: ������


public class ex13 {

	public static void main(String[] args) {
		
		byte temp;
		
		boolean rangeChecker;

		System.out.println("With this example we will input a temperature and tell you if it is cold or hot.");
		System.out.println("Please note that you can enter double as a value.");
		System.out.println("The entered temperature range can be from -100 to 100 and is calculated in Celsius.");
		System.out.println();
		
		Scanner inputNumber = new Scanner (System.in);
		System.out.print("What is the temperature outside: ");
		temp = inputNumber.nextByte();
		
		rangeChecker = (temp > -101 && temp < 101)? true : false;
		
		if (rangeChecker) {
			System.out.println("The temperature is: ");
			if (temp > 25) {
				System.out.print("hot.");
			} else if (temp >= 15) {
				System.out.print("warm.");
			} else if (temp >= 0) {
				System.out.print("chilly.");
			} else if (temp >= -20) {
				System.out.print("cold.");
			} else {
				System.out.print("freezing. There is a white bear walking down the road ...");
			}
		} else {
			System.out.println("Please enter a temperature between -100 and 100!");
		}
		
		inputNumber.close();
	}
}
