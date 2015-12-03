import java.util.Scanner;

//	Задача 15:
//	Да се състави програма, която въвежда в едномерен масив реални числа.
//	Като изход: програма извежда онези 3 различни числа, чиято абсолютна стойност формира максималната обща сума.
//	Пример: 7.13; 0.2; 4.9; 5.1; 6.34; 1.12
//	Изход: 5.1; 6.34; 7.13

public class ex15 {

	public static void main(String[] args) {
		
		double[] arr;
		int arrSize;
		double biggestNumber;
		double middleNumber;
		double smallestNumber;
		
		System.out.println("With this exercise we will craate an array and input values in its cells. After that we will find and print the biggest 3 numbers.");
		System.out.println("For this example we can use double values as well as whole numbers. The array must be bigger than 3.");
		System.out.println();
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the array size: ");
			arrSize = input.nextInt();
		} while (arrSize < 3);
		
		arr = new double[arrSize];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the value for cell " + (i+1) + ": ");
			arr[i] = input.nextDouble();
		}
		
		// we take the first 3 numbers from the array and order them as biggest , middle and smallest		
		if (arr[0] == arr[1] && arr[0] == arr[2]) { // a == b == c
			biggestNumber = arr[0];
			middleNumber = arr[1];
			smallestNumber = arr[2];
		} else if (arr[0] == arr[1]) { // a == b
			if (arr[0] > arr[2]) { // a == b && a > c
				biggestNumber = arr[0];
				middleNumber = arr[1];
				smallestNumber = arr[2];
			} else { // a == b && c > a
				biggestNumber = arr[2];
				middleNumber = arr[0];
				smallestNumber = arr[1];
			}
		} else if (arr[1] == arr[2]) { // b == c
			if (arr[0] > arr[1]) { // b == c && a > b
				biggestNumber = arr[0];
				middleNumber = arr[1];
				smallestNumber = arr[2];
			} else {// b == c && b > a
				biggestNumber = arr[1];
				middleNumber = arr[2];
				smallestNumber = arr[0];
			}
		} else if (arr[0] == arr[2]) { // a == c
			if (arr[1] > arr[0]) { // a == c && b > a
				biggestNumber = arr[1];
				middleNumber = arr[0];
				smallestNumber = arr[2];
			} else { // a == c && a > b
				biggestNumber = arr[0]; 
				middleNumber = arr[2];
				smallestNumber = arr[1];
			}
		} else if (arr[0] > arr[1] && arr[0] > arr[2]) { // a > b && a > c
			biggestNumber = arr[0];
			if (arr[1] > arr[2]) { // a > b && b > c
				middleNumber = arr[1];
				smallestNumber = arr[2];
			} else { // a > b && c > b
				middleNumber = arr[2];
				smallestNumber = arr[1];
			}
		} else if (arr[1] > arr[0] && arr[1] > arr[2]) { // b > a && b > c
			biggestNumber = arr[1];
			if (arr[0] > arr[2]) { // b > a && a > c
				middleNumber = arr[0];
				smallestNumber = arr[2];
			} else { // b > a && c > a
				middleNumber = arr[2];
				smallestNumber = arr[0];
			}
		} else { // c > a && c > b
			biggestNumber = arr[2];
			if (arr[0] > arr[1]) { // c > a && a > b
				middleNumber = arr[0];
				smallestNumber = arr[1];
			} else { // c > a && b > a
				middleNumber = arr[1];
				smallestNumber = arr[0];
			}
		}
		
		for (int i = 3; i < arr.length; i++) {
			if (arr[i] > biggestNumber) {
				smallestNumber = middleNumber;
				middleNumber = biggestNumber;
				biggestNumber = arr[i];
			} else if (arr[i] > middleNumber) {
				smallestNumber = middleNumber;
				middleNumber = arr[i];
			} else if (arr[i] > smallestNumber) {
				smallestNumber = arr[i];
			}
		}
		
		
		System.out.print(smallestNumber + "; ");
		System.out.print(middleNumber + "; ");
		System.out.print(biggestNumber);
		
		input.close();
	}

}
