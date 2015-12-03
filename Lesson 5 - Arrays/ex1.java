import java.util.Scanner;

//	Задача 1:
//	Да се прочете масив и да се намери най-малкото число кратно на 3 от масива.
//	10, 3, 5, 8, 6, -3, 7
//	Най-малкото число кратно на 3 е -3

public class ex1 {

	public static void main(String[] args) {

		int[] arr;
		int smallestNumber;
		int size;

		System.out.println("With this example we will read an array and print the smallest number in it that can be module divided (%) by 3.");
		System.out.println();
		Scanner input = new Scanner(System.in);

		do {
			System.out.print("Enter the array size: ");
			size = input.nextInt();
		} while (size < 1);

		arr = new int[size];

		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + i + " element: ");
			arr[i] = input.nextInt();
		}

		smallestNumber = arr[0];

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % 3 == 0 && arr[i] < smallestNumber) {
				smallestNumber = arr[i];

			}
		}

		if (smallestNumber % 3 == 0) {
			System.out.println(
					"The smallest number in the array that can be module divided (%) by 3 is: " + smallestNumber);
		} else {
			System.out.println("There is no number in the array that can be module divided (%) by 3 = 0");
		}

		input.close();
	}

}
