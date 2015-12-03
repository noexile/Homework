
//	Задача 4:
//	Имате предварително въведени стойности на елементи в двумерен масив - естествени числа.
//	Да се състави програма, чрез която се извеждат стойностите на елементите в двумерен масив след обръщането му на +90 градуса.
//	Пример:
//	1,2,3,4
//	5,6,7,8
//	9,10,11,12
//	13,14,15,16
//	Изход
//	13,9,5,1
//	14,10,6,2
//	15,11,7,3
//	16,12,8,4

public class ex4 {

	public static void main(String[] args) {

		System.out.println("This example will print one 2d array and after that it will print it again but rotated by 90 degrees.");
		System.out.println();
		
		int[][] arr = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 }, 
				{ 13, 14, 15, 16 } 
		};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]);
				if (j < arr[j].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		
		System.out.println();
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = arr.length - 1; j >= 0; j--) {
				System.out.print(arr[j][i]);
				if (j > 0) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		
		
		
	}

}
