
//	������ 1:
//	����� �������� ����� 6�5 �� ���������� �����, ����� ��������� �� �������� �������������.
//	�� �� ������� ��������, ���� ����� �� �������� ���������� �� ������ � ���-������� � ���-�������� ��������.
//	������:
//	48,72,13,14,15
//	21,22,53,24,75
//	31,57,33,34,35
//	41,95,43,44,45
//	59,52,53,54,55
//	61,69,63,64,65
//	�����:
//	���-����� 13;
//	���-������ 95

public class ex1 {

	public static void main(String[] args) {

		System.out.println("With this exercise we will go trough a 2d array and find the smallest and biggest number. Then the program will print the result.");
		System.out.println();
		
		int[][] arr = { 
						{48,72,13,14,15},
						{21,22,53,24,75},
						{31,57,33,34,35},
						{41,95,43,44,45},
						{59,52,53,54,55},
						{61,69,63,64,65}
					  };
		int biggestNumber;
		int smallestNumber;
		
		if (arr[0][0] > arr[0][1]) {
			biggestNumber = arr[0][0];
			smallestNumber = arr[0][1];
		} else {
			biggestNumber = arr[0][1];
			smallestNumber = arr[0][0];
		}	
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[j].length; j++) {
				if (!(i == 0 && j < 2)) {
					if (arr[i][j] > biggestNumber) {
						biggestNumber = arr[i][j];
					}
					if (arr[i][j] < smallestNumber) {
						smallestNumber = arr[i][j];
					}
				} 
			}
		}
		
		System.out.println("The smallest number in the 2d array is: " + smallestNumber);
		System.out.println("The biggest number in the 2d array is: " + biggestNumber);
		
	}
}
