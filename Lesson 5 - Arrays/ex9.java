import java.util.Scanner;

//	Задача 9:
//	Напишете програма, в която потребителя въвежда масив, след което елементите на масива се обръщат в обратен ред (Целта не е масива да
//	се отпечата в обратен ред, ами първо да се обърне, след което да се отпечата в нормален ред). Пробвайте да решите задачата първо с един
//	допълнителен масив и после без да използвате друг масив.

public class ex9 {

	public static void main(String[] args) {

		int[] arr;
		int arrSize;
		int temp;

		System.out.println("With this exercise we will input an array and its elements. After that it will print the array backwards.");
		System.out.println("We can enter only whole numbers - integers. The array must be gibber than 0.");
		System.out.println();

		Scanner input = new Scanner(System.in);

		// input the array size with limitation to the data N < 0
		do {
			System.out.print("Enter the array size: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);

		arr = new int[arrSize];

		// entering the values of the elements in the array
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			arr[i] = input.nextInt();
		}

		// copying the array's elements while using a temporary variable
		for (int i = 0; i < arr.length / 2; i++) {
			temp = arr[i];
			arr[i] = arr[arr.length - 1 - i];
			arr[arr.length - 1 - i] = temp;
		}

		// printing the array
		System.out.print("{ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			} else {
				System.out.print(" }");
			}

			input.close();
		}
	}
}

// option 2:
// copying the elements from the original to the copy array:
//
// int[] arr;
// int[] copyArray;
// int arrSize;
//
// System.out.println("With this exercise we will input an array and its elements. After that it will print the array backwards.");
// System.out.println("We can enter only whole numbers - integers. The array must be gibber than 0.");
// System.out.println();
//
// Scanner input = new Scanner(System.in);
//
// do {
//	 System.out.print("Enter the array size: ");
//	 arrSize = input.nextInt();
// } while (arrSize < 1);
//
// arr = new int[arrSize];
// copyArray = new int[arrSize];
//
// for (int i = 0; i < arr.length; i++) {
//	 System.out.print("Enter the " + (i+1) + " element: ");
//	 arr[i] = input.nextInt();
// }
//
// for (int i = 0; i < copyArray.length; i++) {
//	 copyArray[i] = arr[copyArray.length - i - 1];
// }
//
// System.out.print("{ ");
// for (int i = 0; i < copyArray.length; i++) {
//	 System.out.print(copyArray[i]);
//	 if (i < copyArray.length - 1) {
//		 System.out.print(", ");
//	 } else {
//		 System.out.print(" }");
//	 }
// }