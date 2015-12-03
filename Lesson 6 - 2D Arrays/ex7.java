
//	������ 7:
//	����� ������������� �������� ��������� �� ���������� �����, �������� � ��������� ������� � ������� 6 ���� � 6 ������.
//	�� �� ������� �������� , ���� ����� �� ������ ������ �� ������ ��������, ����� ���� �� ������� �� ��� � ������ � ����� �����.
//	���������� �� ������� ����������� ���� �� ����� ������� ��� �� ����������� �������, ����� � ������ ���� �� ���� ��������.
//	�� �� �������� ���� ���� �����.
//	������:
//	11,12,13,14,15,16,
//	21,22,23,24,25,26,
//	31,32,33,34,35,36,
//	41,42,43,44,45,46,
//	51,52,53,54,55,56,
//	61,62,63,64,65,66
//	�����:
//	11, ,13, ,15, , ���� �� ���������� �� ����: 39
//	22, ,24, ,26, ���� �� ���������� �� ����: 72
//	31, ,33, ,35, , ���� �� ���������� �� ����: 99
//	42, ,44, ,46, ���� �� ���������� �� ����: 132
//	51, ,53, ,55, , ���� �� ���������� �� ����: 159
//	62, ,64, ,66 ���� �� ���������� �� ����: 192
//	���� �� ����������: 693

public class ex7 {

	public static void main(String[] args) {
		
		System.out.println("With this exercise we will go trough a 2d array with dimensions 6x6. The program will sum all of the elements that row and column index sum is even number.");
		System.out.println("Then it will print the result. Also in the end it will print the total sum of all rows.");
		System.out.println();
		
		int rowSum = 0;
		int totalSum = 0;
		
		int index = 0;
		int row = 0;
		int col = 0;
		
		int[][] arr = { 
				{ 11, 12, 13, 14, 15, 16 }, 
				{ 21, 22, 23, 24, 25, 26 }, 
				{ 31, 32, 33, 34, 35, 36 },
				{ 41, 42, 43, 44, 45, 46 }, 
				{ 51, 52, 53, 54, 55, 56 }, 
				{ 61, 62, 63, 64, 65, 66 } 
			  };
		
		while (index < arr.length*arr.length) {
			
			if ((row + col) % 2 == 0) {
				System.out.print(arr[row][col]);
				if (col < (arr.length / 3) * 2) {
					System.out.print(", ");
				}
				rowSum += arr[row][col];
			}
						
			col++;
			
			if (col == 6) {
				col = 0;
				row++;
				System.out.print(" = sum " + rowSum);
				totalSum += rowSum;
				rowSum = 0;
				System.out.println();
			}
			
			index++;
		}
		
		System.out.println("The sum of all the elements: " + totalSum);
		
	}

}
