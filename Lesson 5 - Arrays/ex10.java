import java.util.Scanner;

//	Задача 10:
//	Да се състави програма, чрез която се въвеждат 7 цели числа в едномерен масив.
//	Програмата да изведе числото, което е най-близко до средната стойност на въведените числа.
//	Пример: 1,2,3,4,5,6,7
//	Изход: средна стойност 4, най-близка стойност 4

public class ex10 {

	public static void main(String[] args) {

		int[] arr = new int[7];
		int biggestNumber;
		int sum = 0;
		int average;
		
		boolean checker = false;
		boolean insideChecker = false;
		
		System.out.println("With this exercise we will input 7 numbers in an array. The program will check witch of the numbers is closest to the average velue.");
		System.out.println("");
		Scanner input = new Scanner(System.in);
		
		// inputs the array values to each element
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			arr[i] = input.nextInt();
		}
		
		// we find the biggest number
		biggestNumber = arr[0];
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (arr[i] > biggestNumber) {
				biggestNumber = arr[i];
			}
		}
		
		average = sum / 7; // we make an average sum of all 7 numbers
		
		for (int i = 0; i < biggestNumber / 2; i++) { // we use the biggest number divided by 2 in order to know how much maximum iterations we might have
			
			// we make variables that increase and decrease in order to check if a number from the array is equal to it
			int negativeSum = average - i;
			int positiveSum = average + i;
			
			for (int j = 0; j < arr.length; j++) {
				
				// we check if one of the numbers from the array equals to the negativeSum value or positiveSum value
				if (arr[j] == negativeSum || arr[j] == positiveSum) {
					if (arr[j] == negativeSum) { // we make 2 ifs because we might have 2 numbers that are in the same range from the average number
						System.out.println("The closest number to the average sum: " + average + " is element [" + (j+1) + "] with value: " + arr[j]);
					}
					if (arr[j] == positiveSum) {
						System.out.println("The closest number to the average sum: " + average + " is element [" + (j+1) + "] with value: " + arr[j]);
					}
					insideChecker = true; // inside checker that triggers when a number from the array is equal to the closest negativeSum value or positiveSum value
				}
				
				// an if witch allows the loop to end after all of the elements from the array are checked and in the same time one or more of them is triggered to be closest number to the average
				if (j == arr.length - 1 && insideChecker) {
					checker = true;
					break;
				}
			}
			
			// a trigger witch exits the outside loop after a number/s is/are triggered
			if (checker) {
				break;
			}
			
		}
		
		input.close();
	}

}
