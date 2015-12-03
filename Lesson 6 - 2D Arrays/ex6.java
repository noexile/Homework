
//	������ 6:
//	����� ������������� �������� ��������� �� ���������� �����. ������� �� �������� � ��������� ������� � ������� 6 ���� � 6 ������.
//	�� �� ������� ��������, ���� ����� �� ������ ������ �� ������ �������� �� �������� � ����� ������: 2,4 � 6.
//	���������� �� ������� � ������ �� ����� ������� ���.
//	������:
//	11,12,13,14,15,16,
//	21,22,23,24,25,26,
//	31,32,33,34,35,36,
//	41,42,43,44,45,46,
//	51,52,53,54,55,56,
//	61,62,63,64,65,66
//	�����:
//	21,22,23,24,25,26 ���� 141
//	41,42,43,44,45,46 ���� 261
//	61,62,63,64,65,66 ���� 381
//	���� �� ���������� 783

public class ex6 {

	public static void main(String[] args) {

		System.out.println("With this exercise we will go trough a 2d array with dimensions 6x6. The program will sum all of the elements from 2, 4, 6 rows.");
		System.out.println("Then it will print the result. Also in the end it will print the total sum of all rows.");
		System.out.println();
		
		int rowSum = 0;
		int totalSum = 0;
		int[][] arr = { 
						{ 11, 12, 13, 14, 15, 16 }, 
						{ 21, 22, 23, 24, 25, 26 }, 
						{ 31, 32, 33, 34, 35, 36 },
						{ 41, 42, 43, 44, 45, 46 }, 
						{ 51, 52, 53, 54, 55, 56 }, 
						{ 61, 62, 63, 64, 65, 66 } 
					  };
		
		for (int i = 1; i < arr.length; i+= 2) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
				rowSum += arr[i][j];
				if (j < arr[j].length - 1) {
					System.out.print(", ");
				} else {
					System.out.print(" = sum " + rowSum);
				}
			}
			System.out.println();
			totalSum += rowSum;
			rowSum = 0;
		}
		System.out.println("The sum of all the elements: " + totalSum);
	}

}
