import java.util.Scanner;

//	Задача 4:
//	Да се прочете масив и да се отпечата дали е огледален.
//	Следните масиви са огледални:
//	[3 7 7 3]
//	[4]
//	[1 55 1]
//	[6 27 -1 5 7 7 5 -1 27 6]

public class ex4 {

	public static void main(String[] args) {

		int[] arr;
		int arrSize;

		boolean isMirrored = true;;
		
		System.out.println("With this exercise we will input an array's length and elements and then check if it is mirrored -> example [3 7 7 3]");
		System.out.println("The array size must be bigger than 1. We can enter only whole numbers - integers for this example.");
		System.out.println();
		
		Scanner input = new Scanner(System.in);
		
		do {
			System.out.print("Enter the array size: ");
			arrSize = input.nextInt();
		} while (arrSize < 1);
		
		arr = new int[arrSize];
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print("Enter the " + (i + 1) + " element: ");
			arr[i] = input.nextInt();
		}
		
		for (int i = 0; i < arr.length / 2; i++) {
			if (arr[i] != arr[arr.length - i - 1]) {
				isMirrored = false;
			}
		}
		System.out.println();
		System.out.print("{ ");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i < arr.length - 1) {
				System.out.print(", ");
			} else {
				System.out.println(" }");
			}
		}
		
		if (isMirrored) {
			System.out.println("The array is mirrored.");
		} else {
			System.out.println("The array NOT is mirrored.");
		}

		input.close();
	}

}
