import java.util.Scanner;

//	Задача 2:
//	Имате квадратен двумерен масив от естествени числа, чийто стойности се въвеждат от конзолата. Да се отпечатат диагоналите на масива.
//	Пример:
//	1,4,6,3
//	5,9,7,2
//	4,8,1,9
//	2,3,4,5
//	Изход:
//	1 9 1 5
//	3 7 8 2

public class ex2 {

	public static void main(String[] args) {
		
		int[][] arr;
		int arrSize;
		
		System.out.println("With this example we will input a 2d array size (as a square) and also its elements. Then we will print the values of the diagonals.");
		System.out.println("The size of the 2d array must be bigger than 1.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the square size: ");
			arrSize = input.nextInt();
		} while (arrSize < 2);
		
		arr = new int[arrSize][arrSize];
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print("Enter the value for " + (i+1) + " row, " + (j+1) + " value: ");
				arr[i][j] = input.nextInt();
			}
		}
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (i == j) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (j == arr.length -i - 1) {
					System.out.print(arr[i][j] + " ");
				}
			}
		}
		
		input.close();
	}
}
