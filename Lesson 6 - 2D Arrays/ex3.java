
//	Задача 3:
//	Имате двумерен масив от числа, чийто стойности са въведени предварително. 
//	Да се отпечатат сумата на елементите на масива, както и средноаритметичното на тези числа.

public class ex3 {

	public static void main(String[] args) {
		
		System.out.println("With this exercise we will read one 2d array and print the total sum of it's cell values as well as the average sum.");
		System.out.println();
		
		int[][] arr = { 
				{48,72,13,14,15},
				{21,22,53,24,75},
				{31,57,33,34,35},
				{41,95,43,44,45},
				{59,52,53,54,55},
				{61,69,63,64,65}
			  };
		int sum = 0;
		int average;
		int counter = 0;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[j].length; j++) {
				sum += arr[i][j];
				counter++;
			}
		}	
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[j].length; j++) {
				System.out.print(arr[i][j]);
				if (j < arr[j].length - 1) {
					System.out.print(", ");
				}
			}
			System.out.println();
		}
		
		average = sum / counter;
		
		System.out.println();
		System.out.println("The total sum of the 2d's elements is: " + sum);
		System.out.println("The average sum of the 2d's elements is: " + average);
	}

}
