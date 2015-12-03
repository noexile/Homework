
//	������ 16:
//	�� �� ������� ��������, ���� ����� ������������� �������� 10 ������ ����� �� ��������� �� ���������� �� ������� �����:
//	1. ������� �������������� �����.
//	2. ������ �������� ��� �������� ��-����� �� -0.231 �� ������� ��� ������ �� �������� �� �������� �� ����� + ������� 41.25, � ������ �������� �������� 
//	�� ������� � �������������� ����� ����� �������� �������� ������� �����. ��������� ����� �� ������� ������� � 1.
//	3. �� �� ������� ���������� �� �������� � ��������������� �����.
//	������: -1.12, -2.43, 3.1, 4.2, 0, 6.4, - 7.5, 8.6, 9.1, -4
//	�����: 42.25, 45.25, 9.3, 16.8, 0, 38.4, 90.25, 68.8, 81.9,141.25

public class ex16 {

	public static void main(String[] args) {
		
		double[] arr = { -1.12 , -2.43 , 3.1 , 4.2 , 0 , 6.4 , - 7.5 , 8.6 , 9.1 , -4 };
		
		System.out.println("With this exercise we have 1 array with double values. The program changes the values of the original array and print them.");
		System.out.println("If a value is smaller than -0.231, it is changed with the sum of their cell number multiplied by their 2nd degree and sumed with 41.25.");
		System.out.println("Otherwise the value is replaced by the multiplication of it's cell number and value. The numbers of the cells start from 1.");
		System.out.println();
		
		System.out.println("Original array:");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < -0.231) {
				arr[i] = ((i+1) * (i+1)) + 41.25;
			} else {
				arr[i] = arr[i] * (i+1);
			}
		}
		System.out.println();
		System.out.println("Modified array:");
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			}
		}
		
	}

}
