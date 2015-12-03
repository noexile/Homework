
//	������ 5:
//	�� �� ������� ��������, ��� ����� ������������� �� �������� ���������� ����� � �������� ����� 4*4 ��������.
//	���������� �� ������� �������� �� ���������� ����� � ������������� �� ���-�������� ���� �� ������ ������ ���-�������� ���� �� ������.
//	������:
//	1,2,3,4
//	5,6,7,8
//	9,10,11,12
//	13,14,15,16
//	�����:
//	���-������ ���� �� ������ 58
//	���-������ ���� �� ������ 40
//	������������ ���� �� ������ � > �� ������������ ���� �� ������

public class ex5 {

	public static void main(String[] args) {

		int[][] arr = { 
						{ 1, 2, 3, 4 }, 
						{ 5, 6, 7, 8 }, 
						{ 9, 10, 11, 12 }, 
						{ 13, 14, 15, 16 } 
					  };
		int[] columnsSum = new int[arr.length];
		int maxRowSum = 0;
		int maxColumnSum;
		int tempSum = 0;

		for (int i = 0; i < 1; i++) {

		}

		for (int i = 0; i < arr.length; i++) {
			if (i == 0) { // making the first row by default the with max sum
				for (int j = 0; j < arr.length; j++) {
					maxRowSum += arr[i][j];
				}
			} else { // loop that checks if the current row has bigger sum of the current one
				for (int j = 0; j < arr.length; j++) {
					tempSum += arr[i][j];
				}
				if (tempSum > maxRowSum) {
					maxRowSum = tempSum;
				}
				tempSum = 0; // reseting the sum
			}
			
			for (int j = 0; j < columnsSum.length; j++) { // adding the sum of all columns
				columnsSum[j] += arr[i][j];
			}
		}
		
		// checking witch column's sum is the biggest
		maxColumnSum = columnsSum[0];
		
		for (int i = 1; i < columnsSum.length; i++) {
			if (columnsSum[i] > maxColumnSum) {
				maxColumnSum = columnsSum[i];
			}
		}
		
		// printing the results
		System.out.println("The max sum by rows is: " + maxRowSum);
		System.out.println("The max sum by columns is: " + maxColumnSum);
		System.out.println();
		
		if (maxRowSum == maxColumnSum) {
			System.out.println("The max sum by rows: " + maxRowSum + " = " + "The max sum by columns: " + maxColumnSum);
		} else if(maxRowSum > maxColumnSum) {
			System.out.println("The max sum by rows: " + maxRowSum + " > " + "The max sum by columns: " + maxColumnSum);
		} else {
			System.out.println("The max sum by rows: " + maxRowSum + " < " + "The max sum by columns: " + maxColumnSum);
		}
	}

}
